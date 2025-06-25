package com.kh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.domain.Item;
import com.kh.service.ItemMapperService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/item")
@MapperScan(basePackages = "com.kh.mapper")
public class ItemController {

	@Autowired
	private ItemMapperService itemService;
	// 저장장소 경로설정
	@Value("${upload.path}")
	private String uploadPath;

	// 자료 리스트화면요청
	@GetMapping(value = "/list")
	public String list(Model model) throws Exception {
		List<Item> itemList = this.itemService.list();
		model.addAttribute("itemList", itemList);
		return "item/list";
	}

	// 자료입력화면
	@GetMapping(value = "/register")
	public String registerForm(Model model) {
		model.addAttribute("item", new Item());
		return "item/register";
	}

	// 자료입력내용저장(파일을 외부저장소 저장 완료후, 주소를 디 저장)
	@PostMapping(value = "/register")
	public String register(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();

		log.info("originalName: " + file.getOriginalFilename());
		log.info("size: " + file.getSize());
		log.info("contentType: " + file.getContentType());
		// uploadFile(String originalName, byte[] fileData) 구조
		// 업로드된 파일을 외부저장소에 저장하고, 그 저장된 파일명을 리턴해주는 함수이다.
		// 중복되지않는파일명_kkk.jpg, _kkk.jpg -> c:/upload/중복되지않는파일명_kkk.jpg
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		item.setPictureUrl(createdFileName);
		this.itemService.create(item);
		model.addAttribute("msg", "등록이 완료되었습니다.");

		return "item/success";
	}

	// 외부저장소에 자료 업로드 파일명 생성후 저장
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();
		// 파일의 이름 설정
		String createdFileName = uid.toString() + "_" + originalName;
		// 중복이 안되는 주소를 가진 파일생성
		File target = new File(uploadPath, createdFileName);
		// 원본파일을 대상파일에 복사해주는 함수
		FileCopyUtils.copy(fileData, target);
		return createdFileName;
	}

	// 수정할 내용을 요청
	@GetMapping(value = "/modify")
	public String modifyForm(Item item, Model model) throws Exception {
		Item _item = this.itemService.read(item);
		model.addAttribute("item", _item);
		return "item/modify";
	}

	// 수정할 내용 디비에 저장
	@PostMapping(value = "/modify")
	public String modify(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();

		if (file != null && file.getSize() > 0) {
			Item oldItem = itemService.read(item);
			// 기존에 있는 외부저장소에 있는 파일을 삭제
			String oldPitureUrl = oldItem.getPictureUrl();
			// c:upload/~~uuid_kkk.jpg => 파일로 인식되는 객체가 되는 순간
			deleteFile(oldPitureUrl);
			log.info("originalName: " + file.getOriginalFilename());
			log.info("size: " + file.getSize());
			log.info("contentType: " + file.getContentType());

			String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());

			item.setPictureUrl(createdFileName);
		}
		itemService.update(item);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "item/success";
	}

	// 삭제화면 요청
	@GetMapping(value = "/remove")
	public String removeForm(Item item, Model model) throws Exception {
		Item _item = this.itemService.read(item);
		model.addAttribute("item", _item);
		return "item/remove";
	}

	// 삭제내용 저장
	@PostMapping(value = "/remove")
	public String remove(Item item, Model model) throws Exception {
		Item oldItem = itemService.read(item);
		// 기존에 있는 외부저장소에 있는 파일을 삭제
		String oldPictureUrl = oldItem.getPictureUrl();
		boolean flag = deleteFile(oldPictureUrl);
		if(flag == true) {
			itemService.delete(item);
			model.addAttribute("msg", "삭제가 완료되었습니다.");
		}else {
			model.addAttribute("msg", "외부저장소 삭제가 문제발생했습니다.");
		}


		return "item/success";
	}

	private boolean deleteFile(String fileName) throws Exception {
		
		if(fileName.contains("..")) {
			throw new IllegalArgumentException("예외처리 발생");
		}
		File file = new File(uploadPath,fileName);
		
		return (file.exists() == true)?(file.delete()):(false); 

	}

	@ResponseBody
	@RequestMapping("/display")
	public ResponseEntity<byte[]> displayFile(Item item) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		Item _item = itemService.getPicture(item);
		String fileName = _item.getPictureUrl();
		log.info("FILE NAME: " + fileName);
		try {
			//uuid_kkk.jpg = "jpg"
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = getMediaType(formatName);
			//httpHeader 이미지 미디어타입을 설정
			HttpHeaders headers = new HttpHeaders();
			//c:/upload/uuid_kkk.jpg
			in = new FileInputStream(uploadPath + File.separator + fileName);

			if (mType != null) {
				headers.setContentType(mType);
			}

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	//멀티미디어 타입을 리턴 "jpg" => MediaType.IMAGE_JPEG
	private MediaType getMediaType(String formatName) {
		if (formatName != null) {
			if (formatName.equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}

			if (formatName.equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}

			if (formatName.equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}

		return null;
	}

}

package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.common.domain.CodeLabelValue;
import com.kh.domain.CodeDetail;
import com.kh.service.CodeDetailService;
import com.kh.service.CodeService;

@Controller
@RequestMapping("/codedetail")
@PreAuthorize("hasRole('ROLE_ADMIN')") 
public class CodeDetailController {
	@Autowired
	private CodeDetailService codeDetailService;

	@Autowired
	private CodeService codeService;

	// 코드디테일 등록화면 요청
	@GetMapping(value = "/register")
	public String registerForm(Model model) throws Exception {
		CodeDetail codeDetail = new CodeDetail();
		model.addAttribute("codeDetail", codeDetail);

		// 그룹코드 목록(그룹코드, 그룹토드이름)을 조회하여 뷰에 전달
		List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
		model.addAttribute("groupCodeList", groupCodeList);
		return "codedetail/register";
	}

	// 코드디테일 등록
	@PostMapping(value = "/register")
	public String register(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		// 선택된 코드그룹코드 쵀대갯수 +1 -> 코드디테일 등록
		codeDetailService.register(codeDetail);

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}

	// 코드디테일 리스트
	@GetMapping(value = "/list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", codeDetailService.list());
		return "codedetail/list";
	}

	// 코드디테일 상세화면
	@GetMapping("/read")
	public String read(CodeDetail codeDetail, Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		// 그룹코드 목록을 조회하여 뷰에 전달
		List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
		model.addAttribute("groupCodeList", groupCodeList);
		return "codedetail/read";
	}

	// 코드디테일 수정화면
	@GetMapping("/modify")
	public String modifyForm(CodeDetail codeDetail, Model model) throws Exception {
		model.addAttribute(codeDetailService.read(codeDetail));
		// 그룹코드 목록을 조회하여 뷰에 전달
		List<CodeLabelValue> groupCodeList = codeService.getCodeGroupList();
		model.addAttribute("groupCodeList", groupCodeList);
		return "codedetail/modify";
	}

	// 코드디테일 수정
	@PostMapping(value = "/modify")
	public String modify(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		codeDetailService.modify(codeDetail);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/codedetail/list";
	}

	// 코드디테일 삭제
	@PostMapping(value = "/remove")
	public String remove(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		codeDetailService.remove(codeDetail);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codedetail/list";
	}

}

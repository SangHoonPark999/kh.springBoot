package com.kh.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.domain.MyBatisBoard;
import com.kh.service.BoardDAOService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@MapperScan(basePackages = "com.kh.mapper")
@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDAOService service;

	// 게시판 입력화면 요청
	@GetMapping(value = "/register")
	public String registerForm(MyBatisBoard board, Model model) throws Exception {
		log.info("registerForm");
		model.addAttribute("board", board);
		return "board/register";
	}
	//게시판 디비입력요청
	@PostMapping(value = "/register")
	public String register(MyBatisBoard board, Model model) throws Exception {
		service.insert(board);
		model.addAttribute("msg", "수정이 완료되었습니다.");
		return "board/success";
	}
	//게시판 리스트 화면요청
	@GetMapping(value = "list")
	public String modify(Model model) throws Exception {
		log.info("list");
		model.addAttribute("list", service.selectAll());
		
		return "board/list";
	}
	//게시판 상세 화면 요청
	@GetMapping(value = "/read") 
	public String read(MyBatisBoard board, Model model) throws Exception { 
	model.addAttribute("board",service.select(board)); 
	return "board/read";
	}
	
	//게시판 삭제요청
	@PostMapping(value = "/remove") 
	public String remove(MyBatisBoard board, Model model) throws Exception { 
	service.delete(board); 
	model.addAttribute("msg", "삭제가 완료되었습니다."); 
	return "board/success"; 
	}
	
	//게시판 수정화면요청
	@GetMapping(value = "/modify") 
	public String modifyForm(MyBatisBoard board, Model model) throws Exception { 
	model.addAttribute("board",service.select(board));
	return "board/modify"; 
	}
	
	//게시판 수정요청
	@PostMapping(value = "/modify") 
	public String modify(MyBatisBoard board, Model model) throws Exception { 
	service.update(board); 
	model.addAttribute("board", board); 
	model.addAttribute("msg", "수정이 완료되었습니다."); 
	return "board/success"; 
	}
}

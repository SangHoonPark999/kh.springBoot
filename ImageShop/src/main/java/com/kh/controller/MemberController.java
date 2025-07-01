package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.common.domain.CodeLabelValue;
import com.kh.domain.Member;
import com.kh.service.CodeService;
import com.kh.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private MemberService service;
	@Autowired
	private CodeService codeService;
	// 스프링 시큐리티의 비밀번호 암호처리
	@Autowired
	private PasswordEncoder passwordEncoder;

	// 회원가입 화면
	@GetMapping("/register")
	public String registerForm(Member member, Model model) throws Exception {
		// 직업코드 목록을 조회하여 뷰에 전달
		String groupCode = "a00";
		List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
		model.addAttribute("jobList", jobList);
		return "user/register";
	}

	// 회원가입
	@PostMapping("/register")
	public String register(@Validated Member member, BindingResult result, Model model, RedirectAttributes rttr)
			throws Exception {
		if (result.hasErrors()) {
			// 직업코드 목록을 조회하여 뷰에 전달
			String groupCode = "a00";
			List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
			model.addAttribute("jobList", jobList);

			return "user/register";
		}
		// 비밀번호 암호화
		String inputPassword = member.getUserPw();
		member.setUserPw(passwordEncoder.encode(inputPassword));

		service.register(member);

		rttr.addFlashAttribute("userName", member.getUserName());
		return "redirect:/user/registerSuccess";
	}

	// 등록 성공 페이지
	@GetMapping("/registerSuccess")
	public String registerSuccess(Model model) throws Exception {
		return "user/registerSuccess";
	}

	// 회원 목록
	@GetMapping(value = "/list")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String list(Model model) throws Exception {
		model.addAttribute("list", service.list());
		return "user/list";
	}

	// 회원상세 정보
	@GetMapping(value = "/read")
	public String read(Member member, Model model) throws Exception {
		// 직업코드 목록을 조회하여 뷰에 전달
		String groupCode = "a00";
		List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);

		model.addAttribute("jobList", jobList);
		model.addAttribute(service.read(member));
		return "user/read";
	}

	// 수정 페이지
	@GetMapping(value = "/modify")
	public void modifyForm(Member member, Model model) throws Exception {
		// 직업코드 목록을 조회하여 뷰에 전달
		String groupCode = "a00";
		List<CodeLabelValue> jobList = codeService.getCodeList(groupCode);
		model.addAttribute("jobList", jobList);
		model.addAttribute(service.read(member));
	}

	// 회원 정보 수정
	@PostMapping(value = "/modify")
	public String modify(Member member, RedirectAttributes rttr) throws Exception {
		service.modify(member);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/user/list";
	}

	// 회원정보 삭제
	@PostMapping(value = "/remove")
	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public String remove(Member member, RedirectAttributes rttr) throws Exception {
		service.remove(member);
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/user/list";
	}
	// 최초관리자 생성화면
	@GetMapping(value = "/setup")
	public String setupAdminForm(Member member, Model model) throws Exception {
		// 회원 테이블 데이터 건수를 확인하여 최초 관리자 등록 페이지를 표시한다.
		if (service.countAll() == 0) {
			return "user/setup";
		}
		// 회원 테이블에 회원이 존재하면 최초 관리자를 생성불가
		return "user/setupFailure";
	}

	// 최초관리자 생성
	@PostMapping(value = "/setup")
	public String setupAdmin(Member member, RedirectAttributes rttr) throws Exception {
		// 회원 테이블 데이터 건수를 확인하여 빈 테이블이면 최초 관리자를 생성한다.
		if (service.countAll() == 0) {
			String inputPassword = member.getUserPw();
			member.setUserPw(passwordEncoder.encode(inputPassword));
			member.setJob("00");
			
			service.setupAdmin(member);
			rttr.addFlashAttribute("userName", member.getUserName());
			return "redirect:/user/registerSuccess";
		}
		// 회원 테이블에 데이터가 존재하면 최초 관리자를 생성할 수 없으므로 실패 페이지로 이동한다.
		return "redirect:/user/setupFailure";
	}
	
	//로그인 실패 에러 페이지
	@GetMapping(value = "/accessError")
	public String accessErrorForm(Member member, Model model) throws Exception {
		return "user/accessError";
	}

}

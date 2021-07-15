package com.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.dto.Member;
import com.work.service.Memberservice;

@Controller
public class MemberController {
	
	@Autowired
	public Memberservice memberService;
	
	// return 페이지로 이동 : jsp
	// application.properties
	// spring.mvc.view.prefix=/WEB-INF/jsp/
	// spring.mvc.view.suffix=.jsp
	@RequestMapping("/main")
	public String main() {
		return "main"; // /WEB-INF/jsp/main.jsp
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}

//	@RequestMapping("/doLogin")
//	public void login(HttpServletRequest request) {
//		System.out.println("login 요청");
//		String memberId = request.getParameter("memberId");
//		String memberPw = request.getParameter("memberPw");
//		System.out.println(memberId + ", " + memberPw);
//		//return "login";
//	}
	
	@RequestMapping("/login")
	public String login(String memberId, String memberPw, Model model) {
		System.out.println("login 요청");
		System.out.println(memberId + ", " + memberPw);
		
		String grade = memberService.login(memberId, memberPw);
		System.out.println("login grade :: " + grade);
		
		if(grade != null) {
			model.addAttribute("message", "[login user] :: " + memberId);
		} else {
			model.addAttribute("message", "[login fail] 로그인 정보를 다시 확인하세요");
		}
		return "result";
	}

//	@RequestMapping("/login")
//	public void login(Member dto) {
//		System.out.println("login 요청");
//		System.out.println(dto.getMemberId() + ", " + dto.getMemberPw());
//	}

	@RequestMapping("/join")
	public String join(Member dto, Model model) {
		System.out.println("join 요청");
		System.out.println(dto);
		int row = memberService.getSize();
		
		memberService.join(dto.getMemberId(), dto.getMemberPw(), dto.getName(), dto.getMobile(), dto.getEmail());
		System.out.println(dto);
		
		if(memberService.getSize() > row) {
			model.addAttribute("message", "[join user] :: " + dto.getMemberId());
		} else {
			model.addAttribute("message", "[join user fail] 회원가입 실패");
		}
		return "loginForm";		
	}

//	@RequestMapping("/member/size")
//	@ResponseBody
//	public int size() {
//		return memberService.getSize();
//	}

//	@RequestMapping(value = "/member/size", method = RequestMethod.POST)
//	@ResponseBody
//	public int size() {
//		return memberService.getSize();
//	}
	
	//@PostMapping("/member/size")
	@GetMapping("/member/size")
	@ResponseBody
	public int size() {
		return memberService.getSize();
	}
	
	
	
}

package com.work.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.dto.Member;
import com.work.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	public MemberService memberService;
	
	@RequestMapping("/main")
	public String main() {
		return "main"; 
	}
	
	@RequestMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	

	@RequestMapping("/join")
	public String join(Member dto, Model model) {
		System.out.println("join 요청");
		System.out.println("service 이전 :: " + dto);		
		int result = memberService.addMember(dto);
		System.out.println("service 이후 :: " + dto);
		
		if(result == 1) {
			model.addAttribute("message", "[join user] :: ");
			return "loginForm";
		} else {
			model.addAttribute("message", "[join user] :: FAIL ");
			return "result";
		}
	}
	
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

	
}

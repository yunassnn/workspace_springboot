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
	public String join(String memberId, String memberPw, String name, String mobile, String email, Model model) {
		System.out.println("join 요청");
		System.out.println(memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email);
		int row = memberService.getSize();
		
		Member dto = memberService.join(memberId, memberPw, name, mobile, email);
		
		System.out.println(dto);
		
		if(memberService.getSize() > row) {
			model.addAttribute("message", "[join user] :: " + dto.getMemberId());
		} else {
			model.addAttribute("message", "[join user fail] 회원가입 실패");
		}
		return "loginForm";		
	}
	
	@GetMapping("/member/size")
	@ResponseBody
	public int size() {
		return memberService.getSize();
	}
	
	@RequestMapping("/allList")
	@ResponseBody
	public ArrayList<Member> all() {
		return memberService.allList();
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

	@RequestMapping("/login/param")
	public String loginMap(@RequestParam(value = "id") String memberId, @RequestParam(value = "pw") String memberPw) {
		System.out.println(memberId + ", " + memberPw);
		return null;
	}

	@RequestMapping("/login/null")
	public String loginNull(@RequestParam(required = true, defaultValue = "user01") String memberId, @RequestParam(required = true, defaultValue = "password01") String memberPw) {
		System.out.println(memberId + ", " + memberPw);
		return "main";
	}
	
}

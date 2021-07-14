package com.work.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.work.dto.Member;

@Controller
public class HomeController {

	@RequestMapping
	@ResponseBody
	public String home() {
		return "main start screen";
	}

	@RequestMapping("/array")
	@ResponseBody
	public int[] showArray() {
		// return new int[] {10, 20, 30};
		int[] nos = new int[5];
		for (int i = 0, init = 10; i < 3; i++, init += 10) {
			nos[i] = init;
		}
		return nos;	// JSON [10, 20, 30]
	}
	
	@RequestMapping("/member")
	@ResponseBody
	public Member showMember() {
		// 회원객체 출력
		Member dto = new Member("user01","password01","홍길동동","01012341234","user01@naver.com","2020-05-14","G",1000,"rladlqkr");
		System.out.println(dto); // Member(memberId=user01, memberPw=password01,
		return dto; // JSON 형태 {"memberId":"user01","memberPw":"password01"...
		
	}
	
	@RequestMapping("/member2")
	@ResponseBody
	public Member showMember2() {
		//Member dto = new Member("user01", "password01","강감찬");
		//Member dto = new Member("강감찬", "password01","user01", "01012341234");
		// 일부 데이터 지정 객체 생성 
		// 순서도 임의로 지정해서 생성
		// @Builder (Builder Pattern)
		// @Builder를 이용한 객체 생성 방법 : 클래스명.builder().프로퍼티명(data).프로퍼티명(data).build();
		return Member.builder().memberId("bluesky").mobile("01012341234").build();
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<String> showList() {
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("안녕");
		return list;	// JSON ARRAY : ["hello", "안녕"]
	}

	@RequestMapping("/map")
	@ResponseBody
	public Map<String, Object> showMemberMap() {
		Member dto1 = Member.builder().memberId("user11").mobile("22222222").name("김이박").build();
		Member dto2 = Member.builder().memberId("user12").mobile("33332222").name("송").build();
		Member dto3 = Member.builder().memberId("user13").mobile("44442222").name("정").build();
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put(dto1.getMemberId(), dto1);
		map1.put(dto2.getMemberId(), dto2);
		map1.put(dto3.getMemberId(), dto3);
		
		Map<String, Object> map2 = new LinkedHashMap<String, Object>();
		map2.put(dto1.getMemberId(), dto1);
		map2.put(dto2.getMemberId(), dto2);
		map2.put(dto3.getMemberId(), dto3);
		
		// 반환타입이 interface 이어서 유연한 어플리케이션 : Map 을 구현한 모든 Map 클래스 사용 가능함 
		return map1; // HashMap : 순서보장 x / LinkedHashMap : 순서 o
	}
	
	
	
	
	
}

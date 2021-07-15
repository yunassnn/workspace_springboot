package com.work.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.work.dto.Member;
import com.work.util.Utility;

@Service
public class MemberService {
	
	// ArrayList<Member> 멤버변수 선언 및 생성 : 회원들의 자료 저장구조 
	ArrayList<Member> list = new ArrayList<Member>();
	
	// initMember() 메서드에서 3명의 회원 등록 구현 
	
	
	public MemberService() {
		initMember();
		System.out.println("MemberService() constructor loading");
	}
	
	public void initMember() {
		Member dto1 = Member.builder().memberId("user01").memberPw("password01").name("홍길동").mobile("01011111111").email("user01@work.com").entryDate("2017-05-17").grade("G").mileage(1000).manager(null).build();
		Member dto2 = Member.builder().memberId("user02").memberPw("password02").name("송").mobile("01011112222").email("user02@work.com").entryDate("2017-05-17").grade("S").mileage(5000).manager("동").build();
		Member dto3 = Member.builder().memberId("user03").memberPw("password03").name("동").mobile("01011113333").email("user03@work.com").entryDate("2017-05-17").grade("A").mileage(0).manager(null).build();
	
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
	}
	
	public int getSize() {
		return list.size();
	}
	
	/** 로그인 */
	public String login(String memberId, String memberPw) {
		for(Member dto : list) {
			if(dto.getMemberId().equals(memberId) && dto.getMemberPw().equals(memberPw)) {
				return dto.getGrade();
			}
		}
		return null;
	}
	
	public Member join(String memberId, String memberPw, String name, String mobile, String email) {
		
		Member dto = Member.builder().memberId(memberId).memberPw(memberPw).name(name).mobile(mobile).email(email).entryDate(Utility.getCurrentDate()).grade("G").mileage(1000).manager(null).build();
		System.out.println(dto);
		list.add(dto);
		
		return dto;
	}
	
	public ArrayList<Member> allList() {
		System.out.println(list);
		return list;
	}
	
	
}
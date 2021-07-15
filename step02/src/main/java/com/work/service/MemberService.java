package com.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.dao.MemberDao;
import com.work.dto.Member;
import com.work.util.Utility;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	/** login */
	public String login(String memberId, String memberPw) {
		String grade = memberDao.login(memberId, memberPw);
		System.out.println("member grade :: " + grade);
		return grade;
	}

	/** join */
	public int addMember(Member dto) {
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setGrade("G");
		dto.setMileage(1000);
		
		return memberDao.insertMember(dto);
	}
	
	/** select all member */
	public List<Member> selectMemberList() {
		
		return memberDao.selectMemberList();
	}
	
	/** select member */
	public Member selectMember(String memberId) {
		
		return memberDao.selectMember(memberId);
	}
	
	/** update member */
	public boolean updateMember(String memberId, String memberPw, String name, String mobile, String email) {
		
		return memberDao.updateMember(memberId, memberPw, name, mobile, email);
	}
	
	/** delete member */
	public boolean deleteMember(String memberId) {
		
		return memberDao.deleteMember(memberId);
	}
	
	
	
	
	
}
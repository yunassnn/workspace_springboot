package com.work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *  회원 도메인 클래스 9개 속성 정의 
 *	toString() 재정의시 : 비밀번호. 휴대폰은 제외
 * 
 */
//@Data
@Getter
@Setter
@ToString(exclude = {"memberPw", "mobile"}, includeFieldNames = false)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Member {
	
	private String memberId;
	
	//@ToString.Exclude 
	private String memberPw;
	
	private String name;
	
	//@ToString.Exclude
	private String mobile;
	
	private String email;
	
	private String entryDate;
	
	private String grade;
	
	private int mileage;
	
	private String manager;
	
	
}

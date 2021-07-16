package com.work.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
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
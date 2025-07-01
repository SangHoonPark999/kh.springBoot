package com.kh.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MemberAuth {
	
	private int userNo; 
	private String auth;
}

package com.kh.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Member {
	
	private int userNo;
	@NotBlank
	private String userId;
	@NotBlank
	private String userPw;
	@NotBlank
	private String userName;
	private String job;
	private int coin;
	private boolean enabled;
	private Date regDate;
	private Date updDate;
	 
	private List<MemberAuth> authList;
}

package com.kh.domain;

import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private int coin;
	private Date regDate;
	private Date updDate;
	private String enabled;
	//1 : N 방식
	private List<MemberAuth> authList;
}

package com.kh.mapper;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberMapper {
	
	// 회원등록
	public void create(Member member) throws Exception;
	// 멤버권한 생성
	public void createAuth(MemberAuth memberAuth) throws Exception;
	
}

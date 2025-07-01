package com.kh.service;

import com.kh.domain.Member;

public interface MemberService {
	
	// 등록 처리 
	public void register(Member member) throws Exception;
}

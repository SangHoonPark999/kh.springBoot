package com.kh.service;

import java.util.List;

import com.kh.domain.Member;

public interface MemberService {

	// 회원권한 생성, 등록
	public void register(Member member) throws Exception;

	// 회원 목록
	public List<Member> list() throws Exception;

	// 회원상세 정보
	public Member read(Member member) throws Exception;

	// 회원정보 수정
	public void modify(Member member) throws Exception;

	// 회원정보 삭제
	public void remove(Member member) throws Exception;

	// 회원 테이블의 데이터 건수를 반환
	public int countAll() throws Exception;

	// 최초 관리자 생성을 위한 데이터를 등록한다.
	public void setupAdmin(Member member) throws Exception;

}

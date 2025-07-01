package com.kh.mapper;

import java.util.List;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberMapper {

	// 회원등록
	public void create(Member member) throws Exception;

	// 회원권한 생성
	public void createAuth(MemberAuth memberAuth) throws Exception;

	// 회원 목록
	public List<Member> list() throws Exception;

	// 회원상세 정보
	public Member read(Member member) throws Exception;

	// 회원권한 수정
	public void modifyAuth(MemberAuth memberAuth) throws Exception;

	// 회원정보 수정
	public void update(Member member) throws Exception;
	
	// 회원정보 삭제
	public void delete(Member member) throws Exception;
	
	// 회원권한 삭제 
	public void deleteAuth(Member member) throws Exception;

	// 회원 테이블의 데이터 건수 조회 
	public int countAll() throws Exception;
	
	// 사용자 아이디로 회원 정보 조회 
	public Member readByUserId(String userId);

}

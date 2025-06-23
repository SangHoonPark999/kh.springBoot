package com.kh.mapper;

import java.util.List;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberDAO {
	
	//회원 삽입
	public void insert(Member member) throws Exception; 
	//회원 권한 삽입
	public void insertAuth(MemberAuth memberAuth) throws Exception;
	//회원정보 리스트
	public List<Member> selectAll() throws Exception;
	//회원 정보 출력(조인)
	public Member selectJoin(Member member) throws Exception;
	//회원 정보 수정
	public void update(Member member) throws Exception;
	//회원정보 삭제
	public void delete(Member member) throws Exception;
	//회원권한 정보삭제
	public void deleteAuth(Member member) throws Exception;
	
	
	
}
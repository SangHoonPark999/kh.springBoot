package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.mapper.MemberDAO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//insert, update, delete에만 Transactional 설정
	//회원등록처리, 회원권한처리
	@Override
	@Transactional
	public void insert(Member member) throws Exception {
		//회원등록 처리
		memberDAO.insert(member);
		//회원권한생성
		MemberAuth memberAuth = new MemberAuth(); 
		//회원권한설정
		memberAuth.setNo(member.getNo());
		memberAuth.setAuth("ROLE_USER");
		//회원권한 처리
		memberDAO.insertAuth(memberAuth);
	}

	@Override
	@Transactional
	//회원권한 입력처리
	public void insertAuth(MemberAuth memberAuth) throws Exception {
		memberDAO.insertAuth(memberAuth);

	}

	@Override
	//회원정보출력 리스트
	public List<Member> selectAll() throws Exception {
		return memberDAO.selectAll();
	}

	@Override
	//회원정보 출력(조인)
	public Member selectJoin(Member member) throws Exception {
		return memberDAO.selectJoin(member);
	}
	//회원 정보 수정
	@Override
	@Transactional
	//회원정보 출력
	public void update(Member member) throws Exception {
		//회원정보 수정입력
		memberDAO.update(member);
		//회원권한 삭제
		memberDAO.deleteAuth(member); 
		 
		int userNo = member.getNo(); 
		//수정된 회원권한 입력
		List<MemberAuth> authList = member.getAuthList(); 
		for (int i = 0; i < authList.size(); i++) 
		{ MemberAuth memberAuth = authList.get(i); 
		String auth = memberAuth.getAuth(); 
		if (auth == null) { 
		continue; 
		} 
		if (auth.trim().length() == 0) 
		{ continue; 
		} 
		memberAuth.setNo(userNo); 
		memberDAO.insertAuth(memberAuth); 
		}
	}
	@Override
	@Transactional
	//회원정보삭제
	public void delete(Member member) throws Exception {
		memberDAO.deleteAuth(member); // 삭제 순서 
		memberDAO.delete(member);
	}

	@Override
	@Transactional
	//회원권한 삭제
	public void deleteAuth(Member member) throws Exception {
		memberDAO.deleteAuth(member);
	}

}

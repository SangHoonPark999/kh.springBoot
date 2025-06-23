package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.persitance.MemberAuthRepository;
import com.kh.persitance.MemberRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberDAOServiceImpl implements MemberDAOService {
	
	@Autowired
	private MemberRepository mr;
	private MemberAuthRepository mar;
	
	//회원등록처리, 회원권한처리
	@Override
	@Transactional
	public void insert(Member member) throws Exception {
		//회원등록 처리
		mr.save(member);
		//회원권한생성
		MemberAuth memberAuth = new MemberAuth(); 
		//회원권한설정
		memberAuth.setNo(member.getNo());
		memberAuth.setAuth("ROLE_USER");
		//회원권한 처리
		mar.save(memberAuth);
	}

	@Override
	@Transactional
	//회원권한 입력처리
	public void insertAuth(MemberAuth memberAuth) throws Exception {
		mar.save(memberAuth);

	}

	@Override
	@Transactional
	//회원정보출력 리스트
	public List<Member> selectAll() throws Exception {
		return mr.findAll();
	}

	@Override
	//회원정보 출력(조인)
	public Member selectJoin(Member member) throws Exception {
		return mr.findById(member.getNo()).orElseThrow(()-> new Exception());
	}
	//회원 정보 수정
	@Override
	@Transactional
	//회원정보 출력
	public void update(Member member) throws Exception {
		//회원정보 수정입력
		mr.save(member);
		//회원권한 삭제
		mar.deleteById(member.getNo());
		 
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
		mar.save(memberAuth);
		}
	}
	@Override
	@Transactional
	//회원정보삭제
	public void delete(Member member) throws Exception {
		mar.deleteById(member.getNo());
		mr.delete(member);
	}

	@Override
	@Transactional
	//회원권한 삭제
	public void deleteAuth(Member member) throws Exception {
		mar.deleteById(member.getNo());
	}

}

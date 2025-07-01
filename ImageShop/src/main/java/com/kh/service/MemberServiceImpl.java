package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;
import com.kh.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	// 회원권한 생성, 등록
	@Transactional
	@Override
	public void register(Member member) throws Exception {
		mapper.create(member);
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setAuth("ROLE_MEMBER");
		mapper.createAuth(memberAuth);
	}

	// 회원 목록
	@Override
	public List<Member> list() throws Exception {
		return mapper.list();
	}

	// 회원상세 정보
	@Override
	public Member read(Member member) throws Exception {
		return mapper.read(member);
	}

	// 회원정보 수정
	@Transactional
	@Override
	public void modify(Member member) throws Exception {
		mapper.update(member);
		// 회원권한 수정
		int userNo = member.getUserNo();
		// 회원권한 삭제
		mapper.deleteAuth(member);
		// 수정한 회원구너한 등록
		List<MemberAuth> authList = member.getAuthList();
		for (int i = 0; i < authList.size(); i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();

			if (auth == null) {
				continue;
			}
			if (auth.trim().length() == 0) {
				continue;
			}
			// 변경된 회원권한 추가
			memberAuth.setUserNo(userNo);
			mapper.modifyAuth(memberAuth);
		}
	}

	// 회원정보 삭제
	@Transactional
	@Override
	public void remove(Member member) throws Exception {
		// 회원 권한 삭제
		mapper.deleteAuth(member);

		mapper.delete(member);
	}

	// 회원 테이블의 데이터 건수를 반환
	@Override
	public int countAll() throws Exception {
		return mapper.countAll();
	}

	// 최초 관리자를 생성
	@Transactional
	@Override
	public void setupAdmin(Member member) throws Exception {
		mapper.create(member);
		MemberAuth memberAuth = new MemberAuth();

		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_ADMIN");
		mapper.createAuth(memberAuth);
	}

}

package com.kh.common.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.kh.domain.Member;

public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	private Member member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	// 로그인에서 사용자 정보를 입력하면 security가 관리하는 User 객체에 정보를 등록한다.
	public CustomUser(Member member) {
		super(member.getUserId(), member.getUserPw(), member.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));

		this.member = member;
	}

	public Member getMember() {
		return member;
	}
}

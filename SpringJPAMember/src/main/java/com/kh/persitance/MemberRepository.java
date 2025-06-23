package com.kh.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	
}
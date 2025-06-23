package com.kh.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.domain.Member;
import com.kh.domain.MemberAuth;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Integer>{
	
	List<MemberAuth> findByNo(int no);
	
}
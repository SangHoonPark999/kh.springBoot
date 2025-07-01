package com.kh.mapper;

import java.util.List;

import com.kh.domain.CodeGroup;

public interface CodeGroupMapper {
	// 코드그룹 등록 
	public void create(CodeGroup codeGroup) throws Exception;
	
	// 코드그룹 리스트
	public List<CodeGroup> list() throws Exception;
	
	// 코드그룹 상세 페이지
	public CodeGroup read(CodeGroup codeGroup) throws Exception;
	
	// 코드그룹 수정
	public void update(CodeGroup codeGroup) throws Exception;
	
	// 코드그룹 삭제
	public void delete(CodeGroup codeGroup) throws Exception;
}

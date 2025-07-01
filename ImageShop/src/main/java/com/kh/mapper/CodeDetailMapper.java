package com.kh.mapper;

import java.util.List;

import com.kh.domain.CodeDetail;

public interface CodeDetailMapper {
	// 등록 처리 
	public void create(CodeDetail codeDetail) throws Exception;
	
	// 그룹코드 정렬 순서의 최대값 
	public Integer getMaxSortSeq(String groupCode) throws Exception;
	
	// 코드디테일 목록 리스트 
	public List<CodeDetail> list() throws Exception;
	
	// 코드디테일 (상세, 수정)화면
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
	
	// 코드디테일 수정 
	public void update(CodeDetail codeDetail) throws Exception;
	
	// 코드디테일 삭제
	public void delete(CodeDetail codeDetail) throws Exception;
	
}

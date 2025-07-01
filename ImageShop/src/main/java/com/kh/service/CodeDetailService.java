package com.kh.service;

import java.util.List;

import com.kh.domain.CodeDetail;

public interface CodeDetailService {

	// 코드디테일 등록
	public void register(CodeDetail codeDetail) throws Exception;

	// 코드디테일 목록 리스트
	public List<CodeDetail> list() throws Exception;

	// 코드디테일 (상세, 수정)화면
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
	
	// 코드디테일 수정 
	public void modify(CodeDetail codeDetail) throws Exception;
	
	// 코드디테일 삭제 
	public void remove(CodeDetail codeDetail) throws Exception;

}

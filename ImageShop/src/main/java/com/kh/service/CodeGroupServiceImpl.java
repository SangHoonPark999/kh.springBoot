package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.CodeGroup;
import com.kh.mapper.CodeGroupMapper;

@Service
public class CodeGroupServiceImpl implements CodeGroupService {

	@Autowired
	private CodeGroupMapper mapper;

	// 코드그룹 등록
	@Override
	public void register(CodeGroup codeGroup) throws Exception {
		mapper.create(codeGroup);
	}

	// 코드그룹 리스트
	@Override
	public List<CodeGroup> list() throws Exception {
		return mapper.list();
	}

	// 코드그룹 상세 페이지
	@Override
	public CodeGroup read(CodeGroup codeGroup) throws Exception {
		return mapper.read(codeGroup);
	}

	// 코드그룹 수정
	@Override
	public void modify(CodeGroup codeGroup) throws Exception {
		mapper.update(codeGroup);
	}

	// 코드그룹 삭제
	@Override
	public void remove(CodeGroup codeGroup) throws Exception {
		mapper.delete(codeGroup);
	}

}

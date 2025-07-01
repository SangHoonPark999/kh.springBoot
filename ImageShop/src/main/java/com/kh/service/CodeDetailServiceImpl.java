package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.CodeDetail;
import com.kh.mapper.CodeDetailMapper;

@Service
public class CodeDetailServiceImpl implements CodeDetailService {

	@Autowired
	private CodeDetailMapper mapper;

	// 코드디테일 등록
	@Override
	public void register(CodeDetail codeDetail) throws Exception {
		// 선택된 코드그룹코드
		String groupCode = codeDetail.getGroupCode();
		// (처음에 해당되는 그룹코드로 입력되었을 경우 0을 리턴)
		// 해당되는 그룹코드로 몇개의 코드디테일이 등록이 되었는지 체크
		int maxSortSeq = mapper.getMaxSortSeq(groupCode);
		codeDetail.setSortSeq(maxSortSeq + 1);
		mapper.create(codeDetail);
	}

	// 코드디테일 목록 리스트
	@Override
	public List<CodeDetail> list() throws Exception {
		return mapper.list();
	}

	// 코드디테일 (상세, 수정)화면
	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		return mapper.read(codeDetail);
	}

	// 코드디테일 수정
	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		mapper.update(codeDetail);
	}

	// 코드디테일 삭제
	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		mapper.delete(codeDetail);
	}

}

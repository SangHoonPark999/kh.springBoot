package com.kh.service;

import java.util.List;

import com.kh.domain.MyBatisBoard;

public interface BoardDAOService {
	
	
	
	//게시판 삽입
	public void insert(MyBatisBoard board) throws Exception;
	//게시판 출력(one)
	public MyBatisBoard select(MyBatisBoard board) throws Exception;
	//게시판수정
	public void update(MyBatisBoard board) throws Exception;
	//삭제
	public void delete(MyBatisBoard board) throws Exception;
	//게시판 출력(all)
	public List<MyBatisBoard> selectAll() throws Exception;
}

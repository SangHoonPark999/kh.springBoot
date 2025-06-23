package com.kh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.domain.MyBatisBoard;
import com.kh.mapper.BoardDAO;

@Service
public class BoardDAOServiceImpl implements BoardDAOService{
	@Autowired
	private BoardDAO bd;
	
	@Override
	public void insert(MyBatisBoard board) throws Exception{
		bd.insert(board);
	}

	@Override
	public MyBatisBoard select(MyBatisBoard board) throws Exception{
		return bd.select(board);
	}

	@Override
	public void update(MyBatisBoard board) throws Exception{
		bd.update(board);
	}
	

	@Override
	public void delete(MyBatisBoard board) throws Exception{
		bd.delete(board);
	}

	@Override
	public List<MyBatisBoard> selectAll() throws Exception{
		return bd.selectAll();
	}
}

package com.kh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.domain.Item;

@Mapper
public interface ItemMapper {
	//파일 삽입
	public void create(Item item) throws Exception;
	
	//파일 출력
	public Item read(Item item) throws Exception;
	
	//파일 수정
	public void update(Item item) throws Exception;
	
	//파일 삭제
	public void delete(Item item) throws Exception;
	
	//파일전체 리스트
	public List<Item> list() throws Exception;
	
	//파일 경로
	public Item getPicture(Item item) throws Exception;
}

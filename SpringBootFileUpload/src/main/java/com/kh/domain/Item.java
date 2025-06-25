package com.kh.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int price;
	private String description;
	private String pictureUrl;
	//input type="file"
	private MultipartFile picture;
}

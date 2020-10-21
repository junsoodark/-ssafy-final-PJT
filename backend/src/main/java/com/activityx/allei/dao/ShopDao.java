package com.activityx.allei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.activityx.allei.dto.ShopDto;

@Mapper
public interface ShopDao {
	
	// 업체 등록
	public int create(ShopDto shopDto);
	
	// 업체 상세 조회
	public ShopDto read(int id);
}

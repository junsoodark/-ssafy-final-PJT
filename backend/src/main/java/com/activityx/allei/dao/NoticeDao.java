package com.activityx.allei.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.activityx.allei.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	// 공지사항 등록
	public int create(NoticeDto noticeDto);
	
	// 공지사항 상세보기
	public NoticeDto read(int id);
	
	// 공지사항 리스트 조회
	public List<NoticeDto> readAll();
	
	// 조회수 증가
	public int increaseHits(int id);
}

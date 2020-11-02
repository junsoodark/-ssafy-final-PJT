package com.activityx.allei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activityx.allei.dao.NoticeDao;
import com.activityx.allei.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;

	@Override
	public boolean create(NoticeDto noticeDto) {
		return noticeDao.create(noticeDto) == 1;
	}

	@Override
	public NoticeDto read(int id) {
		noticeDao.increaseHits(id);
		return noticeDao.read(id);
	}
}

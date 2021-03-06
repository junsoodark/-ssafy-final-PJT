package com.activityx.allei.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.activityx.allei.dto.ReservationBean;
import com.activityx.allei.dto.ReservationDto;
import com.activityx.allei.dto.ReservationsByUserBean;

public interface ReservationService {
	
	// 예약하기
	int create(ReservationBean bean);
	
	// 예약정보 조회
	Map<String, Object> readReservation(int id);
	
	// 사용자의 예약정보 리스트 조회
	ArrayList<ReservationsByUserBean> readAllReservation(int id);
	
	// 예약정보 등록
	boolean deleteReservation(int id);
	
	// 최근 예약번호
	public Integer getLastReservationId();
}

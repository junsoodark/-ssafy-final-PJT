package com.activityx.allei.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationDto {
	private int id;	// 아이디
	private int user;	// 사용자 아이디
	private int shop;	// 업체 아이디
	@JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Date date;	// 예약한 날짜
	private String tid;	// 페이 결제시 연결 id
	private boolean state;	//결제 상태 (true : 완료, false : 실패)
	
	public ReservationDto() {
		super();
	}
	public ReservationDto(int id, int user, int shop, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.shop = shop;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getShop() {
		return shop;
	}
	public void setShop(int shop) {
		this.shop = shop;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ReservationDto [id=" + id + ", user=" + user + ", shop=" + shop + ", date=" + date + ", tid=" + tid
				+ ", state=" + state + "]";
	}

}

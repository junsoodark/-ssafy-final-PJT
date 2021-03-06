package com.activityx.allei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activityx.allei.dao.UserDao;
import com.activityx.allei.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public boolean joinUser(User user) {
		int check1 = dao.create(user);
		System.out.println("check1: " + check1);
		System.out.println("userid: " + user.getId());
		int check2 = dao.authorizeUser(user.getId());
		System.out.println("check2: " + check2);
		return (check1 + check2) > 1;
	}

	@Override
	public boolean deleteUser(int id) {
		return dao.delete(id) == 1;
	}

	@Override
	public List<User> findAll() {
		return dao.readAll();
	}

	@Override
	public User findById(int id) {
		return dao.findById(id);
	}

	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<User> findlistByName(String name) {
		return dao.findlistByName(name);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public List<User> findlistByEmail(String email) {
		return dao.findlistByEmail(email);
	}

	@Override
	public User findByUkey(long ukey) {
		return dao.findByUkey(ukey);
	}

	@Override
	public boolean modifyUser(User user) {
		return dao.update(user) == 1;
	}

	@Override
	public int readUserAuthority(int user) {
		return dao.readUserAuthority(user);
	}

}

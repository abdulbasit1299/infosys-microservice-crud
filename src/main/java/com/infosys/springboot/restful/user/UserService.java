package com.infosys.springboot.restful.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class UserService {
	@Autowired
	UserRepository userDao;

	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	public Optional<User> findById(Long id) {
		return userDao.findById(id);
	}

	public User save(User u) {
		return userDao.save(u);
	}

	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

}

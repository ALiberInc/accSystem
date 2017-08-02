package jp.co.aliber.accsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.aliber.accsystem.entity.auto.User;
import jp.co.aliber.accsystem.entity.auto.UserExample;
import jp.co.aliber.accsystem.mapper.auto.UserMapper;

@Service
public class AdminService {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getFirstUser() {
		return userMapper.selectByExample(new UserExample()).get(0);
		
	}
}

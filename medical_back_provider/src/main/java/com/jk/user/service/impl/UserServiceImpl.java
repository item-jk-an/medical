package com.jk.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.jk.user.dao.UserMapper;
import com.jk.user.pojo.User;
import com.jk.user.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public Map<String, Object> queryUserShowList(User user, Integer pageSize,
			Integer start) {
		Map<String,Object> map = new HashMap<String, Object>();
		Long total = userMapper.getUserTotal(user);
		List<User> list = userMapper.queryUserShowList(user,pageSize,start);
		map.put("total", total);
		map.put("rows", list);
		return map;
	}

	/*public Map<String, Object> queryUserListById(User user) {
		Map<String,Object> map = new HashMap<String, Object>();
		List<User> list = (List<User>) userMapper.queryUserListById(user);
		map.put("list", list);
		return map;

	}*/

	public User queryUserListById(Integer integer) {
		User user =   userMapper.queryUserListById(integer);
		
		return user;
	}

}

package com.jk.user.service;

import java.util.Map;

import com.jk.user.pojo.User;

public interface UserService {

	Map<String, Object> queryUserShowList(User user, Integer pageSize,
                                          Integer start);
	
	User queryUserListById(Integer id);

}

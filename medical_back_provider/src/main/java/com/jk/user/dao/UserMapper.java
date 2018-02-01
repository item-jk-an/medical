package com.jk.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jk.user.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	Long getUserTotal(User user);
	
	List<User> queryUserShowList(@Param("user") User user, @Param("pageSize") Integer pageSize, @Param("start") Integer start);

	User queryUserListById(@Param("userId") Integer integer);

}
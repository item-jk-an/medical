package com.jk.login.service;

import com.jk.admin.pojo.Admin;
import com.jk.power.pojo.Power;

import java.util.List;
import java.util.Map;

public interface LoginService {

	Map<String,Object> adminLogin(Admin admin);

	List<Power> queryPowerInfo(Integer pid,Admin admin);

}

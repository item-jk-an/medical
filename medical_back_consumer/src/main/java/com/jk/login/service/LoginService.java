package com.jk.login.service;

import com.jk.admin.pojo.Admin;
import com.jk.power.pojo.Power;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginService {

	Integer adminLogin(Admin admin, HttpServletRequest request);

	List<Power> queryPowerInfo(Integer pid, HttpServletRequest request);

}

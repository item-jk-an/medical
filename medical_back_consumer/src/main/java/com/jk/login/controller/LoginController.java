package com.jk.login.controller;

import com.jk.admin.pojo.Admin;
import com.jk.login.service.LoginService;
import com.jk.power.pojo.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("adminLogin")
	@ResponseBody
	public Integer adminLogin(Admin admin, HttpServletRequest request){
		Integer flag = loginService.adminLogin(admin,request);
		return flag;
	}
	
	@RequestMapping("queryPowerTreeInfo")
	@ResponseBody
	public List<Power> queryPowerTreeInfo(HttpServletRequest request){
		Integer pid = 0;
		List<Power> powerList = loginService.queryPowerInfo(pid,request);
		return powerList;
	}
}

package com.jk.login.controller;

import com.jk.admin.pojo.Admin;
import com.jk.login.service.LoginService;
import com.jk.power.pojo.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping("adminLogin")
	@ResponseBody
	public Integer adminLogin(Admin admin, HttpServletRequest request){
		Map<String,Object> map = loginService.adminLogin(admin);
		Integer flag = (Integer) map.get("flag");
		admin = (Admin) map.get("returnAdmin");
		HttpSession session = request.getSession();
		session.setAttribute("returnAdmin",admin);
		session.getServletContext().setAttribute(admin.getAdminId()+"", session.getId());
		return flag;
	}
	
	@RequestMapping("queryPowerTreeInfo")
	@ResponseBody
	public List<Power> queryPowerTreeInfo(HttpServletRequest request){
		Admin returnAdmin = (Admin) request.getSession().getAttribute("returnAdmin");
		Integer pid = 0;
		List<Power> powerList = loginService.queryPowerInfo(pid,returnAdmin);
		return powerList;
	}
}

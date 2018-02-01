package com.jk.user.controller;

import com.jk.user.pojo.User;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("toUserListPage")
	public String toUserListPage(){
		return "user/userListPage";
	}
	
	@RequestMapping("selectUserShowList")
	@ResponseBody
	public Map<String,Object> queryUserShowList(Integer pageSize, Integer start, User user){
		Map<String,Object> map = userService.queryUserShowList(user, pageSize, start);
		return map;
	}
	
	/*@RequestMapping("queryUserListById")
	@ResponseBody
	public  Map<String, Object>  queryUserListById(User user){
		Map<String,Object> map = userService.queryUserListById(user);
		return map;
	}*/
	@RequestMapping("queryUserListById")
	@ResponseBody
	public ModelAndView toGiveRolePage(Integer id){
		ModelAndView mv = new ModelAndView();
		User user = (User) userService.queryUserListById(id);
		mv.addObject("user", user);
		mv.setViewName("user/userXi");
		return mv;
	}

}

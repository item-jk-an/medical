package com.jk.login.service.impl;

import com.jk.admin.pojo.Admin;
import com.jk.item.service.ItemService;
import com.jk.login.service.LoginService;
import com.jk.power.pojo.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private ItemService itemServices;

	@Override
	public Integer adminLogin(Admin admin, HttpServletRequest request) {
		Admin reUser = itemServices.queryAdminInfoByCount(admin.getAdminMane());
		Integer flag = 0;
		if (reUser != null) {
			if (reUser.getAdminPwd().equals(admin.getAdminPwd())) {
				flag = 2;
				HttpSession session = request.getSession();
				session.setAttribute("sessionUser", reUser);
				session.getServletContext().setAttribute(reUser.getAdminId()+"", session.getId());
			} else {
				flag = 1;
			}
		} else {
			flag = 0;
		}
		
		return flag;
	}

	@Override
	public List<Power> queryPowerInfo(Integer pid, HttpServletRequest request) {
		Admin user = (Admin) request.getSession().getAttribute("sessionUser");
		Integer userId = user.getAdminId();
		List<Integer> roleIdsList = itemServices.queryRoleIds(userId);
		List<Integer> powerIdsList = itemServices.queryPowerIds(roleIdsList);
		List<Power> powerList = itemServices.queryPowerList(powerIdsList);
		List<Power> rootList = getChildrenList(powerList,0);
		return getPowerList(powerList,rootList);
	}

	private List<Power> getPowerList(List<Power> powerList, List<Power> parentList) {
		for (int i = 0; i < parentList.size(); i++) {
			List<Power> childrenList = getChildrenList(powerList,parentList.get(i).getId());
			if (childrenList != null && childrenList.size() != 0) {
				parentList.get(i).setNodes(getPowerList(powerList,childrenList));
			}
		}
		return parentList;
	}

	private List<Power> getChildrenList(List<Power> powerList, Integer pid) {
		List<Power> childrenList = new ArrayList<>();
		for (int i = 0; i < powerList.size(); i++) {
            Power power = powerList.get(i);
            Integer pid1 = power.getPid();
            if (pid1 == pid) {
				childrenList.add(powerList.get(i));
			}
		}
		return childrenList;
	}

}

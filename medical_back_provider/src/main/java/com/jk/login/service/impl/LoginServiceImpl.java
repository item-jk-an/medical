package com.jk.login.service.impl;

import com.jk.admin.pojo.Admin;
import com.jk.admin.service.AdminService;
import com.jk.login.service.LoginService;
import com.jk.power.pojo.Power;
import com.jk.power.service.PowerService;
import com.jk.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *     ${DESCRIPTION}
 * 项目名称：medical
 * 类名称：LoginServiceImpl
 * 类描述：
 * 创建人：安月朝 anyuechao@126.com
 * 创建时间：2018/2/5 0005 16:00
 * 修改人：安月朝 anyuechao@126.com
 * 修改时间：2018/2/5 0005 16:00
 * 修改备注：
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PowerService powerService;
    @Override
    public Map<String,Object> adminLogin(Admin admin) {
        Admin adminRe = adminService.queryAdminInfoByName(admin.getAdminMane());
        Integer flag = 0;
        if (adminRe != null) {
            if (adminRe.getAdminPwd().equals(admin.getAdminPwd())) {
                flag = 2;
            } else {
                flag = 1;
            }
        } else {
            flag = 0;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("flag",flag);
        map.put("returnAdmin",adminRe);
        return map;
    }

    @Override
    public List<Power> queryPowerInfo(Integer pid, Admin admin) {
        Integer adminId = admin.getAdminId();
        List<Integer> roleIdsList = roleService.queryPowerIdsByUserId(adminId);
        List<Integer> powerIdsList = powerService.queryPowerIdsByRoleIds(roleIdsList);
        List<Power> powerList = powerService.queryPowerListByIds(powerIdsList);
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

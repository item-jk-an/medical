package com.jk.login.service;

import com.jk.admin.pojo.Admin;
import com.jk.power.pojo.Power;

import java.util.List;
import java.util.Map;

/*
 *     ${DESCRIPTION}
 * 项目名称：medical
 * 类名称：LoginService
 * 类描述：
 * 创建人：安月朝 anyuechao@126.com
 * 创建时间：2018/2/5 0005 16:00
 * 修改人：安月朝 anyuechao@126.com
 * 修改时间：2018/2/5 0005 16:00
 * 修改备注：
 */
public interface LoginService {
    Map<String,Object> adminLogin(Admin admin);

    List<Power> queryPowerInfo(Integer pid, Admin admin);
}

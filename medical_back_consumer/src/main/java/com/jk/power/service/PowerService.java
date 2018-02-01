package com.jk.power.service;

import com.jk.power.pojo.Power;
import com.jk.role.pojo.Role;

import java.util.List;

/* 项目名称：medicine_treatment
 * 类名称：Administrator
 * 类描述：
 * 创建人：陈春杰 1248679057@qq.com
 * 创建时间：2018/1/26 0026 0:06
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:06
 * 修改备注：
 */
public interface PowerService {
    /**
     * 根据roleId查询power信息
     * @param role
     * @return
     */
    List<Power> queryPowerInfoByRoleId(Role role);

    /**
     * 查询所有的权限
     * @return
     */
    List<Power> queryPowerAllInfo();

    void saveOrUpdatePowerInfo(Power power);

    void deletePowerInfo(Power power);
}

package com.jk.role.service;

import com.jk.role.pojo.Role;

import java.util.List;
import java.util.Map;

/* 项目名称：medicine_treatment
 * 类名称：Administrator
 * 类描述：
 * 创建人：陈春杰 1248679057@qq.com
 * 创建时间：2018/1/26 0026 0:07
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:07
 * 修改备注：
 */
public interface RoleService {

    Map<String,Object> queryRoleAllShowList();

    Map<String,Object> queryRoleShowList(Role role, Integer pageSize, Integer start);

    void saveOrUpdateRoleInfo(Role role);

    void deleteRole(Role role);

    void savePowerToRole(String ids, Role role);

    List<Integer> queryPowerIdsByUserId(Integer userId);
}

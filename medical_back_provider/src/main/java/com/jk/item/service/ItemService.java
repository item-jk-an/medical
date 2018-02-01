package com.jk.item.service;

import com.jk.admin.pojo.Admin;
import com.jk.power.pojo.Power;
import com.jk.role.pojo.Role;

import java.util.List;
import java.util.Map;

/* 项目名称：medical
 * 类名称：Administrator
 * 类描述：
 * 创建人：安月朝 anyuechao@126.com
 * 创建时间：2018/1/26 0026 08:27
 * 修改人：安月朝 anyuechao@126.com
 * 修改时间：2018/1/26 0026 08:27
 * 修改备注：
 */
public interface ItemService {
    Map<String,Object> queryRoleAllShowList();

    Map<String,Object> queryRoleShowList(Role role, Integer pageSize, Integer start);

    void saveOrUpdateRoleInfo(Role role);

    void deleteRole(Role role);

    void savePowerToRole(String ids, Role role);
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

    Map<String,Object> queryAdminShowList(Admin admin, Integer pageSize, Integer start);

    void saveRolesOfAdmin(Admin admin, String ids);

    List<Integer> queryRoleIds(Integer userId);

    List<Integer> queryPowerIds(List<Integer> roleIdsList);

    List<Power> queryPowerList(List<Integer> powerIdsList);

    Admin queryAdminInfoByCount(String adminMane);
}

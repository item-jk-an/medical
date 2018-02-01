package com.jk.item.service.impl;

import com.jk.admin.pojo.Admin;
import com.jk.admin.service.AdminService;
import com.jk.item.service.ItemService;
import com.jk.power.pojo.Power;
import com.jk.power.service.PowerService;
import com.jk.role.pojo.Role;
import com.jk.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PowerService powerService;

    @Autowired
    private RoleService roleService;
    @Override
    public Map<String, Object> queryRoleAllShowList() {
        return roleService.queryRoleAllShowList();
    }

    @Override
    public Map<String, Object> queryRoleShowList(Role role, Integer pageSize, Integer start) {
        return roleService.queryRoleShowList(role,pageSize,start);
    }

    @Override
    public void saveOrUpdateRoleInfo(Role role) {
        roleService.saveOrUpdateRoleInfo(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleService.deleteRole(role);
    }

    @Override
    public void savePowerToRole(String ids, Role role) {
        roleService.savePowerToRole(ids,role);
    }

    @Override
    public List<Power> queryPowerInfoByRoleId(Role role) {
        return powerService.queryPowerInfoByRoleId(role);
    }

    @Override
    public List<Power> queryPowerAllInfo() {
        return powerService.queryPowerAllInfo();
    }

    @Override
    public void saveOrUpdatePowerInfo(Power power) {
        powerService.saveOrUpdatePowerInfo(power);
    }

    @Override
    public void deletePowerInfo(Power power) {
        powerService.deletePowerInfo(power);
    }

    @Override
    public Map<String, Object> queryAdminShowList(Admin admin, Integer pageSize, Integer start) {
        return adminService.queryAdminShowList(admin,pageSize,start);
    }

    @Override
    public void saveRolesOfAdmin(Admin admin, String ids) {
        adminService.saveRolesOfAdmin(admin,ids);
    }

    @Override
    public List<Integer> queryRoleIds(Integer userId) {
        List<Integer> list = roleService.queryPowerIdsByUserId(userId);
        return list;
    }

    @Override
    public List<Integer> queryPowerIds(List<Integer> roleIdsList) {
        List<Integer> list = powerService.queryPowerIdsByRoleIds(roleIdsList);
        return list;
    }

    @Override
    public List<Power> queryPowerList(List<Integer> powerIdsList) {
        List<Power> list = powerService.queryPowerListByIds(powerIdsList);
        return list;
    }

    @Override
    public Admin queryAdminInfoByCount(String adminMane) {
        Admin admin = adminService.queryAdminInfoByName(adminMane);
        return admin;
    }
}

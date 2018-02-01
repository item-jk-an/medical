package com.jk.role.service.impl;

import com.jk.item.service.ItemService;
import com.jk.role.pojo.Role;
import com.jk.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/* 项目名称：medical
 * 类名称：Administrator
 * 类描述：
 * 创建人：安月朝 anyuechao@126.com
 * 创建时间：2018/1/26 0026 10:39
 * 修改人：安月朝 anyuechao@126.com
 * 修改时间：2018/1/26 0026 10:39
 * 修改备注：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private ItemService itemServices;
    @Override
    public Map<String, Object> queryRoleAllShowList() {
        return itemServices.queryRoleAllShowList();
    }

    @Override
    public Map<String, Object> queryRoleShowList(Role role, Integer pageSize, Integer start) {
        return itemServices.queryRoleShowList(role,pageSize,start);
    }

    @Override
    public void saveOrUpdateRoleInfo(Role role) {
        itemServices.saveOrUpdateRoleInfo(role);
    }

    @Override
    public void deleteRole(Role role) {
        itemServices.deleteRole(role);
    }

    @Override
    public void savePowerToRole(String ids, Role role) {
        itemServices.savePowerToRole(ids,role);
    }
}

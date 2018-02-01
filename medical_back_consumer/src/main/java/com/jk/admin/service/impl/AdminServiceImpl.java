package com.jk.admin.service.impl;

import com.jk.admin.pojo.Admin;
import com.jk.admin.service.AdminService;
import com.jk.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/* 项目名称：medical
 * 类名称：Administrator
 * 类描述：
 * 创建人：安月朝 anyuechao@126.com
 * 创建时间：2018/1/26 0026 10:46
 * 修改人：安月朝 anyuechao@126.com
 * 修改时间：2018/1/26 0026 10:46
 * 修改备注：
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ItemService itemServices;

    @Override
    public Map<String, Object> queryAdminShowList(Admin admin, Integer pageSize, Integer start) {
        Map<String, Object> map = itemServices.queryAdminShowList(admin,pageSize,start);
        return map;
    }

    @Override
    public void saveRolesOfAdmin(Admin admin, String ids) {
        itemServices.saveRolesOfAdmin(admin,ids);
    }
}

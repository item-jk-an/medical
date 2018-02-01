package com.jk.admin.service.impl;

import com.jk.admin.dao.AdminMapper;
import com.jk.admin.pojo.Admin;
import com.jk.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.registry.infomodel.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 项目名称：medicine_treatment
 * 类名称：Administrator
 * 类描述：
 * 创建人：陈春杰 1248679057@qq.com
 * 创建时间：2018/1/26 0026 0:05
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:05
 * 修改备注：
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    /**
     * 查询所有用户信息
     */
    @Override
    public Map<String, Object> queryAdminShowList(Admin admin, Integer pageSize, Integer start) {
        Map<String,Object> map = new HashMap<String, Object>();
        Long total = adminMapper.getAdminTotal(admin);
        List<Admin> list = adminMapper.queryAdminShowList(admin,pageSize,start);
        map.put("total", total);
        map.put("rows", list);
        return map;
    }

    @Override
    public void saveRolesOfAdmin(Admin admin, String ids) {
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        adminMapper.saveRolesOfAdmin(admin.getAdminId(),list);
    }

    @Override
    public Admin queryAdminInfoByName(String adminMane) {
        Admin admin= adminMapper.queryAdminInfoByName(adminMane);
        return admin;
    }
}

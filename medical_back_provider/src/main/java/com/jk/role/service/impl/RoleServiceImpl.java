package com.jk.role.service.impl;

import com.jk.role.dao.RoleMapper;
import com.jk.role.pojo.Role;
import com.jk.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 项目名称：medicine_treatment
 * 类名称：Administrator
 * 类描述：
 * 创建人：陈春杰 1248679057@qq.com
 * 创建时间：2018/1/26 0026 0:08
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:08
 * 修改备注：
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 查询所有的角色信息
     */
    @Override
    public Map<String, Object> queryRoleAllShowList() {
        Map<String,Object> map = new HashMap<String, Object>();
        List<Role> roleList = roleMapper.queryRoleAllShowList();
        Long total = roleMapper.getRoleTotalCount(new Role());
        map.put("total", total);
        map.put("rows", roleList);
        return map;
    }
    /**
     * 查询角色展示列表
     */
    @Override
    public Map<String, Object> queryRoleShowList(Role role, Integer pageSize, Integer start) {
        Map<String,Object> map = new HashMap<String, Object>();
        Long total = roleMapper.getRoleTotalCount(role);
        List<Role> roleList = roleMapper.queryRoleShowList(role,pageSize,start);
        map.put("total", total);
        map.put("rows", roleList);
        return map;
    }
    /**
     * 新增或修改方法
     */
    @Override
    public void saveOrUpdateRoleInfo(Role role) {
        if (role.getRoleId() == null) {
            roleMapper.insertSelective(role);
        } else {
            roleMapper.updateByPrimaryKeySelective(role);
        }
    }
    /**
     * 删除角色
     */
    @Override
    public void deleteRole(Role role) {
        roleMapper.deleteByPrimaryKey(role.getRoleId());
    }
    /**
     * 给角色赋权限
     */
    @Override
    public void savePowerToRole(String ids, Role role) {
        String[] split = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        roleMapper.deleteRolePowerInfo(role.getRoleId());
        roleMapper.savePowerToRole(list,role.getRoleId());
    }

    @Override
    public List<Integer> queryPowerIdsByUserId(Integer userId) {
        List<Integer> list = roleMapper.queryPowerIdsByUserId(userId);
        return list;
    }
}

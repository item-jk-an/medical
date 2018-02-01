package com.jk.role.dao;

import com.jk.role.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> queryRoleShowList(@Param("role") Role role, @Param("pageSize") Integer pageSize,
                                 @Param("start") Integer start);

    Long getRoleTotalCount(Role role);

    List<Role> queryRoleAllShowList();

    void deleteRolePowerInfo(Integer roleId);

    void savePowerToRole(@Param("list") List<Integer> list, @Param("roleId") Integer roleId);

    List<Integer> queryPowerIdsByUserId(Integer userId);
}
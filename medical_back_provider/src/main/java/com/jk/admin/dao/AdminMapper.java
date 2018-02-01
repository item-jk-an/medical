package com.jk.admin.dao;

import com.jk.admin.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    Long getAdminTotal(Admin admin);

    List<Admin> queryAdminShowList(@Param("admin") Admin admin, @Param("pageSize") Integer pageSize,
                                   @Param("start") Integer start);

    void saveRolesOfAdmin(@Param("adminId") Integer adminId, @Param("list") List<Integer> list);

    Admin queryAdminInfoByName(String adminMane);
}
package com.jk.power.dao;

import com.jk.power.pojo.Power;

import java.util.List;

public interface PowerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Power record);

    int insertSelective(Power record);

    Power selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Power record);

    int updateByPrimaryKey(Power record);

    List<Power> queryPowerInfoByRoleId(Integer roleId);

    List<Power> queryPowerAllInfo();

    void deleteRolePowerInfo(Integer id);

    List<Integer> queryPowerIdsByRoleIds(List<Integer> roleIdsList);

    List<Power> queryPowerListByIds(List<Integer> powerIdsList);
}
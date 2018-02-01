package com.jk.power.service.impl;

import com.jk.power.dao.PowerMapper;
import com.jk.power.pojo.Power;
import com.jk.power.service.PowerService;
import com.jk.role.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* 项目名称：medicine_treatment
 * 类名称：Administrator
 * 类描述：
 * 创建人：陈春杰 1248679057@qq.com
 * 创建时间：2018/1/26 0026 0:06
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:06
 * 修改备注：
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public List<Power> queryPowerInfoByRoleId(Role role) {
        List<Power> list = powerMapper.queryPowerInfoByRoleId(role.getRoleId());
        return list;
    }

    @Override
    public List<Power> queryPowerAllInfo() {
        List<Power> list = powerMapper.queryPowerAllInfo();
        return list;
    }

    @Override
    public void saveOrUpdatePowerInfo(Power power) {
        if (power != null) {
            if (power.getId() != null) {
                powerMapper.updateByPrimaryKeySelective(power);
            } else {
                powerMapper.insertSelective(power);
            }
        }
    }

    @Override
    public void deletePowerInfo(Power power) {
        powerMapper.deleteByPrimaryKey(power.getId());
        powerMapper.deleteRolePowerInfo(power.getId());
    }

    @Override
    public List<Integer> queryPowerIdsByRoleIds(List<Integer> roleIdsList) {
        List<Integer> list = powerMapper.queryPowerIdsByRoleIds(roleIdsList);
        return list;
    }

    @Override
    public List<Power> queryPowerListByIds(List<Integer> powerIdsList) {
        List<Power> list = powerMapper.queryPowerListByIds(powerIdsList);
        return list;
    }
}

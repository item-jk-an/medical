package com.jk.power.service.impl;

import com.jk.item.service.ItemService;
import com.jk.power.pojo.Power;
import com.jk.power.service.PowerService;
import com.jk.role.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* 项目名称：medical
 * 类名称：Administrator
 * 类描述：
 * 创建人：安月朝 anyuechao@126.com
 * 创建时间：2018/1/26 0026 10:43
 * 修改人：安月朝 anyuechao@126.com
 * 修改时间：2018/1/26 0026 10:43
 * 修改备注：
 */
@Service
public class PowerServiceImpl implements PowerService {

    @Autowired
    private ItemService itemServices;

    @Override
    public List<Power> queryPowerInfoByRoleId(Role role) {
        return itemServices.queryPowerInfoByRoleId(role);
    }

    @Override
    public List<Power> queryPowerAllInfo() {
        return itemServices.queryPowerAllInfo();
    }

    @Override
    public void saveOrUpdatePowerInfo(Power power) {
        itemServices.saveOrUpdatePowerInfo(power);
    }

    @Override
    public void deletePowerInfo(Power power) {
        itemServices.deletePowerInfo(power);
    }
}

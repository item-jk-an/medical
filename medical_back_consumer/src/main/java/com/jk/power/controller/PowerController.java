package com.jk.power.controller;

import com.jk.power.pojo.Power;
import com.jk.power.service.PowerService;
import com.jk.role.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/* 项目名称：medicine_treatment
 * 类名称：Administrator
 * 类描述：
 * 创建人：陈春杰 1248679057@qq.com
 * 创建时间：2018/1/26 0026 0:28
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:28
 * 修改备注：
 */
@Controller
@RequestMapping("power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    @RequestMapping("toPowerListPage")
    public String toPowerListPage(){
        return "power/powerListPage";
    }

    @RequestMapping("queryPowerAllInfo")
    @ResponseBody
    public List<Power> queryPowerAllInfo(){
        List<Power> list = powerService.queryPowerAllInfo();
        return list;
    }

    @RequestMapping("queryPowerInfoByRoleId")
    @ResponseBody
    public List<Power> queryPowerInfoByRoleId(Role role){
        List<Power> list = powerService.queryPowerInfoByRoleId(role);
        return list;
    }

    @RequestMapping("saveOrUpdatePowerInfo")
    @ResponseBody
    public void saveOrUpdatePowerInfo(Power power){
        powerService.saveOrUpdatePowerInfo(power);
    }
    @RequestMapping("deletePowerInfo")
    @ResponseBody
    public void deletePowerInfo(Power power){
        powerService.deletePowerInfo(power);
    }
}

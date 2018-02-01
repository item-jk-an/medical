package com.jk.role.controller;

import com.jk.role.pojo.Role;
import com.jk.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("toRoleListPage")
    public String toRoleListPage(){
        return "role/roleListPage";
    }

    @RequestMapping("queryRoleAllShowList")
    @ResponseBody
    public Map<String,Object> queryRoleAllShowList(){
        Map<String,Object> map = roleService.queryRoleAllShowList();
        return map;
    }
    @RequestMapping("queryRoleShowList")
    @ResponseBody
    public Map<String,Object> queryRoleShowList(Integer pageSize, Integer start, Role role){
        Map<String,Object> map = roleService.queryRoleShowList(role, pageSize, start);
        return map;
    }

    @RequestMapping("saveOrUpdateRoleInfo")
    @ResponseBody
    public void saveOrUpdateRoleInfo(Role role){
        roleService.saveOrUpdateRoleInfo(role);
    }

    @RequestMapping("toGivePowerPage")
    @ResponseBody
    public ModelAndView toGivePowerPage(Integer roleId, String roleName){
        ModelAndView mv = new ModelAndView();
        Role role = new Role();
        role.setRoleId(roleId);
        role.setRoleName(roleName);
        mv.addObject("role", role);
        mv.setViewName("role/givePowerPage");
        return mv;
    }
    @RequestMapping("deleteRole")
    @ResponseBody
    public void deleteRole(Role role){
        roleService.deleteRole(role);
    }

    @RequestMapping("givePowerToRole")
    @ResponseBody
    public void givePowerToRole(String ids,Role role){
        roleService.savePowerToRole(ids,role);
    }

}

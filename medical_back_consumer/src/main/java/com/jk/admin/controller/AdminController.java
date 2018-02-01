package com.jk.admin.controller;

import com.jk.admin.pojo.Admin;
import com.jk.admin.service.AdminService;
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
 * 创建时间：2018/1/26 0026 0:29
 * 修改人：陈春杰 1248679057@qq.com
 * 修改时间：2018/1/26 0026 0:29
 * 修改备注：
 */
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("toAdminListPage")
    public String toUserListPage(){

        return "admin/adminListPage";
    }

    /**
     * 查询所有的admin
     * @param pageSize
     * @param start
     * @param admin
     * @return
     */
    @RequestMapping("queryAdminShowList")
    @ResponseBody
    public Map<String,Object> queryAdminShowList(Integer pageSize, Integer start, Admin admin){
        Map<String,Object> map = adminService.queryAdminShowList(admin, pageSize, start);
        return map;
    }

    @RequestMapping("toGiveRolePage")
    @ResponseBody
    public ModelAndView toGiveRolePage(Admin admin){
        ModelAndView mv = new ModelAndView();
        mv.addObject("admin", admin);
        mv.setViewName("admin/giveRolePage");
        return mv;
    }
    /**
     *admin付角色
     * @param admin
     * @param ids
     */
    @RequestMapping("giveRolesToAdmin")
    @ResponseBody
    public void giveRolesToAdmin(Admin admin,String ids){
        adminService.saveRolesOfAdmin(admin,ids);
    }
}

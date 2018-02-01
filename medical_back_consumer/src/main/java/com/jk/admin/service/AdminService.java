package com.jk.admin.service;

import com.jk.admin.pojo.Admin;

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
public interface AdminService {

    Map<String,Object> queryAdminShowList(Admin admin, Integer pageSize, Integer start);

    void saveRolesOfAdmin(Admin admin, String ids);
}

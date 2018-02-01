package com.jk.kit.service;

import com.jk.flow.model.Kit;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:14 2018/1/24
 * @Modified By：
 */
public interface KitService {
    //查询
    Map<String,Object> queryKitAll(Integer pageSize, Integer start, Kit kit);
    //回显
    Kit queryKitById(Integer id);
    //导出
    List<LinkedHashMap<String, Object>> toexcel();
    //导入
    void saveUploadExcelFiles(List<Kit> kitList);
}

package com.jk.kit.service.impl;

import com.jk.flow.model.Kit;
import com.jk.kit.dao.KitMapper;
import com.jk.kit.service.KitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:17 2018/1/24
 * @Modified By：
 */
@Service("kitService")
public class KitServiceImpl  implements KitService{
    @Autowired
    private KitMapper  kitMapper;

    @Override
    public Map<String, Object> queryKitAll(Integer pageSize, Integer start, Kit kit) {
        long count = kitMapper.queryKitCount(kit);
        List<Kit> list = kitMapper.queryKitAll(pageSize,start,kit);
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public Kit queryKitById(Integer id) {
        return kitMapper.queryKitById(id);
    }

    @Override
    public List<LinkedHashMap<String, Object>> toexcel() {
        return kitMapper.toexcel();
    }

    @Override
    public void saveUploadExcelFiles(List<Kit> kitList) {
        kitMapper.saveUploadExcelFiles(kitList);
    }
}

package com.jk.supplier.service.impl;

import com.jk.supplier.dao.SupplierMapper;
import com.jk.supplier.pojo.Supplier;
import com.jk.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 23:43 2018/1/24
 * @Modified By：
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public Map<String, Object> querySupplierAll(Integer pageSize, Integer start, Supplier supplier) {
        long count = supplierMapper.querySupplierCount(supplier);
        List<Supplier> list = supplierMapper.querySupplierAll(pageSize,start,supplier);
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public Supplier querySupplierById(Integer id) {
        return supplierMapper.querySupplierById(id);
    }

    @Override
    public List<LinkedHashMap<String, Object>> toexcel() {
        return supplierMapper.toexcel();
    }

    @Override
    public void saveUploadExcelFiles(List<Supplier> suppliersList) {
        supplierMapper.saveUploadExcelFiles(suppliersList);
    }
}

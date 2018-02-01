package com.jk.supplier.service;

import com.jk.supplier.pojo.Supplier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 23:34 2018/1/24
 * @Modified By：
 */
public interface SupplierService {
    //查询供应商
    Map<String,Object> querySupplierAll(Integer pageSize, Integer start, Supplier supplier);
    //回显
    Supplier querySupplierById(Integer id);
    //导出excel文档
    List<LinkedHashMap<String,Object>> toexcel();
    //导入excel数据
    void saveUploadExcelFiles(List<Supplier> suppliersList);
}

package com.jk.drug.service;

import com.jk.flow.model.Drug;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 20:21 2018/1/23
 * @Modified By：
 */
public interface DrugService {
    //查询药品信息
    Map<String,Object> queryDrugAll(Integer pageSize, Integer start, Drug drug);
    //查询单条信息
    Drug drugDialog(Integer drugId);
    //修改
    void updateDrugInfo(Drug drug);
    //新增
    void saveDrugInfo(Drug drug);
    //查询回收站
    Map<String,Object> queryDrugByState(Integer pageSize, Integer start, Drug drug);
    //回收站删除
    void deleteDrugByids(Drug drug);
    //删除--修改状态
    void updateDrugByState(Drug drug);
    //还原--修改状态
    void updateDrugByStates(Drug drug);
    //导出excel文档
    List<LinkedHashMap<String, Object>> toexcel();
    //导入excel数据
    void saveUploadExcelFiles(List<Drug> drugList);
}

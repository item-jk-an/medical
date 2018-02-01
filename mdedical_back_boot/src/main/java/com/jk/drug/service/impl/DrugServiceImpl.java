package com.jk.drug.service.impl;

import com.jk.drug.dao.DrugMapper;
import com.jk.drug.service.DrugService;
import com.jk.flow.model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 20:24 2018/1/23
 * @Modified By：
 */
@Service("drugService")
public class DrugServiceImpl implements DrugService{
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public Map<String,Object> queryDrugAll(Integer pageSize, Integer start, Drug drug) {
        long count = drugMapper.queryCount(drug);
        List<Drug> list = drugMapper.queryDrugAll(pageSize,start,drug);
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public Drug drugDialog(Integer drugId) {
        return drugMapper.drugDialog(drugId);
    }

    @Override
    public void updateDrugInfo(Drug drug) {
        drug.setDrugUpdate(new Date());
        drugMapper.updateDrugInfo(drug);
    }

    @Override
    public void saveDrugInfo(Drug drug) {
        drug.setDrugAdddate(new Date());
        drugMapper.saveDrugInfo(drug);
    }

    @Override
    public Map<String, Object> queryDrugByState(Integer pageSize, Integer start, Drug drug) {
        long count = drugMapper.queryDrugByStateCount(drug);
        List<Drug> list = drugMapper.queryDrugByState(pageSize,start,drug);
        Map<String,Object> map=new HashMap<>();
        map.put("total",count);
        map.put("rows",list);
        return map;
    }

    @Override
    public void deleteDrugByids(Drug drug) {
        String [] array=drug.getIds().split(",");
        List<Integer> idslist = new ArrayList<>();
        for(int i=0;i<array.length;i++){
            idslist.add(Integer.valueOf(array[i]));
        }
        drugMapper.deleteDrugByids(idslist);
    }

    @Override
    public void updateDrugByState(Drug drug) { drugMapper.updateDrugByState(drug);
    }

    @Override
    public void updateDrugByStates(Drug drug) { drugMapper.updateDrugByStates(drug);
    }

    @Override
    public List<LinkedHashMap<String,Object>> toexcel() {
        return drugMapper.toexcel();
    }

    @Override
    public void saveUploadExcelFiles(List<Drug> drugList) {
        drugMapper.saveUploadExcelFiles(drugList);
    }
}

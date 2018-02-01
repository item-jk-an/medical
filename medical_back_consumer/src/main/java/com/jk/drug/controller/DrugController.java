package com.jk.drug.controller;

import com.jk.flow.model.Drug;
import com.jk.drug.service.DrugService;
import com.jk.drug.util.ExportExcel;
import com.jk.drug.service.ImportExcleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:44 2018/1/23
 * @Modified By：
 */
@Controller
@RequestMapping("drug")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @RequestMapping("toshowDrugList")
    public  String   toshowDrugList(){
        return "drug/showDrugList";
    }
    //查询
    @RequestMapping("queryDrugAll")
    @ResponseBody
    public Map<String,Object> queryDrugAll(Integer pageSize, Integer start, Drug drug){
        return drugService.queryDrugAll(pageSize,start,drug);
    }
    //跳转模态窗口
    @RequestMapping("drugDialog")
    @ResponseBody
    public ModelAndView drugDialog(Drug drug){
        HashMap<String, Object> model=new HashMap<>();
        if(drug!=null && drug.getDrugId()!= null){
            drug = drugService.drugDialog(drug.getDrugId());
            model.put("drug", drug);
        }
        return new ModelAndView("/drug/drug-dialog", model);
    }
    //提交方式
    @RequestMapping("drugSubmit")
    @ResponseBody
    public void  drugSubmit(Drug  drug){
        if(drug.getDrugId() != null){
            //修改方法
            drugService.updateDrugInfo(drug);
        }else{
            //  保存方法
            drugService.saveDrugInfo(drug);
        }
    }
    //跳转回收站页面
    @RequestMapping("torecycleDrugList")
    public  String   torecycleDrugList(){
        return "drug/recycleDrugList";
    }
    //查询
    @RequestMapping("queryDrugByState")
    @ResponseBody
    public Map<String,Object> queryDrugByState(Integer pageSize, Integer start, Drug drug){
        return drugService.queryDrugByState(pageSize,start,drug);
    }
    //批量删除
    @RequestMapping("deleteDrugByids")
    @ResponseBody
    public void  deleteDrugByids(Drug drug){
        drugService.deleteDrugByids(drug);
    }
    //删除--修改状态
    @RequestMapping("updateDrugByState")
    @ResponseBody
    public  void  updateDrugByState(Drug drug){
        drugService.updateDrugByState(drug);
    }
    //还原--修改状态
    @RequestMapping("updateDrugByStates")
    @ResponseBody
    public  void  updateDrugByStates(Drug drug){
        drugService.updateDrugByStates(drug);
    }
    //查看信息页面
    @RequestMapping("tolookDrugInfo")
    @ResponseBody
    public ModelAndView tolookDrugInfo(Drug drug){
        HashMap<String, Object> model=new HashMap<>();
        drug = drugService.drugDialog(drug.getDrugId());
        model.put("drug", drug);
        return new ModelAndView("/drug/lookDrugInfo", model);
    }
    //以excel形式导出
    @RequestMapping("toexcel")
    public  void   toexcel(HttpServletResponse response, Drug drug){
        List<LinkedHashMap<String,Object>> list=drugService.toexcel(); //  查询数据
        //  设置标头
        String [ ] rowName={"序号","药品名称","药品品牌","药品添加时间","药品修改时间","药品状态","药品类型","审核情况","药品简介","药品点击量","药品价格","药品评分","展示级别","药品出厂"};
        List<Object[]> dataList=new ArrayList<Object[]>();
        for (int i = 0; i < list.size(); i++) {
            LinkedHashMap<String, Object> map = list.get(i);
            Object[] array = map.values().toArray();
            dataList.add(array);
        }
        ExportExcel exportExcel = new ExportExcel("药品信息",rowName, dataList, response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //导入excel数据
    @RequestMapping("importexcel")
    public String importexcel(@RequestParam  MultipartFile excle){
        String fileName = excle.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if (suffix.equals(".xls")) {
            ImportExcleUtil.HSSFImportExclOld(excle,drugService);
        }else{
            ImportExcleUtil.XSSFImportExcl(excle,drugService);
        }

       return "drug/showDrugList";
    }
}

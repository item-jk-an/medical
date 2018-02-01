package com.jk.supplier.controller;

import com.jk.drug.util.ExportExcel;
import com.jk.supplier.pojo.Supplier;
import com.jk.supplier.service.ImportExcleSupplier;
import com.jk.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 23:32 2018/1/24
 * @Modified By：
 */
@Controller
@RequestMapping("supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;


    @RequestMapping("toshowSupplierList")
    public String toshowSupplierList() {
        return "supplier/showSupplierList";
    }

    //查询
    @RequestMapping("querySupplierAll")
    @ResponseBody
    public Map<String, Object> querySupplierAll(Integer pageSize, Integer start, Supplier supplier) {
        return supplierService.querySupplierAll(pageSize, start, supplier);
    }

    //回显
    @RequestMapping("querySupplierById")
    @ResponseBody
    public ModelAndView querySupplierById(Integer id){
        ModelAndView mv = new ModelAndView();
        Supplier supplier= supplierService.querySupplierById(id);
        mv.addObject("supplier", supplier);
        mv.setViewName("/supplier/lookSupplierInfo");
        return mv;
    }
    //以excel形式导出
    @RequestMapping("toexcel")
    public void toexcel(HttpServletResponse response, Supplier supplier) {
        List<LinkedHashMap<String, Object>> list = supplierService.toexcel(); //  查询数据
        //  设置标头
        String[] rowName = {"序号", "供应商名称", "联系电话", "供应商地址", "信誉等级", "供应商简介", "供应商点击量", "添加时间", "修改时间", "联系人", "供应商类型", "经营范围", "审核状态", "代理品牌"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        for (int i = 0; i < list.size(); i++) {
            LinkedHashMap<String, Object> map = list.get(i);
            Object[] array = map.values().toArray();
            dataList.add(array);
        }
        ExportExcel exportExcel = new ExportExcel("供应商信息", rowName, dataList, response);
        try {
            exportExcel.export();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //导入excel数据
    @RequestMapping("importexcel")
    public String importexcel(@RequestParam MultipartFile excle){
        String fileName = excle.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        if (suffix.equals(".xls")) {
            ImportExcleSupplier.HSSFImportExclOld(excle,supplierService);
        }else{
            ImportExcleSupplier.XSSFImportExcl(excle,supplierService);
        }
        return "supplier/showSupplierList";
    }
}

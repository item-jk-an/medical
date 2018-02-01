package com.jk.kit.controller;


import com.jk.drug.util.ExportExcel;
import com.jk.flow.model.Kit;
import com.jk.kit.service.ImportExcleKit;
import com.jk.kit.service.KitService;
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
 * @Date：Created in 19:14 2018/1/24
 * @Modified By：
 */
@Controller
@RequestMapping("kit")
public class KitController {
    @Autowired
    private KitService kitService;

    @RequestMapping("toshowKitList")
    public String toshowKitList() {
        return "kit/showKitList";
    }

    //查询
    @RequestMapping("queryKitAll")
    @ResponseBody
    public Map<String, Object> queryKitAll(Integer pageSize, Integer start, Kit kit) {
        return kitService.queryKitAll(pageSize, start, kit);
    }

    //回显
    @RequestMapping("queryKitById")
    @ResponseBody
    public ModelAndView queryKitById(Integer id) {
        ModelAndView mv = new ModelAndView();
        Kit kit = kitService.queryKitById(id);
        mv.addObject("kit", kit);
        mv.setViewName("/kit/lookKitInfo");
        return mv;
    }

    //以excel形式导出
    @RequestMapping("toexcel")
    public void toexcel(HttpServletResponse response, Kit kit) {
        List<LinkedHashMap<String, Object>> list = kitService.toexcel(); //  查询数据
        //  设置标头
        String[] rowName = {"序号", "器械名称", "器械类型", "器械状态", "器械名牌", "生产时间", "修改时间", "审核情况", "展示等级", "器械点击量", "器械评分", "器械价格", "器械简介", "出厂公司"};
        List<Object[]> dataList = new ArrayList<Object[]>();
        for (int i = 0; i < list.size(); i++) {
            LinkedHashMap<String, Object> map = list.get(i);
            Object[] array = map.values().toArray();
            dataList.add(array);
        }
        ExportExcel exportExcel = new ExportExcel("器械信息", rowName, dataList, response);
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
            ImportExcleKit.HSSFImportExclOld(excle,kitService);
        }else{
            ImportExcleKit.XSSFImportExcl(excle,kitService);
        }

        return "kit/showKitList";
    }
}
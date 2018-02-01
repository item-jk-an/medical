/** 
 * <pre>项目名称:ztree 
 * 文件名称:ImportExcleUtil.java 
 * 包名:com.jk.util 
 * 创建日期:2018年1月2日下午3:35:48 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.drug.service;

import com.jk.drug.util.MyThreadPool;
import com.jk.flow.model.Drug;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:44 2018/1/23
 * @Modified By：
 */
public class ImportExcleUtil {

	public static void HSSFImportExclOld(MultipartFile excle, DrugService drugService){
		InputStream inputStream;
		try {
			inputStream = excle.getInputStream();
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
			Integer sheetNumber = hssfWorkbook.getNumberOfSheets();
			if (sheetNumber != null && sheetNumber != 0) {
				List<Drug> drugList = new ArrayList<>();
				for (int i = 0; i < sheetNumber; i++) {
					HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
					Integer lastRowNum = sheet.getLastRowNum();
					for (int j = 3; j <= lastRowNum; j++) {
						HSSFRow row = sheet.getRow(j);
						Drug drug = new Drug();
						String cell1 = row.getCell(1).getStringCellValue();
						drug.setDrugName(cell1);
						String cell2 = row.getCell(2).getStringCellValue();
						drug.setDrugBrand(Short.parseShort(cell2));
						/*Date cell3 = row.getCell(3).getDateCellValue();*/
						drug.setDrugAdddate(new Date());
					    String cell5 = row.getCell(5).getStringCellValue();
						drug.setDrugState(Short.parseShort(cell5));
						String cell6 = row.getCell(6).getStringCellValue();
						drug.setDrugType(Short.parseShort(cell6));
						String cell7 = row.getCell(7).getStringCellValue();
						drug.setDrugShen(Short.parseShort(cell7));
						String cell8 = row.getCell(8).getStringCellValue();
						drug.setDrugInfo(cell8);
						String cell10 = row.getCell(10).getStringCellValue();
						drug.setDrugPrice(Integer.parseInt(cell10));
						String cell11 = row.getCell(11).getStringCellValue();
						drug.setDrugGrade(Integer.parseInt(cell11));
						String cell12 = row.getCell(12).getStringCellValue();
						drug.setDrugShowlevel(Short.parseShort(cell12));
						String cell13 = row.getCell(13).getStringCellValue();
						drug.setDrugCompany(cell13);
						drugList.add(drug);
						if (drugList.size() == 2 || (i == sheetNumber - 1 && j == lastRowNum)) {
							MyRunableThread runableThread = new MyRunableThread(drugList,drugService);
							MyThreadPool.executeFixedThreadPool(runableThread);
							drugList = new ArrayList<>();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void XSSFImportExcl(MultipartFile excle, DrugService drugService){
		InputStream inputStream;
		try {
			inputStream = excle.getInputStream();
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			Integer sheetNumber = xssfWorkbook.getNumberOfSheets();
			if (sheetNumber != null && sheetNumber != 0) {
				List<Drug> drugList = new ArrayList<>();
				for (int i = 0; i < sheetNumber; i++) {
					XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
					Integer lastRowNum = sheet.getLastRowNum();
					for (int j = 3; j <= lastRowNum; j++) {
						XSSFRow row = sheet.getRow(j);
						Drug drug = new Drug();
						String cell1 = row.getCell(1).getStringCellValue();
						drug.setDrugName(cell1);
						String cell2 = row.getCell(2).getStringCellValue();
						drug.setDrugBrand(Short.parseShort(cell2));
						/*Date cell3 = row.getCell(3).getDateCellValue();*/
						drug.setDrugAdddate(new Date());
						String cell5 = row.getCell(5).getStringCellValue();
						drug.setDrugState(Short.parseShort(cell5));
						String cell6 = row.getCell(6).getStringCellValue();
						drug.setDrugType(Short.parseShort(cell6));
						String cell7 = row.getCell(7).getStringCellValue();
						drug.setDrugShen(Short.parseShort(cell7));
						String cell8 = row.getCell(8).getStringCellValue();
						drug.setDrugInfo(cell8);
						String cell10 = row.getCell(10).getStringCellValue();
						drug.setDrugPrice(Integer.parseInt(cell10));
						String cell11 = row.getCell(11).getStringCellValue();
						drug.setDrugGrade(Integer.parseInt(cell11));
						String cell12 = row.getCell(12).getStringCellValue();
						drug.setDrugShowlevel(Short.parseShort(cell12));
						String cell13 = row.getCell(13).getStringCellValue();
						drug.setDrugCompany(cell13);
						drugList.add(drug);
						if (drugList.size() == 2 || (i == sheetNumber - 1 && j == lastRowNum)) {
							MyRunableThread runableThread = new MyRunableThread(drugList,drugService);
							MyThreadPool.executeFixedThreadPool(runableThread);
							drugList = new ArrayList<>();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

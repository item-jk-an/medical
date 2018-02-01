/** 
 * <pre>项目名称:ztree 
 * 文件名称:ImportExcleUtil.java 
 * 包名:com.jk.util 
 * 创建日期:2018年1月2日下午3:35:48 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.kit.service;

import com.jk.drug.util.MyThreadPool;
import com.jk.flow.model.Kit;
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
public class ImportExcleKit {

	public static void HSSFImportExclOld(MultipartFile excle, KitService kitService){
		InputStream inputStream;
		try {
			inputStream = excle.getInputStream();
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
			Integer sheetNumber = hssfWorkbook.getNumberOfSheets();
			if (sheetNumber != null && sheetNumber != 0) {
				List<Kit> kitList = new ArrayList<>();
				for (int i = 0; i < sheetNumber; i++) {
					HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
					Integer lastRowNum = sheet.getLastRowNum();
					for (int j = 3; j <= lastRowNum; j++) {
						HSSFRow row = sheet.getRow(j);
						Kit  kit = new Kit();
						String cell1 = row.getCell(1).getStringCellValue();
						kit.setKitName(cell1);
						String cell2 = row.getCell(2).getStringCellValue();
						kit.setKitType(Short.parseShort(cell2));
						String cell3 = row.getCell(3).getStringCellValue();
						kit.setKitState(Short.parseShort(cell3));
						String cell4 = row.getCell(4).getStringCellValue();
						kit.setKitBrand(Short.parseShort(cell4));
						/*Date cell5 = row.getCell(5).getDateCellValue();*/
						kit.setKitAdddate(new Date());
						String cell7 = row.getCell(7).getStringCellValue();
						kit.setKitShen(Short.parseShort(cell7));
						String cell8 = row.getCell(8).getStringCellValue();
						kit.setKitShowlevel(Short.parseShort(cell8));
						String cell10 = row.getCell(10).getStringCellValue();
						kit.setKitGrade(Integer.parseInt(cell10));
						String cell11 = row.getCell(11).getStringCellValue();
						kit.setKitPrice(Integer.parseInt(cell11));
						String cell12 = row.getCell(12).getStringCellValue();
						kit.setKitInfo(cell12);
						String cell13 = row.getCell(13).getStringCellValue();
						kit.setKitCompany(cell13);
						kitList.add(kit);
						if (kitList.size() == 2 || (i == sheetNumber - 1 && j == lastRowNum)) {
                            MyRunableThreadKit runableThreadKit = new MyRunableThreadKit(kitList,kitService);
							MyThreadPool.executeFixedThreadPool(runableThreadKit);
							kitList = new ArrayList<>();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void XSSFImportExcl(MultipartFile excle,KitService kitService){
		InputStream inputStream;
		try {
			inputStream = excle.getInputStream();
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			Integer sheetNumber = xssfWorkbook.getNumberOfSheets();
			if (sheetNumber != null && sheetNumber != 0) {
				List<Kit> kitList = new ArrayList<>();
				for (int i = 0; i < sheetNumber; i++) {
					XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
					Integer lastRowNum = sheet.getLastRowNum();
					for (int j = 3; j <= lastRowNum; j++) {
						XSSFRow row = sheet.getRow(j);
                        Kit  kit = new Kit();
                        String cell1 = row.getCell(1).getStringCellValue();
                        kit.setKitName(cell1);
						String cell2 = row.getCell(2).getStringCellValue();
						kit.setKitType(Short.parseShort(cell2));
						String cell3 = row.getCell(3).getStringCellValue();
						kit.setKitState(Short.parseShort(cell3));
						String cell4 = row.getCell(4).getStringCellValue();
						kit.setKitBrand(Short.parseShort(cell4));
						kit.setKitAdddate(new Date());
						String cell7 = row.getCell(7).getStringCellValue();
						kit.setKitShen(Short.parseShort(cell7));
						String cell8 = row.getCell(8).getStringCellValue();
						kit.setKitShowlevel(Short.parseShort(cell8));
						String cell10 = row.getCell(10).getStringCellValue();
						kit.setKitGrade(Integer.parseInt(cell10));
						String cell11 = row.getCell(11).getStringCellValue();
						kit.setKitPrice(Integer.parseInt(cell11));
						String cell12 = row.getCell(12).getStringCellValue();
						kit.setKitInfo(cell12);
						String cell13 = row.getCell(13).getStringCellValue();
						kit.setKitCompany(cell13);
                        kitList.add(kit);
						if (kitList.size() == 2 || (i == sheetNumber - 1 && j == lastRowNum)) {
							MyRunableThreadKit runableThreadKit = new MyRunableThreadKit(kitList,kitService);
                            MyThreadPool.executeFixedThreadPool(runableThreadKit);
                            kitList = new ArrayList<>();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

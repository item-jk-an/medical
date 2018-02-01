/** 
 * <pre>项目名称:ztree 
 * 文件名称:ImportExcleUtil.java 
 * 包名:com.jk.util 
 * 创建日期:2018年1月2日下午3:35:48 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.supplier.service;

import com.jk.drug.util.MyThreadPool;
import com.jk.supplier.pojo.Supplier;
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
public class ImportExcleSupplier {

	public static void HSSFImportExclOld(MultipartFile excle,SupplierService supplierService){
		InputStream inputStream;
		try {
			inputStream = excle.getInputStream();
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
			Integer sheetNumber = hssfWorkbook.getNumberOfSheets();
			if (sheetNumber != null && sheetNumber != 0) {
				List<Supplier> suppliersList = new ArrayList<>();
				for (int i = 0; i < sheetNumber; i++) {
					HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
					Integer lastRowNum = sheet.getLastRowNum();
					for (int j = 3; j <= lastRowNum; j++) {
						HSSFRow row = sheet.getRow(j);
						Supplier supplier = new Supplier();
						String cell1 = row.getCell(1).getStringCellValue();
						supplier.setSupName(cell1);
						String cell2 = row.getCell(2).getStringCellValue();
						supplier.setSupPhone(cell2);
						String cell3 = row.getCell(3).getStringCellValue();
						supplier.setSupAddress(cell3);
						String cell4 = row.getCell(4).getStringCellValue();
						supplier.setSupCreditlevel(Short.parseShort(cell4));
						String cell5 = row.getCell(5).getStringCellValue();
						supplier.setSupInfo(cell5);
						/*Date cell7 = row.getCell(7).getDateCellValue();*/
						supplier.setSupAdddate(new Date());
						String cell9 = row.getCell(9).getStringCellValue();
						supplier.setSupLinkman(cell9);
						String cell10 = row.getCell(10).getStringCellValue();
						supplier.setSupType(Short.parseShort(cell10));
						String cell11 = row.getCell(11).getStringCellValue();
						supplier.setSupFrame(cell11);
						String cell12 = row.getCell(12).getStringCellValue();
						supplier.setSupCheckstate(Short.parseShort(cell12));
						String cell13 = row.getCell(13).getStringCellValue();
						supplier.setSupBrand(Short.parseShort(cell13));

						suppliersList.add(supplier);
						if (suppliersList.size() == 2 || (i == sheetNumber - 1 && j == lastRowNum)) {
                            MyRunableThreadSupplier runableThreadSupplier = new MyRunableThreadSupplier(suppliersList,supplierService);
							MyThreadPool.executeFixedThreadPool(runableThreadSupplier);
							suppliersList = new ArrayList<>();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void XSSFImportExcl(MultipartFile excle,SupplierService supplierService){
		InputStream inputStream;
		try {
			inputStream = excle.getInputStream();
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
			Integer sheetNumber = xssfWorkbook.getNumberOfSheets();
			if (sheetNumber != null && sheetNumber != 0) {
				List<Supplier> suppliersList = new ArrayList<>();
				for (int i = 0; i < sheetNumber; i++) {
					XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
					Integer lastRowNum = sheet.getLastRowNum();
					for (int j = 3; j <= lastRowNum; j++) {
						XSSFRow row = sheet.getRow(j);
						Supplier supplier = new Supplier();
						String cell1 = row.getCell(1).getStringCellValue();
						supplier.setSupName(cell1);
						String cell2 = row.getCell(2).getStringCellValue();
						supplier.setSupPhone(cell2);
						String cell3 = row.getCell(3).getStringCellValue();
						supplier.setSupAddress(cell3);
						String cell4 = row.getCell(4).getStringCellValue();
						supplier.setSupCreditlevel(Short.parseShort(cell4));
						String cell5 = row.getCell(5).getStringCellValue();
						supplier.setSupInfo(cell5);
						/*Date cell7 = row.getCell(7).getDateCellValue();*/
						supplier.setSupAdddate(new Date());
						String cell9 = row.getCell(9).getStringCellValue();
						supplier.setSupLinkman(cell9);
						String cell10 = row.getCell(10).getStringCellValue();
						supplier.setSupType(Short.parseShort(cell10));
						String cell11 = row.getCell(11).getStringCellValue();
						supplier.setSupFrame(cell11);
						String cell12 = row.getCell(12).getStringCellValue();
						supplier.setSupCheckstate(Short.parseShort(cell12));
						String cell13 = row.getCell(13).getStringCellValue();
						supplier.setSupBrand(Short.parseShort(cell13));
						suppliersList.add(supplier);
						if (suppliersList.size() == 2 || (i == sheetNumber - 1 && j == lastRowNum)) {
							MyRunableThreadSupplier runableThreadSupplier = new MyRunableThreadSupplier(suppliersList,supplierService);
							MyThreadPool.executeFixedThreadPool(runableThreadSupplier);
							suppliersList = new ArrayList<>();
						}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

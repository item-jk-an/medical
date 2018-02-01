/**
 * <pre>项目名称:ztree
 * 文件名称:MyRunableThread.java
 * 包名:com.jk.util
 * 创建日期:2018年1月2日下午4:04:31
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.jk.supplier.service;

import com.jk.supplier.pojo.Supplier;

import java.util.List;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:44 2018/1/23
 * @Modified By：
 */
public class MyRunableThreadSupplier implements Runnable {


	private SupplierService supplierService;

	private List<Supplier> suppliersList;
	/**
	 *
	 */
	@Override
	public void run() {
		saveProductList();
	}

	public synchronized void saveProductList(){
		supplierService.saveUploadExcelFiles(suppliersList);
	}
	/**
	 * <pre>创建一个新的实例 MyRunableThread.
	 *    </pre>
	 */
	public MyRunableThreadSupplier() {
		super();
	}


	/**
	 * <pre>创建一个新的实例 MyRunableThread.
	 *
	 * @param suppliersList</pre>
	 */
	public MyRunableThreadSupplier(List<Supplier> suppliersList, SupplierService supplierService) {
		super();
		this.supplierService = supplierService;
		this.suppliersList = suppliersList;
	}

}

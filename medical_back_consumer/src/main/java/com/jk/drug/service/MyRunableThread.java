/**
 * <pre>项目名称:ztree
 * 文件名称:MyRunableThread.java
 * 包名:com.jk.util
 * 创建日期:2018年1月2日下午4:04:31
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.jk.drug.service;

import com.jk.flow.model.Drug;

import java.util.List;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:44 2018/1/23
 * @Modified By：
 */
public class MyRunableThread implements Runnable {


	private DrugService drugService;

	private List<Drug> drugList;
	/**
	 *
	 */
	@Override
	public void run() {
		saveProductList();
	}

	public synchronized void saveProductList(){
		drugService.saveUploadExcelFiles(drugList);
	}
	/**
	 * <pre>创建一个新的实例 MyRunableThread.
	 *    </pre>
	 */
	public MyRunableThread() {
		super();
	}


	/**
	 * <pre>创建一个新的实例 MyRunableThread.
	 *
	 * @param drugList</pre>
	 */
	public MyRunableThread(List<Drug> drugList, DrugService drugService) {
		super();
		this.drugService = drugService;
		this.drugList = drugList;
	}

}

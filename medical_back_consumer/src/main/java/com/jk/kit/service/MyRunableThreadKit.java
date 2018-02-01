/**
 * <pre>项目名称:ztree
 * 文件名称:MyRunableThread.java
 * 包名:com.jk.util
 * 创建日期:2018年1月2日下午4:04:31
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.jk.kit.service;

import com.jk.flow.model.Kit;

import java.util.List;

/**
 * @Author：ZhangHuihui_java
 * @Description：
 * @Date：Created in 19:44 2018/1/23
 * @Modified By：
 */
public class MyRunableThreadKit implements Runnable {


	private KitService kitService;

	private List<Kit> kitList;
	/**
	 *
	 */
	@Override
	public void run() {
		saveProductList();
	}

	public synchronized void saveProductList(){
		kitService.saveUploadExcelFiles(kitList);
	}
	/**
	 * <pre>创建一个新的实例 MyRunableThread.
	 *    </pre>
	 */
	public MyRunableThreadKit() {
		super();
	}


	/**
	 * <pre>创建一个新的实例 MyRunableThread.
	 *
	 * @param kitList</pre>
	 */
	public MyRunableThreadKit(List<Kit> kitList, KitService kitService) {
		super();
		this.kitService = kitService;
		this.kitList = kitList;
	}

}

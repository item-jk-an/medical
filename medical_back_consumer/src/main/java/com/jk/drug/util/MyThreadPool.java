package com.jk.drug.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
	static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
	static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
	static ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();  
	//缓存线程池
	public static void executeCacheThreadPool(Runnable runnable){
		 cachedThreadPool.execute(runnable);
	}
	//定长线程池
	public static void executeFixedThreadPool(Runnable runnable){
		fixedThreadPool.execute(runnable);
	}
	
	//定时定长线程池
	public static void executeScheduledThreadPool(Runnable runnable,long time,TimeUnit unit){
		scheduledThreadPool.schedule(runnable, time, unit);
	}
	
	//单个线程池（有顺序）
	public static void executeSingleThreadPool(Runnable runnable){
		singleThreadExecutor.execute(runnable);
	}
	 
	
	
}

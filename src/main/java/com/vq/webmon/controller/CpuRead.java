package com.vq.webmon.controller;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.management.MBeanServerConnection;

public class CpuRead {

	MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();

	OperatingSystemMXBean osMBean;

	public Long getCpuProsentase() {

		try {
			osMBean = ManagementFactory.newPlatformMXBeanProxy(mbsc,
					ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
					OperatingSystemMXBean.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		long nanoBefore = System.nanoTime();
		long cpuBefore = osMBean.getAvailableProcessors();

		long cpuAfter = osMBean.getAvailableProcessors();
		long nanoAfter = System.nanoTime();

		long percent;
		if (nanoAfter > nanoBefore) {
			percent = ((cpuAfter - cpuBefore) * 100L)
					/ (nanoAfter - nanoBefore);
		} else {
			percent = 0;
			System.out.println("CPU : " + percent);
		}
		return percent;
	}
	
	

	public Double getFreeRam() {
		Double data = 0.0;
		OperatingSystemMXBean bean = ManagementFactory
				.getOperatingSystemMXBean();
		Method m[] = bean.getClass().getDeclaredMethods();
		System.out.println("Method : " + m[2].getName());
		double memoryOnGb = 1000000000;
		Long memorySize;
		m[2].setAccessible(true);
		try {
			memorySize = (Long) m[2].invoke(bean);
			data = memorySize / memoryOnGb;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
	
	

	public Double getTotalRam() {
		Double data = 0.0;
		OperatingSystemMXBean bean = ManagementFactory
				.getOperatingSystemMXBean();
		Method m[] = bean.getClass().getDeclaredMethods();
		System.out.println("Method : " + m[7].getName());
		double memoryOnGb = 1000000000;
		Long memorySize;
		m[7].setAccessible(true);
		try {
			memorySize = (Long) m[7].invoke(bean);
			data = memorySize / memoryOnGb;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	

	public void printUsage() {
		OperatingSystemMXBean operatingSystemMXBean = ManagementFactory
				.getOperatingSystemMXBean();
		for (Method method : operatingSystemMXBean.getClass()
				.getDeclaredMethods()) {
			method.setAccessible(true);
			if (method.getName().startsWith("get")
					&& Modifier.isPublic(method.getModifiers())) {
				Object value;
				try {
					value = method.invoke(operatingSystemMXBean);
				} catch (Exception e) {
					value = e;
				}
				System.out.println(method.getName() + " = " + value);
			}
		}
	}

}

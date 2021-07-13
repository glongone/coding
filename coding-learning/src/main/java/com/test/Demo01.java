package com.test;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author glongone
 * @date 2021/7/13 1:26 下午
 * @desc
 */
public class Demo01 extends Demo {

	public static void main(String[] args) {
		Demo01 demo01 = new Demo01();
		demo01.addDebugInfo("test", new Object());
	}

	public void addDebugInfo(String debugKey, Object debugInfo) {
		if (StringUtils.isNotEmpty(debugKey) && null != debugInfo) {
			if (null == this.debugInfo) {
				this.debugInfo = new HashMap<String, Object>();
			}
			this.debugInfo.put(debugKey, debugInfo);
		}
	}



}

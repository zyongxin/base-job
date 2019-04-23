package com.bhzy.carnet.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常信息的处理
 * @author huangbin
 *
 */
public class ExceptionUtil {

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String getStackTraceAsString(Throwable e) {
		if (e == null){
			return "";
		}
		StringWriter stringWriter = new StringWriter();
		try {
			e.printStackTrace(new PrintWriter(stringWriter));
			return stringWriter.toString();
		} finally {
			try {
				stringWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

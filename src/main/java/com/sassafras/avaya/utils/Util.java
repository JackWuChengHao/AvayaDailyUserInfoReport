package com.sassafras.avaya.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Util {

	private final static Logger logger =  Logger.getLogger(Util.class);


	/**
	 * 关闭Connection
	 * @param connection
	 */
	public static  void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	/**
	 * 关闭Statement
	 * @param st
	 */
	public static  void closeStatement(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			logger.error(e);
		}
	}

	/**
	 * 获取文件后缀名的日期
	 * @return
	 */
	public static String getFileSuffix() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("MMddyyyy");
		return format.format(calendar.getTime());
	}

	/**
	 * 删除文件
	 * @param fileName
	 */
	public static void delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			logger.error("delete "+ fileName + "is not existed");
			return;
		} else {
			if (file.delete()) {
				logger.info("delete"+fileName +"success");
			} else {
				logger.info("delete"+fileName +"failed");
			}
		}
	}


	/**
	 * 根据格式化字符串获取对应时间
	 * @param fotmatString
	 * @return
	 */
	public static String getCurrentTimeByFormatString(String fotmatString) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(fotmatString);
		return format.format(calendar.getTime());
	}

}

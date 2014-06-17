package com.xiruibin;

import java.util.HashMap;
import java.util.Map;

public class DBInfo {

	public static String dbtype = null;

	public final static Map<String, String> DB_DRIVER_MAP = new HashMap<String, String>();

	public final static Map<String, String> DB_URL_MAP = new HashMap<String, String>();

	static {
		DB_DRIVER_MAP.put("mysql", "com.mysql.jdbc.Driver");
		DB_DRIVER_MAP.put("sqlserver2000",
				"com.microsoft.jdbc.sqlserver.SQLServerDriver");
		DB_DRIVER_MAP.put("sqlserver2005",
				"com.microsoft.sqlserver.jdbc.SQLServerDriver");
		DB_DRIVER_MAP.put("postgresql", "org.postgresql.Driver");
		DB_DRIVER_MAP.put("db2", "org.postgresql.Driver");
		DB_DRIVER_MAP.put("oracle", "oracle.jdbc.driver.OracleDriver");

		DB_URL_MAP.put("mysql", "jdbc:mysql://127.0.0.1:3306/db");
		DB_URL_MAP.put("sqlserver2000",
				"jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=db");
		DB_URL_MAP.put("sqlserver2005",
				"jdbc:sqlserver://127.0.0.1:1433;DatabaseName=db");
		DB_URL_MAP.put("postgresql", "jdbc:postgresql://127.0.0.1:5432/db");
		DB_URL_MAP.put("db2", "jdbc:db2://127.0.0.1:50000/db");
		DB_URL_MAP.put("oracle", "jdbc:oracle:thin:@127.0.0.1:1521:db");
	}

}

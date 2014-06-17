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

		DB_URL_MAP.put("mysql", "jdbc:mysql://127.0.0.1:3306/scutcs");
		DB_URL_MAP
				.put("sqlserver2000",
						"jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=sample");
		DB_URL_MAP.put("sqlserver2005",
				"jdbc:sqlserver://localhost:1433;DatabaseName=test");
		DB_URL_MAP.put("postgresql", "jdbc:postgresql://localhost:5432/testdb");
		DB_URL_MAP.put("db2", "jdbc:db2://192.168.0.93:50000/CPICSMS");
		DB_URL_MAP.put("oracle", "jdbc:oracle:thin:@10.10.20.15:1521:ora9");
	}

}

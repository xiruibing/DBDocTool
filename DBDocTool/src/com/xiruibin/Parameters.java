package com.xiruibin;

import com.xiruibin.db.util.StringUtils;

public final class Parameters {
	private String host = "192.168.1.170";
	private String user;
	private String port = "50001";// 默认值
	private String password;
	private String database;
	private String schema;
	private String table = "_NULL_";
	private String path = "";

	public Parameters() {
	}

	public Parameters(String host, String user, String port, String password,
			String database, String table, String path) {
		this.host = host;
		this.user = user;
		this.port = port;
		this.password = password;
		this.database = database;
		this.table = table;
		this.path = path;
	}
	
	public Parameters(String host, String user, String port, String password,
			String database, String schema, String table, String path) {
		this.host = host;
		this.user = user;
		this.port = port;
		this.password = password;
		this.database = database;
		this.schema = schema;
		this.table = table;
		this.path = path;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		if (StringUtils.hasLength(host)) {
			this.host = host;
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		if (StringUtils.hasLength(port)) {
			this.port = port;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		if (StringUtils.hasLength(table)) {
			this.table = table;
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if (StringUtils.hasLength(path)) {
			this.path = path;
		}
	}

}

package com.xiruibin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.xiruibin.db.util.CMDHelper;
import com.xiruibin.db.util.DBUtils;

public class CMDTool {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Input Command:");
		String cmd = sc.nextLine();

		Parameters parameters = CMDHelper.parseCommand(cmd);

		if (parameters == null) {
			System.err.println("parameter parse exception.");
			System.exit(-1);
		}
		
		System.err.println(parameters.getHost());
		System.err.println(parameters.getPort());
		System.err.println(parameters.getDatabase());
		System.err.println(parameters.getUser());

		DBUtils dbUtils = new DBUtils(parameters);

		long startTime = System.currentTimeMillis();

		Map<String, LinkedHashMap<String, LinkedHashMap<String, String>>> data = dbUtils
				.getDatabaseInfo();

		Word2007.productWordForm(data, parameters);

		long endTime = System.currentTimeMillis();
		System.out.println("总共用时:" + (endTime - startTime) + "ms");

	}

}

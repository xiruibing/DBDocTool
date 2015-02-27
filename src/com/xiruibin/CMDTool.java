package com.xiruibin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.xiruibin.db.util.CMDHelper;
import com.xiruibin.db.util.DBUtils;
import com.xiruibin.db.util.StringUtils;

public class CMDTool {
    
	private static Object[] string2ObjectArray(String[] arr) {
		Object[] obs = new Object[arr.length];
		for (int i=0; i<arr.length; i++) {
			obs[i] = arr[i];
		}
		return obs;
	}

	public static void main(String[] args) throws Exception {
		String cmd = "";
		if (args == null) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please Input Command:");
			cmd = sc.nextLine();
		} else {
			cmd = StringUtils.join(string2ObjectArray(args), ' ');
		}

		Parameters parameters = CMDHelper.parseCommand(cmd);

		if (parameters == null) {
			System.err.println("parameter parse exception.");
			System.exit(-1);
		}
		
		DBUtils dbUtils = new DBUtils(parameters);

		long startTime = System.currentTimeMillis();

		Map<String, LinkedHashMap<String, LinkedHashMap<String, String>>> data = dbUtils
				.getDatabaseInfo();

		Map<String, String> tableinfo = dbUtils.getTableInfo();
		
		Word2007.productWordForm(tableinfo, data, parameters);

		long endTime = System.currentTimeMillis();
		System.out.println("总共用时:" + (endTime - startTime) + "ms");

	}

}

package com.itmuch.cloud.utils;

import java.util.Arrays;

public class OpenUrlUtils {
	public static boolean openUrl(String url) {
		String[] arr=new String[] {
				"/user/find1",
		};
		return Arrays.asList(arr).indexOf(url)==-1?false:true;
	}
}

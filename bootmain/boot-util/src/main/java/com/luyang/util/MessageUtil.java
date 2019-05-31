package com.luyang.util;

public class MessageUtil {
	public static String M(String... strs){
		String methodname=Thread.currentThread().getStackTrace()[2].getMethodName();
		int index=strs.length;
		String str=methodname+"->";
		for(String s:strs){
			if(index%2==0){
				str+=s+":";
			}else if(index%2!=0){
				str+=s+";";
			}
			index--;
		}
		return str;
	}
}

package com.etcxm.Utils;

public class StringUtil {
private StringUtil(){
	
}
public static boolean hasLength(String value){
	return value!=null&&!"".equals(value.trim());
}
}

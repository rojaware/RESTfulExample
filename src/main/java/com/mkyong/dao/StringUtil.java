package com.mkyong.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "romin9801@hotmail.com romin9801@naver.com";
		String s = s1.replace(' ', ',');
		System.out.println("s is "+s);
		String s2 = "mynumber, yournumber, hisnumber";
		seperateByDelimeter(s2, ",");
	}

	public static List<String> seperateByDelimeter(String s, String delimeter) {
		List<String> list = new ArrayList<String>(Arrays.asList(s.split(delimeter)));
		
		Iterator<String> it=list.iterator();
		List<String> wordList = new ArrayList<String>();
        while(it.hasNext())
        {
          String value=(String)it.next();
          wordList.add(value.trim());
          
        }
        return wordList;
	}
	public static String print(List<String> list) {
		
		return StringUtils.join(list);
	}

}

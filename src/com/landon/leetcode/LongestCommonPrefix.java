package com.landon.leetcode;

/**
 * 14. Longest Common Prefix Write a function to find the longest common prefix
 * string amongst an array of strings.
 * 
 * @author landon.xu
 *
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        	return "";
        String prex = strs[0];
        for (int i = 1; i < strs.length; ++i) {
			prex = getCommonPrefix(prex, strs[i]);
			if(prex.equals(""))
				break;
		}
        return prex;
    }
    
    //获取两个字符串的公共前缀
    private String getCommonPrefix(String s1, String s2){
    	int i = 0;
    	int l1 = s1.length(), l2 = s2.length();
    	while(i < l1 && i < l2 && s1.charAt(i) == s2.charAt(i)){
    		i ++;
    	}
    	if(i > 0)
    		return s1.substring(0, i);
    	else return "";
    }

}

package com.landon.leetcode;

public class StrStr {
	
    public int strStr(String haystack, String needle) {
    	return kmp(haystack,needle);
    }
    
    private int kmp(String str, String pattern) {
    	if(pattern == null || pattern.length() == 0) {
    		return 0;
    	}
    	if(str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
    		return -1;
    	}
    	int p = 0;
    	int length = str.length();
    	int[] next = makeNext(pattern);
    	for(int i = 0; i < length; ++i) {
    		while( p > 0 && str.charAt(i) != pattern.charAt(p)) {
    			p = next[p - 1];
    		}
    		if(str.charAt(i) == pattern.charAt(p)) {
    			p++;
    		}
    		if(p == pattern.length()) {
    			return i - p + 1;
    		}
    	}
    	return -1;
    }
    
    private int[] makeNext(String pattern) {
    	if(pattern != null && pattern.length() > 0) {
    		int[] next = new int[pattern.length()];
    		next[0] = 0;
    		int k = 0;
    		int length = pattern.length();
    		for(int i = 1; i < length; ++i) {
    			while(k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
    				k = next[k - 1];
    			}
    			if(pattern.charAt(i) == pattern.charAt(k)) {
    				k ++;
    			}
    			next[i] = k;
    		}
    		return next;
    	}else {
    		return null;
    	}
    }
}

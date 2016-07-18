package com.landon.leetcode;

/*
 * 10. Regular Expression Matching
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class RegularExpressioinMatching {

	public boolean isMatchRecursion(String s, String p) {
		//当p为null
		if (p == null || p.length() == 0)
			return s == null;
		// 如果p长度为1的话
		if (p.length() == 1) {
			if (s != null && s.length() != 0 && s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
				return true;
			} else
				return false;
		} 
		// 如果p长度大于1时
		else {
			//下一个元素为*时，需要特殊处理
			//substring（i）当i为长度时，会返回""，超过长度时，返回null
			if (p.charAt(1) == '*') {
				if (s != null && s.length() != 0) {
					String sTemp = new String(s);
					//待匹配字符串中与*前面字符相同的字符
					while (sTemp != null && (sTemp.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
						if (isMatchRecursion(sTemp, p.length() > 2 ? p.substring(2) : null)) {
							return true;
						}
						sTemp = (sTemp.length() > 1 ? sTemp.substring(1) : null);
					}
					//待匹配字符串中与*后面的字符串的匹配
					return isMatchRecursion(sTemp, p.length() > 2 ? p.substring(2) : null);
				}else{
					return isMatchRecursion(null, p.length() > 2 ? p.substring(2) : null);
				}
				
			}
			//下一个元素不是*，可以直接进行判断
			else {
				if (s != null && s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
					return isMatchRecursion(s.length() > 1 ? s.substring(1) : null, p.length() > 1 ? p.substring(1) : null);
				} else {
					return false;
				}
			}
		}
	}

	public boolean isMatchDP(String s, String p) {
		int sLength = s.length();
		int pLength = p.length();
		//dp[i][j]表示s[0~i-1],p[0~j-1]是否匹配
		boolean [][] dp = new boolean [sLength + 1][pLength + 1];
		
		dp[0][0] = true;
		
		//初始化第一列
		for(int i = 1; i <= sLength; ++i){
			dp[i][0] = false;
		}
		
		//初始化第一行，p匹配s的空字符串
		for(int j = 1; j <= pLength; ++j){
			dp[0][j] = j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2];
		}
		
		for(int i = 1; i <= sLength; ++i){
			for(int j = 1; j <= pLength; ++j){
				if(p.charAt(j - 1) != '*'){
					dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
				}else{
					dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
				}
			}
		}
		return dp[sLength][pLength];
	}

}

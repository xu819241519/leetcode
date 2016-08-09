package com.landon.leetcode;

import java.util.Stack;

/**
 * 20. Valid Parentheses Given a string containing just the characters '(', ')',
 * '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author landon
 *
 */
public class ValidParentheses {

	/**
	 * 括号匹配，因为条件只是括号，不需要考虑数字，这就很简单了，遇到左边的括号就push,遇到右边的括号就与stack中的匹配，匹配得上就pop，否则就返回false
	 * 
	 * @param s
	 * @return
	 */
	public boolean isVaild(String s) {
		Stack stack = new Stack();
		for (int i = 0; i < s.length(); ++i) {
			if (isLeft(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty())
					return false;
				if (isLeftMatchRight((char) stack.peek(), s.charAt(i))) {
					stack.pop();
				} else
					return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	private boolean isLeft(char c) {
		if (c == '(' || c == '{' || c == '[')
			return true;
		else
			return false;
	}

	private boolean isLeftMatchRight(char left, char right) {
		if (left == '(' && right == ')' || left == '{' && right == '}' || left == '[' && right == ']')
			return true;
		else
			return false;
	}
}

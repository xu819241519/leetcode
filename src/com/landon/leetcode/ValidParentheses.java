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
	 * ����ƥ�䣬��Ϊ����ֻ�����ţ�����Ҫ�������֣���ͺܼ��ˣ�������ߵ����ž�push,�����ұߵ����ž���stack�е�ƥ�䣬ƥ����Ͼ�pop������ͷ���false
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

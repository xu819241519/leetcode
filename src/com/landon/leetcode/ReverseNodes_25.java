package com.landon.leetcode;

public class ReverseNodes_25 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(k == 0 || k == 1) {
			return head;
		}
		if(head == null || head.next == null) {
			return head;
		}
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode p = preHead;
		while(true) {
			//首先判断是否循环结束
			ListNode start = p;
			ListNode end = start;
			int count = 0;
			while(count < k - 1 && end != null) {
				end = end.next;
				count ++;
			}
			if( count < k - 1 || end.next == null) {
				break;
			}
			
			
		}
		
		return preHead.next;		
	}

}

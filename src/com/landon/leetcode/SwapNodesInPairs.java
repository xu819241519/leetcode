package com.landon.leetcode;

import java.util.List;

public class SwapNodesInPairs {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		ListNode result = head;
		ListNode p = head, q;
		if (head == null || head.next == null) {
			return head;
		} else {
			head = q = p.next;
			boolean isFirstPair = true;
			while (q != null) {
				if (isFirstPair) {
					p.next = q.next;
					q.next = p;
					q = p.next;
				}else{
					if(q.next != null){
						p.next = q.next;
						p = p.next;
						q.next = p.next;
						p.next = q;
						q = q.next;
						p = p.next;
					}else{
						break;
					}				
				}
				isFirstPair = false;
			}
			return head;
		}
	}

	public void test() {
		ListNode head = new ListNode(0);
		ListNode p = head;
		for (int i = 0; i < 10; ++i) {
			p.next = new ListNode(i + 1);
			p = p.next;
		}
		ListNode result = swapPairs(head);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}

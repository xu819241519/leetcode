package com.landon.leetcode;

import javax.swing.LayoutStyle;

/**
 * 23. Merge k Sorted Lists Merge k sorted linked lists and return it as one
 * sorted list. Analyze and describe its complexity.
 * 
 * @author landon
 *
 */
public class MergeSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
//		int size = lists.length;
//		if (size == 0)
//			return null;
//
//		ListNode head = getNextItem(lists);
//		ListNode p = head;
//		while (hasItems(lists)) {
//			p.next = getNextItem(lists);
//			p = p.next;
//		}
//		return head;
		return null;
	}
	
	

//	private boolean hasItems(ListNode[] p) {
//		for (int i = 0; i < p.length; ++i) {
//			if (p[i] != null)
//				return true;
//		}
//		return false;
//	}
//
//	private ListNode getNextItem(ListNode[] p) {
//		ListNode result = null;
//		int index = -1;
//		int maxValue = Integer.MAX_VALUE;
//		for (int i = 0; i < p.length; ++i) {
//			if (p[i] != null && p[i].val < maxValue) {
//				maxValue = p[i].val;
//				result = p[i];
//				index = i;
//			}
//		}
//		if(index != -1)
//			p[index] = p[index].next;
//		return result;
//	}

	private ListNode[] generateTest() {
		ListNode[] listNodes = new ListNode[2];
		listNodes[0] = new ListNode(1);
		listNodes[1] = new ListNode(0);
		return listNodes;
	}

	public void test(){
		ListNode result = mergeKLists(generateTest());
		while(result != null){
			System.out.println(result.val);
			result = result.next;
		}
	}

}

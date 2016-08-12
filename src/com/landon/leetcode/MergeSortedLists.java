package com.landon.leetcode;

import java.util.Arrays;
import java.util.List;

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
		if(lists == null || lists.length == 0)
			return null;
		if(lists.length == 1)
			return lists[0];

		int length = lists.length;
		int middle = length/2;
		ListNode [] l1 = new ListNode[middle];
		ListNode [] l2 = new ListNode[length - middle];
		for(int i = 0; i < middle; ++i){
			l1[i] = lists[i];
		}
		for(int i = middle; i < length; ++i){
			l2[i - middle] = lists[i];
		}
		ListNode l11 = mergeKLists(l1);
		ListNode l12 = mergeKLists(l2);
		return mergeTwoLists(l11,l12);
	}
	
	
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode p = null,head = null;
		while(l1 != null && l2 != null){
			if(head == null){
				if(l1.val < l2.val){
					head = p = l1;
					l1 = l1.next;
					p.next = null;
				}else{
					head = p = l2;
					l2 = l2.next;
					p.next = null;
				}
			}else{
				if(l1.val < l2.val){
					p.next = l1;
					p = l1;
					l1 = l1.next;
					p.next = null;
				}else{
					p.next = l2;
					p = l2;
					l2 = l2.next;
					p.next = null;
				}
			}
		}
		if(l1 != null){
			p.next = l1;
		}
		if(l2 != null){
			p.next = l2;
		}
		return head;
	}
	
	

	private ListNode[] generateTest() {
		ListNode[] listNodes = new ListNode[2];
		listNodes[0] = new ListNode(1);
		listNodes[0].next = new ListNode(3);
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

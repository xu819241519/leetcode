package com.landon.leetcode;

import java.awt.HeadlessException;
import java.util.List;

import javax.swing.LayoutStyle;

import com.landon.leetcode.MergeSortedLists.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author landon
 *
 */
public class MergeTwoSortedLists {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode p = null, result = null;
		while (l1 != null && l2 != null) {
			if (result == null) {
				if (l1.val < l2.val) {
					result = p = l1;
					l1 = l1.next;
					p.next = null;
				} else {
					result = p = l2;
					l2 = l2.next;
					p.next = null;
				}
			} else {
				if (l1.val < l2.val) {
					//ÕâÀï×¢ÒâË³Ðò
					p.next = l1;
					p = l1;
					l1 = l1.next;
					p.next = null;
				} else {
					p.next = l2;
					p = l2;
					l2 = l2.next;
					p.next = null;
				}
			}
		}
		if (l1 != null)
			p.next = l1;
		if (l2 != null)
			p.next = l2;
		return result;

	}

	public void test() {
		ListNode l1 = new ListNode(5), l2 = new ListNode(1);
		l2.next = new ListNode(2);
		ListNode result = mergeTwoLists(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}

package com.landon.leetcode;

import java.util.List;

/**
 * 19. Remove Nth Node From End of List Given a linked list, remove the nth node
 * from the end of list and return its head.
 * 
 * @author landon.xu
 *
 */
public class RemoveNthNodeFromEndOfList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 双指针思想，构造两个指针，间隔n 这里要注意边界条件！！！
	 * 
	 * @author landon.xu
	 *
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p1, p2;
		p1 = head;
		p2 = head;
		int i = 0;
		while (p1.next != null && i < n) {
			p1 = p1.next;
			i++;
		}
		// 考虑[1,2]，2这种情况，当p1指向2时，p2指向head也就是1，此时p1和p2之间间隔1一个元素，i不等于n，需要排除这种情况
		// 也就是删除倒数第n（第一个）个元素的时候
		if (p1.next == null && i < n) {
			return head.next;
		}
		while (p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		if (p2.next != null) {
			p2.next = p2.next.next;
		}

		return head;
	}

	private ListNode generateList() {
		ListNode head = new ListNode(1);
		ListNode p = head;
		p.next = new ListNode(2);
		p.next.next = null;
		// for(int i = 1; i < 10; ++i){
		// p.next = new ListNode(i);
		// p = p.next;
		// }
		return head;
	}

	public void test() {
		ListNode head = generateList();
		head = removeNthFromEnd(head, 1);
		print(head);
	}

	private void print(ListNode head) {
		ListNode pListNode = head;
		while (pListNode != null) {
			System.out.println(pListNode.val);
			pListNode = pListNode.next;
		}
	}

}

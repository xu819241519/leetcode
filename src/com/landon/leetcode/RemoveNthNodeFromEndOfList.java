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
	 * ˫ָ��˼�룬��������ָ�룬���n ����Ҫע��߽�����������
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
		// ����[1,2]��2�����������p1ָ��2ʱ��p2ָ��headҲ����1����ʱp1��p2֮����1һ��Ԫ�أ�i������n����Ҫ�ų��������
		// Ҳ����ɾ��������n����һ������Ԫ�ص�ʱ��
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

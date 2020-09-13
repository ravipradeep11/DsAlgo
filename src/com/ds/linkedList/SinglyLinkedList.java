package com.ds.linkedList;

import com.ds.trees.TreeNode;

public class SinglyLinkedList extends LinkedList {

	@Override
	public void insert(Comparable data) {
		// TODO Auto-generated method stub
		TreeNode ins = new TreeNode(data);
		if (head == null) {
			head = ins;
		} else {
			TreeNode temp = head;
			while (temp.right != null) {
				temp = temp.right;
			}
			temp.right = ins;
		}
	}

	public void reverseKunits(int k) {
		TreeNode current, prev, next;
		current = head;
		prev = null;
		while (current != null && k > 0) {

		}
	}

	public void reverse() {

		TreeNode current, prev, next;
		prev = null;
		if (head == null)
			return;
		current = head;
		while (current != null) {
			next = current.right;
			current.right = prev;
			prev = current;
			current = next;

		}
		head = prev;
	}

	public void reverseR() {
		reverseR(head, null);
	}

	private void reverseR(TreeNode node, TreeNode prev) {

		if (node == null)
			return;
		if (node.right == null) {
			head = node;
		}
		reverseR(node.right, node);
		node.right = prev;

		return;
	}

	public void reverseKnodes(int k) {
		TreeNode current, next, prev, startNode;
		current = startNode = head;
		prev = null;
		while (current != null && k-- > 0) {
			next = current.right;
			current.right = prev;
			prev = current;
			current = next;
		}
		startNode.right = current;
		head = prev;
	}

	private TreeNode reverseEveryKnodesUtil(TreeNode node, int k) {
		TreeNode headNode, current, next, prev, startNode;
		current = node;
		int n = k;
		startNode = node;
		prev = null;
		headNode = current;
		while (n-- > 0 && current != null) {
			next = current.right;
			current.right = prev;
			prev = current;
			current = next;
		}

		if (current != null)
			headNode.right = reverseEveryKnodesUtil(current, k);
		return prev;
	}

	public void reverseEveryKnodes(int k) {
		head = reverseEveryKnodesUtil(head, k);
	}

	public void reverseKAlternateNodes(int k) {
		head = reverseKAlternateNodesUtil(head, k);
	}

	private TreeNode reverseKAlternateNodesUtil(TreeNode node, int k) {
		TreeNode current, prev, next, headNode, startNode;
		int n = k;
		current = node;
		headNode = startNode = current;
		prev = null;
		while (current != null && n-- > 0) {
			next = current.right;
			current.right = prev;
			prev = current;
			current = next;

		}
		n = k;
		headNode = prev;
		startNode.right = current;

		while (current != null && n-- > 0) {
			prev = current;
			current = current.right;

		}

		if (current != null) {
			TreeNode temp = reverseKAlternateNodesUtil(current, k);
			prev.right = temp;
			System.out.println(" Prev is " + prev.data + " temp is "
					+ temp.data);

		}

		return headNode;
	}

	public void mergeSort() {
		System.out.println();
		System.out.println("Sorting linked list");
		head = mergeS(head);
	}

	private TreeNode mergeS(TreeNode headNode) {
		if (headNode == null || headNode.right == null)
			return headNode;
		TreeNode slow, fast, mid;
		slow = headNode;
		fast = headNode.right;
		TreeNode list1, list2;
		while (fast != null) {
			fast = fast.right;
			if (fast != null) {
				slow = slow.right;
				fast = fast.right;
			}
		}
		list1 = headNode;
		list2 = slow.right;

		slow.right = null;
		list1 = mergeS(list1);
		list2 = mergeS(list2);
		return sortedMerge(list1, list2);
	}

	private TreeNode sortedMerge(TreeNode list1, TreeNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		TreeNode headNode;
		if (list1.data.compareTo(list2.data) < 0) {
			list1.right = sortedMerge(list1.right, list2);
			headNode = list1;
		}

		else {
			list2.right = sortedMerge(list1, list2.right);
			headNode = list2;

		}
		return headNode;
	}

	public void addnumbers(String s1, String s2) {

		SinglyLinkedList l1 = getSinglyLinkedList(s1);
		SinglyLinkedList l2 = getSinglyLinkedList(s2);
		addLists(l1, l2);
	}

	private SinglyLinkedList getSinglyLinkedList(String s1) {
		char[] str = s1.toCharArray();
		SinglyLinkedList l1 = new SinglyLinkedList();
		for (char c : str) {
			l1.insert(c - '0');
		}
		return l1;

	}

	private void addLists(SinglyLinkedList l1, SinglyLinkedList l2) {
		int n1 = l1.getSize();
		int n2 = l2.getSize();
		int diff = n1 - n2;
		TreeNode temp = l1.head;
		TreeNode cur = temp;
		while (diff-- > 0) {
			cur = cur.right;

		}
		int[] carry = new int[] { 0 };
		TreeNode result = addEqualSizeList(cur, l2.head, carry);
		result = addCarryToRemaining(l1.head, result, cur, carry);
		if (carry[0] > 0) {
			TreeNode temp1 = new TreeNode(carry[0]);
			temp1.right = result;
			result = temp1;
		}
		SinglyLinkedList list = new SinglyLinkedList();
		list.head = result;
		list.display();

	}

	private TreeNode addCarryToRemaining(TreeNode l1Head, TreeNode result, TreeNode cur,
                                         int[] carry) {
		if (l1Head != cur) {

			TreeNode resHead = addCarryToRemaining(l1Head.right, result, cur,
					carry);
			int d = (Integer) l1Head.data + carry[0];
			TreeNode temp = new TreeNode(d % 10);
			carry[0] = d / 10;
			temp.right = resHead;
			return temp;
		}
		return result;
	}

	private TreeNode addEqualSizeList(TreeNode l1, TreeNode l2, int[] carry) {
		if (l1 == null)
			return null;
		TreeNode sumhead = new TreeNode(0);

		sumhead.right = addEqualSizeList(l1.right, l2.right, carry);

		int d1 = (Integer) l1.data;
		int d2 = (Integer) l2.data;
		int s = (d1 + d2 + carry[0]);
		carry[0] = s / 10;
		s = s % 10;
		sumhead.data = s;
		return sumhead;
	}

	public int getSize() {
		TreeNode temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			temp = temp.right;
		}
		return size;
	}
}

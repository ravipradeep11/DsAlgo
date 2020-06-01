package com.test.linkedList;

import trees.Tnode;

public class LinkedListAmazon extends SinglyLinkedList {
	
	public void reverseAlternateKNodes(int k)
	{
		System.out.println("Reversing alternate");
		head=reverseAlternateKNodesUtil(head, k);
		
	}
	private Tnode reverseAlternateKNodesUtil(Tnode node,int k)
	{
		if(node==null)
			return null;
		Tnode current,next,prev,headNode,startNode;
		current=startNode=node;
		prev=null;
		int count=0;
		while(current!=null&&count++<k)
		{
			next=current.right;
			current.right=prev;
			prev=current;
			current=next;
		}
		startNode.right=current;
		headNode=prev;
		count=0;
		while(current!=null&&count++<(k-1))
		{	prev=current;
			current=current.right;
			
		}
		if(current!=null)
		current.right=reverseAlternateKNodesUtil(current.right, k);
		return headNode;
	}
	
	public void reverseEveryKNodes(int k)
	{
		
		head=reverseEveryKNodesUtil(head, k);
		
	}
	private Tnode reverseEveryKNodesUtil(Tnode node,int k)
	{
		if(node==null)
			return null;
		Tnode headNode,current,prev,next,startNode;
		current=node;
		prev=null;
		startNode=node;
		int count=0;
		while(current!=null&&count++<k)
		{
			next=current.right;
			current.right=prev;
			prev=current;
			current=next;
			
		}
		headNode=prev;
		startNode.right=reverseEveryKNodesUtil(current, k);
		
		return headNode;
	}
	
	
	public void reverseRecursive(){
		reverseRecursiveUtil(head, null);
	}
	private void reverseRecursiveUtil(Tnode node,Tnode prev){
		if(node==null)
			return;
		if(node.right==null){
			node.right=prev;
			head=node;
		return;
		}
		reverseRecursiveUtil(node.right,node);
		node.right=prev;
		return;
	}
	
	
	public void reverseIterative(){
		Tnode current,prev,next;
		current=head;
		prev=null;
		
		while(current!=null)
		{
		next=current.right;
		current.right=prev;
		prev=current;
		current=next;
		}
		head=prev;
	}
	
	
	public void reverseKNodes(int k)
	{
		if(head==null)
			return ;
		Tnode current,prev,next,startNode;
		current=head;
		startNode=current;
		prev=null;
		
		while(current!=null&&k-->0)
		{
			next=current.right;
			current.right=prev;
			prev=current;
			current=next;
		}
		head=prev;
		startNode.right=current;
	
		return ;
	}
	
	
	
	
	public void mergeSort() {

		head = mergeSortUtil(head);

	}

	private Tnode mergeSortUtil(Tnode headNode) {
		if (headNode == null || headNode.right == null)
			return headNode;
		Tnode slow, fast;
		slow = headNode;
		fast = headNode.right;
		while (fast != null) {
			fast = fast.right;
			if (fast != null) {
				slow = slow.right;
				fast = fast.right;
			}
		}

		Tnode list1, list2;
		list1 = headNode;
		list2 = slow.right;
		slow.right = null;
		list1 = mergeSortUtil(list1);
		list2 = mergeSortUtil(list2);
		return sortedMerge(list1, list2);
	}

	private Tnode sortedMerge(Tnode list1, Tnode list2) {

		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		Tnode headNode;
		if (list1.data.compareTo(list2.data) < 0) {
			list1.right = sortedMerge(list1.right, list2);
			headNode = list1;
		} else {
			list2.right = sortedMerge(list1, list2.right);
			headNode = list2;
		}
		return headNode;
	}

}

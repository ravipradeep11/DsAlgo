package com.ds.linkedList;

import com.ds.trees.TreeNode;

public abstract class LinkedList {
	public TreeNode head;
	public LinkedList() {
		// TODO Auto-generated constructor stub
		System.out.println("Creating Linked List");
	head=null;
	}
public abstract void insert(Comparable data);
public void display()
{
TreeNode temp=head;
System.out.println();
while(temp!=null)
{
System.out.print(" ->"+temp.data);
temp=temp.right;
}
}


}

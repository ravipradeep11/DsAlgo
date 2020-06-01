package com.test.linkedList;

import trees.Tnode;

public abstract class LinkedList {
	public Tnode head;
	public LinkedList() {
		// TODO Auto-generated constructor stub
		System.out.println("Creating Linked List");
	head=null;
	}
public abstract void insert(Comparable data);
public void display()
{
Tnode temp=head;
System.out.println();
while(temp!=null)
{
System.out.print(" ->"+temp.data);
temp=temp.right;
}
}


}

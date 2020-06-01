package com.test.linkedList;

public class MainExtension {

	
	public static void main(String[]args)
	{
		
		int[] arr=new int[]{1,2,3,4,5,6,7,8,9,10};
		//arr=new int[]{9,2,1,6,10,5,3,2,1,4};
		LinkedListAmazon list=new LinkedListAmazon();
		for (int i = 0; i < arr.length; i++) {
			list.insert(arr[i]);
		}
		list.display();
		list.mergeSort();
		list.display();
		list.reverseRecursive();
		list.display();
		list.reverseIterative();
		list.display();
		//list.reverseKNodes(11);
		list.display();
		
		list.reverseEveryKNodes(1);
		list.display();
		list.reverseAlternateKNodes(2);
		list.display();
		
		
	}
}

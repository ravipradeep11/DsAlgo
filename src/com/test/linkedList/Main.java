package com.test.linkedList;

import trees.ArrayUtil;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] A=ArrayUtil.generate1DIntegerArray(0, 20, 4);
        A=new int[]{1,2,3,4,5,6,7};
        SinglyLinkedList sL=new SinglyLinkedList();
        SinglyLinkedList list=new SinglyLinkedList();
        int []b=new int[]{3,2,6,1,88,34,3};
        for (int i = 0; i < A.length; i++) {
			sL.insert(A[i]);
		}
        for (int i = 0; i < b.length; i++) {
			list.insert(b[i]);
		}
        sL.display();
        sL.reverse();
        sL.display();
        sL.reverseR();
        sL.display();
        sL.reverseKnodes(3);
        sL.display();   sL.reverseKnodes(3);
        sL.display();
        sL.reverseEveryKnodes(2);
        sL.display();
        sL.reverseEveryKnodes(2);
        sL.display();
        //sL.reverseKAlternateNodes(2);;
       // sL.display();
        
       list.mergeSort();
       list.display();
       System.out.println();
       list.addnumbers("99999", "998");
        
	}

}

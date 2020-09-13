package com.ds.rmq;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[]	A=new int[]{1,0,1,2,-1,3,4,0,-2};
	
	RangeMinimumQuery rmq=new RangeMinimumQuery();
	rmq.findMinBetweenIndices1(A, 2, 4);
	}

}

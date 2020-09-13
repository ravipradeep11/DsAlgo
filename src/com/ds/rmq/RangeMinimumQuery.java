package com.ds.rmq;

public class RangeMinimumQuery {

	
	
	//Trivial Solution
	public int findMinBetweenIndices1(int []A,int i,int j)
	{
		
		int [][]M=new int[A.length][A.length];
		process1(M, A, A.length);
		System.out.println("The minimum between indices "+i+" "+j+"is "+A[M[i][j]]);
		return 0;
	}
	private void process1(int [][]M,int []A,int N)
	{
		for (int j2 = 0; j2 < N; j2++) {
			M[j2][j2]=j2;
		}
		for (int j = 0; j< N; j++) {
			for (int i = j+1; i < N; i++) {
				if(A[M[j][i-1]]<A[i])
					M[j][i]=M[j][i-1];
				else
					M[j][i]=i;
			}
			
		}
		
		
	}
	
	
	
	//O(N,sqrt N solution )
	
	public int findMinBetweenIndices2(int []A,int i,int j)
	{
		
		int [][]M=new int[A.length][A.length];
		process1(M, A, A.length);
		System.out.println("The minimum between indices "+i+" "+j+"is "+A[M[i][j]]);
		return 0;
	}
}

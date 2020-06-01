package com.test.array;

public class ArrayUtilAmazon {

	
	public <T extends Comparable<T>> void quickSort(T[] arr,int start,int end){
		
		
	}
	public <T extends Comparable> int partition(T[]arr,int start,int end){
		return 0;
	}
	public static void main(String[]args)
	{
		int[] arr=new int[]{4,6,8,1,7,9};
		arr=new int[]{2,2,2,2,2,2,2};
		ArrayUtilAmazon a=new ArrayUtilAmazon();
	a.mergeSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" "+arr[i]);
		}
	}
	public int[] sortedMerge(int[] arr,int[] brr)
	{
		
		int l=arr.length;
		int r=brr.length;
		int n=l+r;
		int[] res=new int[l+r];
		int i,j,k;
		i=j=k=0;
		while(k<n){
			while(i<l&&j<r&&arr[i]<=brr[j])
			{
				res[k++]=arr[i++];
			}
			while(j<r&&i<l&&brr[j]<=arr[i])
			{
				res[k++]=brr[j++];
			}
			
			
		}
		if(i<l)
		{
			res[k++]=arr[i++];
		}
		if(j<r)
			res[k++]=brr[j++];
		return null;
	}
	public void mergeSort(int[] arr,int low,int high)
	{
		int mid=(low+high)/2;
		if(low==high)
			return ;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		int n=high-low+1;
		int i,j,k;
		i=j=k=0;
		i=low;
		j=mid+1;
		int [] res=new int[high-low+1];
		while(k<n){
			if(i>mid){
				res[k++]=arr[j++];
				
			}
			else if(j>high)
				res[k++]=arr[i++];
			else if(arr[i]<arr[j])
			{
				res[k++]=arr[i++];
			}else
				res[k++]=arr[j++];
		}
		for (int l = 0; l < n; l++) {
			arr[low+l]=res[l];
		}

		
		
		
	}
}

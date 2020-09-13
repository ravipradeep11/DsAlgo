package com.ds.stringmanipulation;

public class TopKWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String findTopKWords(String[] dict, int k) {

		
		for (int i = 0; i < dict.length; i++) {
			
		}
		return null;

	}
	
	
	public void insertUtil(TrieNode t,MinHeap heap,String word)
	{
		
		char[]str=word.toCharArray();
		int n=str.length;
		TrieNode crawl=t;
		for (int i = 0; i < n; i++) {
			TrieNode tmp;
			int j=getIndex(str[i]);
			if(crawl.childs[j]==null)
			{
				tmp=new TrieNode(str[i]);
				crawl.setChild(j, tmp);
				
				
			}
			if(i==n-1){
				crawl.childs[j].frequency++;
				crawl.childs[j].isWord=true;
			   	heap.insertinMinheap(crawl.childs[j], word);
				
			}
		}
		
	}
	private int getIndex(char c) {

		return c - 'a';
	}
	class MinHeapNode implements Comparable<MinHeapNode>{
		
		String word;
		int frequency;
		TrieNode node;
		public MinHeapNode(String word,int frequency,TrieNode node)
		{
			
			this.frequency=frequency;
			this.node=node;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return word+" "+frequency;
		}

		
		@Override
		public int compareTo(MinHeapNode o) {
			// TODO Auto-generated method stub
			
			return this.frequency-o.frequency;
		}

		
		
	}
	class MinHeap {
			
		
		int FRONT=0;
		int MAXSIZE;
		int CURRENT_INDEX=0;
		MinHeapNode[] heap;
		public MinHeap( int MAXSIZE) {
			// TODO Auto-generated constructor stub
			this.MAXSIZE=MAXSIZE;
			heap=new MinHeapNode[MAXSIZE];
		}
		
		void printElements(){}
		void insertinMinheap(TrieNode node,String word)
		{
			if(node.indexInMinHeap==-1)
			{
				if(CURRENT_INDEX<MAXSIZE)
				{
				node.indexInMinHeap=CURRENT_INDEX;
				
					
					
				}
			}
			if(CURRENT_INDEX>=MAXSIZE)
			{
				//Heap is full
				
				
			}
			
			
		}
		void heapifyBottomUp(int index){
			
			int smallest=index;
			int leftC=getLeft(index);
			int rightC=getRight(index);
			if(leftC<CURRENT_INDEX&&heap[leftC].compareTo(heap[index])<0)
				smallest=leftC;
			if(rightC<CURRENT_INDEX&&heap[rightC].compareTo(heap[index])<0)
				smallest=rightC;
			if(smallest!=index)
			{
				int temp=heap[index].node.indexInMinHeap;
				heap[index].node.indexInMinHeap=heap[smallest].node.indexInMinHeap;
				heap[smallest].node.indexInMinHeap=temp;
				
				swapNodes(index, smallest);
			
				
			}
			
		}
		
		void swapNodes(int i,int j){
			
			MinHeapNode temp=heap[i];
			heap[i]=heap[j];
			heap[j]=temp;
			
			
		}
		int getParent(int i)
		{
			return (i-1)/2;
		}
		int getLeft(int i)
		{
			return 2*i+1;
		}
		int getRight(int i)
		{
			return 2*i+2;
		}
	}

	class Node {

		String word;
		int frequency;

	}

	class Trie {

		TrieNode root = new TrieNode('\0');

		public void insert(String word) {

			char[] str = word.toCharArray();
			TrieNode pCrawl = root, tmp;
			for (int i = 0; i < str.length; i++) {
				if (pCrawl.childs[getIndex(str[i])] == null) {
					tmp = new TrieNode(str[i]);
					pCrawl.setChild(getIndex(str[i]), tmp);

				}
				pCrawl = pCrawl.childs[getIndex(str[i])];
				
					
			}

		}

		private int getIndex(char c) {

			return c - 'a';
		}
	}

	class TrieNode {
		char data;
		TrieNode[] childs = new TrieNode[26];
		boolean isWord = false;
		int indexInMinHeap=-1;
		int frequency=0;

		public TrieNode(char data) {
			this.data = data;

		}

		public void setChild(int c, TrieNode tmp) {
			this.childs[c] = tmp;
		}
	}
}

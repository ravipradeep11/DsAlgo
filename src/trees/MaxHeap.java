package trees;

public class MaxHeap {
	private int CURRENT_INDEX = 0;
	private final int FRONT = 1;
	private int MAXSIZE;
	private int[] heap;

	public MaxHeap(int MAXSIZE) {
		// TODO Auto-generated constructor stub
		this.MAXSIZE = MAXSIZE;
		heap = new int[MAXSIZE + 1];
		heap[0] = Integer.MAX_VALUE;
	}

	public void insert(int data) {
		if (CURRENT_INDEX >= MAXSIZE) {
			System.out.println("Heap is full removing top element");
			removeTop();
			System.out.println("Current maximum is "+peek());
		}
		heap[++CURRENT_INDEX]=data;
		heapifyBottomUp(getParent(CURRENT_INDEX));
	}

	public void removeTop() {
		heap[FRONT] = heap[CURRENT_INDEX--];
		heapifyTopDown(FRONT);

	}
public int peek()
{
	return heap[FRONT];
	}
	private void heapifyBottomUp(int node) {
		int leftC=getLeft(node);
		int rightC=getRight(node);
		int greatest;
		if(leftC<=CURRENT_INDEX&&heap[leftC]>heap[node])
			greatest=leftC;
		else
			greatest=node;
		if(rightC<=CURRENT_INDEX&&heap[rightC]>heap[greatest])
			greatest=rightC;
		if(greatest!=node)
		{
			swap(greatest,node);
			heapifyBottomUp(getParent(node));
		}
	}

	private void heapifyTopDown(int node) {
		int leftC=getLeft(node);
		int rightC=getRight(node);
		int greatest;
		if(leftC<=CURRENT_INDEX&&heap[leftC]>heap[node])
			greatest=leftC;
		else
			greatest=node;
		if(rightC<=CURRENT_INDEX&&heap[rightC]>heap[node])
			greatest=rightC;
		if(greatest!=node)
		{
			swap(greatest,node);
			heapifyTopDown(greatest);
		}
	}

	private int getLeft(int node) {
		return 2 * node;

	}

	private int getRight(int node) {
		return 2 * node + 1;
	}
	private int getParent(int node)
	{
		return node/2;
	}
	private void swap(int node1,int node2)
	{
		int temp=heap[node1];
		heap[node1]=heap[node2];
		heap[node2]=temp;
	}
	public void print()
	{System.out.println();
		for (int i = FRONT; i <=CURRENT_INDEX; i++) {
			System.out.print(" "+heap[i]);
		}
	}
}

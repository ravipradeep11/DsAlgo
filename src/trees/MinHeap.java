package trees;

public class MinHeap {
	private int MAXSIZE = 0;
	private int[] heap;
	private final int FRONT = 1;
	private int CURRENT_INDEX = 0;

	public MinHeap(int size) {
		// TODO Auto-generated constructor stub
		MAXSIZE = size;
		heap = new int[MAXSIZE + 1];
		heap[0] = Integer.MIN_VALUE;

	}

	public void insert(int data) {

		if (CURRENT_INDEX >= MAXSIZE) {
			System.out.println("Heap is full removing top");
			removeTop();
			System.out.println("Now minimum is " + peek());
		}

		heap[++CURRENT_INDEX] = data;
		HeapifyBottomUp(getParent(CURRENT_INDEX));
	}

	public int peek() {
		return heap[FRONT];
	}

	public void removeTop() {
		heap[FRONT] = heap[CURRENT_INDEX--];
		HeapifyTopDown(FRONT);

	}

	private void HeapifyBottomUp(int node) {
		int leftC = getLeft(node);
		int rightC = getRight(node);
		int smallest;

		if (leftC <= CURRENT_INDEX && heap[leftC] < heap[node])
			smallest = leftC;
		else
			smallest = node;
		if (rightC <= CURRENT_INDEX && heap[rightC] < heap[smallest])
			smallest = rightC;
		if (smallest != node) {
			swap(smallest, node);
			HeapifyBottomUp(getParent(node));
		}
	}

	private void HeapifyTopDown(int node) {
		int leftC = getLeft(node);
		int rightC = getRight(node);
		int smallest;
		if (leftC <= CURRENT_INDEX && heap[leftC] < heap[node])
			smallest = leftC;
		else
			smallest = node;
		if (rightC <= CURRENT_INDEX && heap[rightC] < heap[smallest])
			smallest = rightC;
		if (smallest != node) {
			swap(smallest, node);
			HeapifyTopDown(smallest);
		}
	}

	private void swap(int node1, int node2) {
		int temp = heap[node1];
		heap[node1] = heap[node2];
		heap[node2] = temp;

	}

	private int getLeft(int node) {
		return 2 * node;
	}

	private int getRight(int node) {
		return 2 * node + 1;
	}

	private int getParent(int node) {
		return node / 2;
	}

	public void print() {
		System.out.println();
		for (int i = FRONT; i <= CURRENT_INDEX; i++) {
			System.out.print(" " + heap[i]);
		}
	}
}

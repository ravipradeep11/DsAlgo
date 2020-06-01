package com.test.contest;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullBinaryTree {
	private int N;
	private String[] inputEdges;
	private Map<Integer, Node> map;
	private Map<String, Integer> rootCountMap = new HashMap<String, Integer>();
	public FullBinaryTree(int N, String[] edges) {
		this.N = N;
		this.inputEdges = edges;

	}

	private void initNodeMap(){
		map = new HashMap<Integer, FullBinaryTree.Node>();
		for(int i =1; i <=N; i++){
			map.put(i, new Node(i));
		}
		for(String edge: inputEdges){
			String[] nodes = edge.split(" ");
			int node1Data = Integer.parseInt(nodes[0]);
			int node2Data = Integer.parseInt(nodes[1]);
			Node node1 = map.get(node1Data);
			Node node2 = map.get(node2Data);
			node1.addEdge(node2);
			node2.addEdge(node1);
		}
	}

	public int getNodestoDelete(){
		initNodeMap();
		updateLevelNodes(1);

		for(Node node: map.values()){
			updateCountAssumingRoot(node);
		}
		return N-getMaxRootCountValue();
	}

	private int updateCountAssumingRoot(Node node){
		if(node.getfBTreeRootNodeCount() != 0){
			return node.getfBTreeRootNodeCount();
		}
		if(node.getEdges().size() == 1){
			rootCountMap.put(node.data+","+node.getEdges().get(0).data+",0", 1);
			return 1;
		}
		int height= 1;
		List<Node> edges = node.getEdges();
		for(int i =0; i < edges.size(); i++){
			for(int j=i+1; j < edges.size(); j++){
				Node leftNode = edges.get(i);
				Node rightNode = edges.get(j);
				leftNode.getEdges().remove(node);
				rightNode.getEdges().remove(node);
				String key = node.data+","+leftNode.data+","+rightNode.data;
				int tempHeight =0;
				if(rootCountMap.get(key) != null){
					tempHeight = rootCountMap.get(key);
				}
				else{
					int leftHeight = updateCountAssumingRoot(leftNode);
					int rightHeight = updateCountAssumingRoot(rightNode);
					tempHeight = leftHeight+ rightHeight+1;
					rootCountMap.put(key, (tempHeight));
				}

				if(tempHeight > height){
					height = tempHeight;
				}
			leftNode.addEdge(node);
				rightNode.addEdge(node);
			}
		}
		return height;
	}

	private int getMaxRootCountValue(){
		int maxValue = 0;
		for(Integer height: rootCountMap.values()){
			if(maxValue < height){
				maxValue = height;
			}
		}
		return maxValue;
	}

	private void updateLevelNodes(int level){
		for(Node node: map.values()){
			if(node.getEdges().size() == level){
				node.setfBTreeRootNodeCount(1);
				rootCountMap.put(node.data+","+node.getEdges().get(0).data+",", 1);
			}
		}
	}
	public static void main(String[] argv) {
		try {
			long startTime = System.currentTimeMillis();
			Reader reader = new FileReader("small.in");
			BufferedReader bufReader = new BufferedReader(reader);
			String x = bufReader.readLine();
			int numOfTestCases = Integer.parseInt(x);
			int count = 0;

			File file = new File("small.out");
			FileWriter writer = new FileWriter(file);
			for(count =1; count<= numOfTestCases; count++) {
				int N = Integer.parseInt(bufReader.readLine());
				String[] edges = new String[N-1];
				for(int i=0; i < N-1; i++){
					edges[i] = bufReader.readLine();
				}
				FullBinaryTree fBTree = new FullBinaryTree(N, edges);

				String out = ""+fBTree.getNodestoDelete();
				writer.write("Case #" + count + ": "+out+"\n");
				System.out.println("Case #" + count + ":"+out);
			}
			writer.close();
			System.out.println("Total time = " + (System.currentTimeMillis() - startTime));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class Node {
		private int data;
		private List<Node> edges = new ArrayList<FullBinaryTree.Node>();
		private int fBTreeRootNodeCount = 0;

		public int getfBTreeRootNodeCount() {
			return fBTreeRootNodeCount;
		}

		public void setfBTreeRootNodeCount(int fBTreeRootNodeCount) {
			this.fBTreeRootNodeCount = fBTreeRootNodeCount;
		}

		Node(int data){
			this.data = data;
		}

		public void addEdge(Node node){
			edges.add(node);
		}

		public List<Node> getEdges(){
			return edges;
		}
	}
}
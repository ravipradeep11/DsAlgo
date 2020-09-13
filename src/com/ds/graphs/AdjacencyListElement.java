package com.ds.graphs;

public class AdjacencyListElement {

	public int target;
	public int weight;
	
	
	public AdjacencyListElement(int target,int weight) {
		// TODO Auto-generated constructor stub
		this.target=target;
		this.weight=weight;
	}


	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+target+","+weight+")";
	}
	

	
	
}

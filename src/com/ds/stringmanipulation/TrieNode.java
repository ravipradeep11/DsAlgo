package com.ds.stringmanipulation;

public class TrieNode {
	 
	  public char value;
	  boolean word = false;
	  TrieNode[] next = new TrieNode[256];
	  private int nextLength = 0;
	 
	  public TrieNode(char c) {
	    value = c;
	  }
	 
	  void setChild(char c, TrieNode node){
	    next[c]=node;
	    nextLength++;
	  }
	  void clearNext() {
	    next = new TrieNode[256];
	    nextLength = 0;
	  }
	 
	 public boolean nextIsEmpty(){
	    return nextLength == 0;
	  }
	 
	  int nextSize(){
	    return nextLength;
	  }
	}
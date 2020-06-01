package com.test.stringmanipulation;

/***************************************************************************
 * Author: Isai Damier
 * Title: Trie.java
 * Project: geekviewpoint
 * Package: datastructure
 *
 * Description:
 *  A trie is a tree data-structure that stores words by compressing common
 *  prefixes. To illustrate, following is a word list and its resulting trie.
 *
 *   WORDS: rat, rats, rattle, rate, rates, rating, can, cane,
 *          canny, cant, cans, cat, cats, cattle, cattles.
 *
 *   TRIE:
 *         ___________|____________
 *        |                        |
 *        r                        c
 *        a                ________a___________
 *        t~              |                    |
 *    ____|_____          n~                   t~
 *   |   |  |   |    _____|_____        _______|______
 *   s~  t  e~  i   |   |   |   |      |              t
 *       l  s~  n   e~  n   t~  s~     s~             l
 *       e~     g~      y~                            e~
 *                                                    s~
 *
 *   Each ~ in the figure indicates where a prefix is a word.
 *
 *   Generally, a trie has all the benefits of a hash table without
 *   any of the disadvantages.
 *
 *   --------------------------------------------------------------
 *          | HASH TABLE | TRIE     | explanations
 *   --------------------------------------------------------------
 *   Memory |    O(n)    |  < O(n)  | trie uses prefix compression.
 *          |            |          | Hence it does not store each
 *          |            |          | word explicitly
 *  ----------------------------------------------------------------
 *   Search |   O(1)     |  O(1)    | trie is technically faster.
 *          |            | pseudo-  | Given a word, computing a
 *          |            | constant | hash takes at least as long
 *          |            |          | as traversing a trie. Plus,
 *          |            |          | trie has no collision.
 *  ----------------------------------------------------------------
 *
 *  Tries are particularly superior to hash tables when it comes to solving
 *  problems such as word puzzles like boggle. In such puzzles the objective
 *  is to find how many words in a given list are valid. So if for example
 *  at a particular instance in boggle you have a list of one billion words
 *  all starting with zh-, whereas the dictionary has no words starting with
 *  zh-; then: if the dictionary is a hash table, you must compute the entire
 *  hashcode for each word and do one billion look-ups; if on the other hand
 *  the dictionary is a trie, you only do the equivalent of partially
 *  computing one hashcode! That's a saving of over one billion fold!
 *
 *  This implementations of trie uses an array to store the children
 *  nodes, where the numerical value of each char serves as index.
 **************************************************************************/

 
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
 
public class Trie {
  //the root only serves to anchor the trie.
 
  private TrieNode root;
 
  public Trie() {
    root = new TrieNode('\0');
  }//constructor
 
  /******************************************************************
   * Function: addWord
   * @param word
   * @return boolean
   *
   * Description: Insert the given word into the trie. If the word
   *   already exists, return false; else return true.
   *
   * Technical Details: A word is added to a trie one letter at a time.
   *
   *    0] Start with the root of the trie as the current node n.
   *    1] for each character c
   *    2]    if c is not among the children of n
   *    3]       add c to the children of n
   *    4]    set n to the node representing c.
   *    5] At this point, n represent the last char in the word,
   *       so if n is marked return false since word already exists
   *       else mark n as word and return true.
   ****************************************************************/
  public boolean addWord(String word) {
    TrieNode n = root, tmp;
    for (char c : word.toCharArray()) {
      tmp = n.next[c];
      if (tmp == null) {
        tmp = new TrieNode(c);
        n.setChild(c, tmp);
      }
      n = tmp;
    }
    if (n.word) {
      return !n.word;
    }
    n.word = true;
    return n.word;
  }//addWord
  
  public boolean isWord(String word) {
	    TrieNode n = root;
	    for (char c : word.toCharArray()) {
	      n = n.next[c];
	      if (null == n) {
	        return false;
	      }
	    }
	    return n.word;
	  }//isWord
  
  public boolean removeWord(String word) {
	    Stack<TrieNode> stack = new Stack<TrieNode>();
	    TrieNode n = root;
	    stack.add(n);
	    for (char c : word.toCharArray()) {
	      n = n.next[c];
	      if (null == n)//word not found
	      {
	        return false;
	      }
	      stack.add(n);
	    }
	    if (!n.word)//word not found
	    {
	      return false;
	    }
	    n.word = false;
	    if (!n.nextIsEmpty())//word is a prefix
	    {
	      return true;
	    }
	 
	    //word is not a prefix
	    stack.pop();
	    n = stack.pop();
	    while (!stack.isEmpty() && n.nextSize() == 1) {
	      n.clearNext();
	      if (n.word) {
	        return true;
	      }
	      n = stack.pop();
	    }
	    return true;
	  }//remove
  
  public boolean isPrefix(String word) {
	    TrieNode n = root;
	    for (char c : word.toCharArray()) {
	      n = n.next[c];
	      if (null == n) {
	        return false;
	      }
	    }
	    return !n.nextIsEmpty();
	  }//isPrefix
}
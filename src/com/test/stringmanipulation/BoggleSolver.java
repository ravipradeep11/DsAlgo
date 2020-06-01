package com.test.stringmanipulation;



import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
public class BoggleSolver {
 
  /*********************************************************************
   * Function: solver
   * @param
   *     char[][] board: the boggle board, each entry represents
   *       a lettered tile.
   *     boolean[][] tracker: a bit table used to track whether a
   *       letter has already been used.
   *     Trie lexicon: the dictionary to validate words.
   *     String word: the word to look up. If the word is valid, then
   *       add it to the result set; if it's a prefix, use it to
   *       form other words.
   *     int x: horizontal coordinate of the letter being considered.
   *     int y: vertical coordinate of the letter to being considered.
   *     Set<String> result: the list of valid words.
   * @return
   *
   * Description: This function recursively forms words by adding one
   *   letter at a time to a given prefix/word.
   *
   *   0] If the given word/prefix is a valid dictionary word,
   *      add it to the result set.
   *   1] If the given word/prefix is not a valid prefix,
   *      then return: abort elongating that sequence.
   *   3] Make a deep copy of the tracker and call it tmp.
   *   4] In tmp, the child tracker, set the coordinate of
   *      the present letter to true, to mark it as been used.
   *   2] For each letter L adjacent to the letter at x,y:
   *      recursively call solver (this function) on word+L.
   *      For example if word="rat" and L="s" then word+L="rats".
   *      A letter is adjacent to x,y if it is located at any of
   *      the following locations: (x-1,y-1); (x,y-1); (x+1,y-1);
   *      (x+1,y); (x+1,y+1); (x,y+1); (x-1,y+1); (x-1,y).
   ********************************************************************/
	
	private void solver(
          char[][] board,
          boolean[][] tracker,
          Trie lexicon,
          String word,
          int x, int y,
          Set<String> result)
  {
 
    if (lexicon.isWord(word)) { result.add(word); }
 
    if (!lexicon.isPrefix(word)) { return; }
 
    boolean[][] tmp = deepCopy(tracker);
    tmp[x][y] = true;
 
    //upper left
    if (0 <= x - 1 && 0 <= y - 1 && !tmp[x - 1][y - 1]){
      solver(board,tmp,lexicon, word+board[x-1][y-1], x-1, y-1, result);
    }
 
    //up
    if (0 <= y - 1 && !tmp[x][y - 1]){
      solver(board, tmp, lexicon, word + board[x][y-1], x, y-1, result);
    }
 
    //upper right
    if (x + 1 < board.length && 0 <= y - 1 && !tmp[x + 1][y - 1]){
      solver(board,tmp,lexicon, word+board[x+1][y-1], x+1, y-1, result);
    }
 
    //right
    if (x + 1 < board.length && !tmp[x + 1][y]){
      solver(board, tmp, lexicon, word + board[x+1][y], x+1, y, result);
    }
 
    //lower right
    if (x+1 < board.length && y+1 < board[0].length && !tmp[x+1][y+1]){
      solver(board,tmp,lexicon, word+board[x+1][y+1], x+1, y+1, result);
    }
 
    //down
    if (y + 1 < board[0].length && !tmp[x][y + 1]){
      solver(board, tmp, lexicon, word + board[x][y+1], x, y+1, result);
    }
 
    //lower left
    if (0 <= x - 1 && y + 1 < board[0].length && !tmp[x - 1][y + 1]){
      solver(board,tmp,lexicon, word+board[x-1][y+1], x-1, y+1, result);
    }
 
    //left
    if (0 <= x - 1 && !tmp[x - 1][y]){
      solver(board, tmp, lexicon, word + board[x-1][y], x-1, y, result);
    }
  }
	public Set<String> solver(List<String> dictionary, char[][] board) {
	    Trie lexicon = new Trie();
	    for (String word : dictionary) {
	      lexicon.addWord(word);
	    }
	    Set<String> result = new HashSet<String>();
	    for (int i = 0; i < board.length; i++) {
	      for (int j = 0; j < board[0].length; j++) {
	        boolean tracker[][] = new boolean[board.length][board[0].length];
	        solver(board, tracker, lexicon, board[i][j] + "", i, j, result);
	      }
	    }
	    return result;
	  }//solver
	private boolean[][] deepCopy(boolean[][] A) {
	    boolean[][] B = new boolean[A.length][A[0].length];
	    for (int x = 0; x < A.length; x++) {
	      for (int y = 0; y < A[0].length; y++) {
	        if (A[x][y])//write only when necessary
	        {
	          B[x][y] = A[x][y];
	        }
	      }
	    }
	    return B;
	  }
}
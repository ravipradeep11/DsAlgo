package com.ds.stringmanipulation;

import com.ds.trees.TreeNode;

public class StringTestAmazon {

	public void findPatternKMP(String text, String pat) {
		int m, n;
		m = pat.length();
		n = text.length();
		int[] lps = new int[m];
		getPreprocessedArray(pat.toCharArray(), m, lps);
		findPatternKMPUtil(text.toCharArray(), pat.toCharArray(), n, m, lps);

	}

	private void findPatternKMPUtil(char[] text, char[] pat, int n, int m,
			int[] lps) {
		int i=0;
		int j=0;
		while(i<n){
			while(i<n&&j<m)
			{
				if(text[i]==pat[j])
				{
					i++;j++;
				}
				if(j==m)
				{
					System.out
					.println("Pattern " + 
							" found at position" + (i - j)
							+ "in text");
					j=lps[j-1];
				}
				if(i<n&&text[i]!=pat[j])
				{
					if(j!=0)
					{
						j=lps[j-1];
					}else
						i++;
				}
			}
			
		}
		

	}

	private void getPreprocessedArray(char[] pat, int n, int[] lps) {

		lps[0] = 0;
		int i = 1;
		int len = 0;
		while (i < n) {
			if (pat[i] == pat[len]) {
				lps[i] = len + 1;
				len++;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}

			}
		}

	}

	public void printAllInterpretations(int[] arr) {
		TreeNode root = new TreeNode(" ");
		int n = arr.length;
		root = constructTree(arr, -1, n - 1, " ");

		printAllLeafs(root);
	}

	private TreeNode constructTree(int[] arr, int start, int end, String data) {

		TreeNode node = new TreeNode(data);
		int diff = end - start;
		if (start == end)
			return node;
		if (start + 1 <= end)
			node.left = constructTree(arr, start + 1, end, data
					+ getString(arr[start + 1]));

		if (start + 2 <= end && 10 * arr[start + 1] + arr[start + 2] < 27)
			node.right = constructTree(arr, start + 2, end, data
					+ getString(10 * arr[start + 1] + arr[start + 2]));
		return node;
	}

	private String getString(int i) {
		return Character.toString((char) ('a' + i - 1));
	}

	private void printAllLeafs(TreeNode node) {
		if (node == null)
			return;
		if (node.isLeafNode()) {
			System.out.println(node.data);
			return;
		}
		printAllLeafs(node.left);
		printAllLeafs(node.right);
	}

}

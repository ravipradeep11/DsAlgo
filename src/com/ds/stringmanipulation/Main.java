package com.ds.stringmanipulation;

public class Main {

	
	public static void main(String[] args)
	{
		PatternMatching p=new PatternMatching();
		//p.findMatchesUsingKMP("AABA", "AABAACAADAABAAABAA");

		char[] str="abcd".toCharArray();
		
		for (int i = 0; i < str.length; i++) {
			int j=-1/2;
			System.out.println(" c at "+i+" is "+str[i]+""+j);
		}
//System.out.println(" "+p.getlongestCommonSubSeq("axbyqz", "zbxayzp" ));
//System.out.println(" "+p.getlongestCommonSubSeq("AGGTAB", "GXTXAYB" ));
	}
}

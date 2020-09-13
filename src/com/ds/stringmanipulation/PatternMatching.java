package com.ds.stringmanipulation;

public class PatternMatching {
public static final String goLeft="<-";
public static final String abort="N";
public static final String goDiag="\\";
public static final String goUp="|";
	public static void findMatchesUsingKMP(String pattern, String text) {
		int t, p;
		t = text.length();
		p = pattern.length();
		int i, j;
		i = j = 0;
		int[] lps = new int[p];
		lps = preProcesForKMP(pattern);
		while (i < t) {
			while (j < p&&i<t) {
				System.out.println("i is"+i+" j is "+j);
				if (pattern.charAt(j) == text.charAt(i)) {
					i++;
					j++;
				}
				if (j == p) {
					System.out
							.println("Pattern " + pattern
									+ " found at position" + (i - j)
									+ "in text" + text);
					j = lps[j - 1];
				}

				else if (j < p&&i<t&&pattern.charAt(j) != text.charAt(i)) {
					if (j != 0) {
						j = lps[j - 1];
					}else
						i++;

				}
			}

		}

	}

	private static int[] preProcesForKMP(String pattern) {
		int l, len, k;
		int n;
		n = pattern.length();
		int[] lps = new int[n];
		lps[0] = 0;
		len = 0;
		int i = 1;
		while (i < n) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
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

		return lps;
	}

public int getlongestCommonSubSeq(String str1,String str2)
{

String[][]dir=new String[str1.length()+1][str2.length()+1];
int m=str1.length();
int n=str2.length();
for (int i = 0; i < str1.length()+1; i++) {
	for (int j = 0; j < str2.length()+1; j++) {
		dir[i][j]=abort;
	}
	System.out.println();
}
int result=lcsLength(str1, str2, str1.length(), str2.length(),dir);

System.out.println();
for (int i = 0; i < str1.length()+1; i++) {
	for (int j = 0; j < str2.length()+1; j++) {
		System.out.print(" "+dir[i][j]);
	}
	System.out.println();
}
boolean done=false;
System.out.println("Printing LCS");
while(!done)
{
	if(!dir[m][n].equals(abort))
			{
		if(dir[m][n].equals(goDiag))
		{
			System.out.println(" "+str1.charAt(m-1));
			m--;n--;
		}else if(dir[m][n].equals(goUp))
		{
			m--;
		}else if(dir[m][n].equals(goLeft))
		{
			n--;
		}
			
			}else 
				done=true;
}
return result;
}
private int lcsLength(String x,String y,int m,int n,String[][]dir)
{
	if(x==null||y==null||m==0||n==0)
	{
		dir[m][n]=abort;
		return 0;
	}
	if(x.charAt(m-1)==y.charAt(n-1))
	{
		dir[m][n]=goDiag;
		return 1+lcsLength(x,y,m-1,n-1,dir);
	}else
	{
		if(lcsLength(x, y, m-1, n,dir)>lcsLength(x, y, m, n-1,dir))
		{
			dir[m][n]=goUp;
		}else
		{
			dir[m][n]=goLeft;
		}
	}
		return max(lcsLength(x, y, m-1, n,dir),lcsLength(x, y, m, n-1,dir));
		
	
}
private int max(int x,int y)
{
if(x>y)
	return x;
else
	return y;
}
}
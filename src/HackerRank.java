import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HackerRank {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		try {
			str = br.readLine();
			int t=Integer.parseInt(str);
			while(t-->0)
			{
				str=br.readLine();
				int num=Integer.parseInt(str);
				System.out.println(""+getDivisor(num));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	static int getDivisor(int num){
		int count=0;
		int digit=0;
		int n=num;
		while(num>0){
			digit=num%10;
			if(digit!=0&&n%digit==0)
				count++;
			num=num/10;
			
		}
		return count;
		
	}

}

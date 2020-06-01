package algo;

public class maim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(" To Aloha is " + toAloha(1234));
	}

	static String toAloha(int n) {
		char[] num = new char[10];

		num = Integer.toString(n).toCharArray();
		for (int i = 0; i < num.length; i++) {
			System.out.println(" char at " + i + " is " + num[i]);
		}
		int d = num.length;
		if (!generateNextAloha(num, 0, num.length - 1)) {

			return generateSmallestAloha(d + 1);
		} else {
			String res = "";
			for (int i = 0; i < num.length; i++) {
				res = res + num[i];

			}
			return res;

		}

	}

	static String generateSmallestAloha(int d) {
		String res = "";
		while (d > 0) {
			res = res + "4";
			d--;
		}
		return res;
	}

	static boolean generateNextAloha(char[] num, int start, int end) {

		if (num[start] > '7')
			return false;

		if (num[start] < '4') {
			while (start <= end) {
				num[start++] = '4';
			}
			return true;
		}

		if (num[start] > '4' && num[start] < '7') {
			num[start++] = '7';
			while (start <= end) {
				num[start++] = '4';
			}
			return true;
		}
		if (num[start] == '4') {
			if (generateNextAloha(num, start + 1, end)) {
				return true;
			} else {
				num[start++] = '7';
				while (start <= end) {
					num[start++] = '4';
				}
				return true;
			}
		}
		if(num[start]=='7')
		{
			if(start==end)
				return false;
			if(generateNextAloha(num, start+1, end))
			{
				return true;
			}else{
				return false;
				
			}
			
			
		}
		
		
		
		

		if (start == end) {
			if (num[start] < '4') {
				num[start] = '4';
				return true;
			}
			if (num[start] <= '7') {
				num[start] = '7';
				return true;
			} else
				return false;
		}

		return false;
	}

}

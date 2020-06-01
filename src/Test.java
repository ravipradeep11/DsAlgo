import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Test {
     public static void main(String[] args) {
        List<Foo> myFooList = new ArrayList<Foo>();
        myFooList.add(new Foo("C"));
        myFooList.add(new Foo("A"));
        myFooList.add(new Foo("D"));
        //Collections.sort(myFooList);
        Collections.sort(myFooList, new Goo());
        for (Iterator iterator = myFooList.iterator(); iterator.hasNext();) {
			Foo foo = (Foo) iterator.next();
			System.out.println(" "+foo.code);
		}
        
        System.out.print(myFooList.get(0).code);
        String stmt = null;
        System.out.print(null+stmt);
        System.out.print(stmt+null);

String str = "String";
StringBuffer strBuf = new StringBuffer(str);
System.out.print(str.equals(strBuf) + "," + strBuf.equals(str));

System.out.println("  "+squareRoot(100d));
    }
    static double squareRoot(double n)
     {
       /*We are using n itself as initial approximation
        This can definitely be improved */
       double x = n;
       double y = 1;
       double e = 0.00000001d; /* e decides the accuracy level*/
       while(x - y > e)
       {
   x = (x + y)/2d;
         y = n/x;
       }
       return x;
     }
    static int squareRoot(int n)
     {
       int x = n;
       int y = 1;
       while(x > y)
       {
         x = (x + y)/2;
         y = n/x;
       }
       return x;
     }
}
class Foo implements Comparable<Foo> {
    String code;
    Foo(String c) {
     code = c;
    }
   public int compareTo(Foo f) {
     return this.code.compareTo(f.code);
   }
}
class Goo implements Comparator<Foo>{

	@Override
	public int compare(Foo o1, Foo o2) {
		// TODO Auto-generated method stub
		return -o1.code.compareTo(o2.code);
	}
	
}
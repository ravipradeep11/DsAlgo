package algo.stock;

public class Main {
    public static void main(String[] args)
    {

    }
    public int maxProfit1(int[] prices){
      int maxProfit=0;
      int minPrice=prices[0];
      int maxPrice=prices[0];
      int n=prices.length;
      int i=1;
      while(i<n){
          int currentProfit=prices[i]-minPrice;

          if(prices[i]<minPrice)
              minPrice=prices[i];
          maxProfit=Math.max(maxProfit,currentProfit);


      }
      return maxProfit;


    }
}

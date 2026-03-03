package third;
import java.util.*;

public class MaximumProfit {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++) {
            prices[i] = s.nextInt();
        }

        int minPrice = Integer.MAX_VALUE;
        int profit = 0, maxProfit = 0;
        for(int price : prices) {
            if(price < minPrice) minPrice = price; //keep updating the min price seen so far
            else profit = price - minPrice; //when current is greater than min price
            maxProfit = Math.max(profit, maxProfit); //keep updating the max profit
        }

        System.out.println(maxProfit);
    }
}

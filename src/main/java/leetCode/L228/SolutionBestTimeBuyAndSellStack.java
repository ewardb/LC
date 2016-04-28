package leetCode.L228;

/**
 * Created by wq on 16-2-26.
 */
public class SolutionBestTimeBuyAndSellStack {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for(int i = 1 ; i<len ; i++){
            if(prices[i] - prices[i-1] <=0){
                continue;
            }
            profit += prices[i] - prices[i-1];
        }
        return profit ;
    }
}
//1 2 2 3 3 2 5 6

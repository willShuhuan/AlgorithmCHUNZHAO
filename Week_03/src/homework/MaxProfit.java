package homework;

/**
 * @author DSH
 * @date 2021/2/7
 * @description #122 买股票的最佳时机
 * 亚马逊 字节跳动 微软
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0,prices[i]-prices[i-1]);
        }
        return profit;
    }
}

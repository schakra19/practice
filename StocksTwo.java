//Program to find maximum profit by buying and selling stocks at most twice
//Runtime - O(n), Space - O(n)
//Programming Paradigm - Dynamic Programming
package practice;

public class StocksTwo {

	private static int stockProfit(int[] prices){
		int[] profit = new int[prices.length];
		int max = prices[prices.length-1];
		for(int i=prices.length-2; i>=0; i--){
			if(prices[i] > max)
				max = prices[i];
			profit[i] = Math.max(profit[i+1], max-prices[i]);
		}
		int min = prices[0];
		for(int i=1; i<prices.length; i++){
			if(prices[i] < min)
				min = prices[i];
			profit[i] = Math.max(profit[i-1], profit[i]+prices[i]-min);
		}
		return profit[prices.length-1];
	}
	public static void main(String[] args) {
		int[] prices = {10,22,5,75,65,80};
		System.out.println("Maximum profit by buying and selling stocks "
				+ "twice is " + stockProfit(prices));	
	}
}

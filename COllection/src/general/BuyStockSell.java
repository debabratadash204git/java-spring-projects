package general;

public class BuyStockSell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] prices = {7, 10, 1, 3, 6, 9, 2,11};
	        System.out.println(maxProfit(prices));

	}

	private static int maxProfit(int[] prices) {

		int n = prices.length;
		int res = 0;
		int min = prices[0];

		for (int i =1 ; i< n ; i++) {

			min = Math.min(min, prices[i]);

			res = Math.max(res, prices[i] - min);

		}

		return res;
	}

}

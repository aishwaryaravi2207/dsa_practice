public class DynamicProgramming {
    public static void main(String args[]){
        int[] coins = {2};
        int amount = 3;
        System.out.println(coinChange(coins,amount));

    }
    /**
     * Leetcode Problem #322: Coin Change
     *
     * This method calculates the minimum number of coins required to make up a given amount.
     * If it's not possible to make up the amount with the provided denominations, it returns -1.
     *
     * Approach:
     * 1. Initialize a DP array of size (amount + 1) where dp[i] represents the minimum coins needed for amount i.
     * 2. Set dp[0] = 0, since 0 coins are needed to make amount 0.
     * 3. For each amount from 1 to the target amount:
     *    - Initialize dp[i] to Integer.MAX_VALUE.
     *    - Iterate through all coin denominations:
     *       a. If coin exactly equals i, set dp[i] = 1 and break (as it's the optimal case).
     *       b. If coin <= i and dp[i - coin] is not -1, update dp[i] to the minimum of its current value and (1 + dp[i - coin]).
     * 4. If dp[i] remains Integer.MAX_VALUE after checking all coins, set it to -1 (unreachable).
     *
     * Time Complexity: O(amount * coins.length)
     *    - For each amount from 1 to 'amount', we iterate through all coin denominations.
     *
     * Space Complexity: O(amount)
     *    - We use a DP array of size amount + 1.
     *
     * @param coins Array of available coin denominations.
     * @param amount The total amount to make up using the minimum number of coins.
     * @return The minimum number of coins required to make the amount, or -1 if not possible.
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]) {
                    dp[i] = 1;
                    break;
                }
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }

}

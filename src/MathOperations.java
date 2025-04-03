public class MathOperations {
    public static void main(String args[]){
        int n = 5;
        System.out.println(distinctIntegers(n));
    }
    /**
     * Leetcode Problem #2549: Count Distinct Numbers on Board
     *
     * This method calculates the number of distinct integers that result from repeatedly dividing a given integer `n`
     * by all numbers greater than 1, until no further division is possible.
     * The distinct numbers are those that divide `n` and produce a result of 1 after performing the division.
     *
     * Approach:
     * 1. The key observation is that the number of distinct integers is equal to `n-1` if `n > 1` because all numbers
     *    from 1 to `n-1` will divide `n` to eventually reduce to 1.
     * 2. If `n == 1`, there is only one distinct number (1), so the result is 1.
     *
     * Time Complexity: O(1)
     *    - The solution directly returns `Math.max(n-1, 1)`, which is a constant-time operation.
     *
     * Space Complexity: O(1)
     *    - No additional space is used beyond a few integer variables.
     *
     */
    public static int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }
}

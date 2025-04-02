public class ArrayOperations {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        int[] input = {2,4,1,1,6,5};
        System.out.println(runningSum(nums));
        System.out.println(countHillValley(input));
    }
    /**
     * Leetcode Problem #1480: Running Sum of 1D Array
     *
     * This method computes the running sum of a given 1D array.
     *
     * Approach:
     * 1. Iterate through the array starting from the second element.
     * 2. At each index, update the value by adding the previous element's sum.
     *
     * Time Complexity: O(N)
     *    - We traverse the array once, updating each element in-place.
     *
     * Space Complexity: O(1)
     *    - The input array is modified in-place, requiring no extra space.
     *
     * @param nums Input array of integers.
     * @return Modified input array with running sums.
     */
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1]; // Update the current index with cumulative sum
        }
        return nums;
    }
    /**
     * Leetcode Problem #2210: Count Hills and Valleys in an Array
     *
     * This method counts the number of hills and valleys in a given array.
     *
     * Approach:
     * 1. Iterate through the array starting from the second element up to the second-last element.
     * 2. At each index, check if the current element is greater than both neighbors (hill) or smaller than both neighbors (valley).
     * 3. If the current element is equal to its next neighbor, skip further checks and continue iterating.
     * 4. Update the `prev` element only if a hill or valley is found.
     * 5. Return the final count.
     *
     * Time Complexity: O(N)
     *    - We traverse the array once, making constant-time comparisons.
     *
     * Space Complexity: O(1)
     *    - No extra space is used apart from a few integer variables.
     *
     * @param nums Input array of integers.
     * @return The count of hills and valleys in the array.
     */
    public static int countHillValley(int[] nums) {
        int count = 0;
        int prev = nums[0];  // Track the last distinct element
        int cur, nxt;

        for (int i = 1; i < nums.length - 1; i++) {
            cur = nums[i];
            nxt = nums[i + 1];

            // Check if current element is a hill or valley
            if ((cur > prev && cur > nxt) || (cur < prev && cur < nxt)) {
                count++;
            }
            // If consecutive elements are the same, skip further checks
            else if (cur == nxt) {
                continue;
            }

            prev = cur;  // Update prev only if a hill or valley is found
        }

        return count;
    }

}

public class ArrayOperations {
    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        System.out.println(runningSum(nums));
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
}

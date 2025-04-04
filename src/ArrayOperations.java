import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args){
        int[] nums = {2,3,1,3,2,4,6,7,9,2,19};
        int[] input = {2,1,4,3,9,6};
        int[] nums2 = {6,2};
        System.out.println(runningSum(nums));
        System.out.println(countHillValley(input));
        System.out.println(relativeSortArray(nums,input).toString());
        System.out.println(arrayPairSum(nums2));
        System.out.println(sortArrayByParity(nums));
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
    /**
     * Leetcode Problem #1122: Relative Sort Array
     *
     * This method sorts arr1 such that the relative ordering of items in arr1 are the same as in arr2.
     * Elements that do not appear in arr2 are placed at the end of arr1 in ascending order.
     *
     * Approach:
     * 1. Count the occurrences of each element in arr1 using a frequency array.
     * 2. Place elements from arr2 into the result array based on the order in arr2.
     * 3. Place remaining elements that were not in arr2 into the result array in ascending order.
     *
     * Time Complexity: O(N)
     *    - Counting occurrences and placing elements both involve single passes through arr1 and arr2.
     *
     * Space Complexity: O(1)
     *    - The frequency array uses a fixed amount of space (1001 integers), independent of the input size.
     *
     * @param arr1 Input array of integers to be sorted.
     * @param arr2 Array that defines the order of elements to be sorted in arr1.
     * @return The sorted array.
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int maxValue = 1000; // Given the constraint 0 ≤ arr1[i], arr2[i] ≤ 1000
        int[] frequency = new int[maxValue + 1];

        // Count the occurrences of each element in arr1
        for (int num : arr1) {
            frequency[num]++;
        }

        int index = 0;

        // Place elements from arr2 into the result array based on the order in arr2
        for (int num : arr2) {
            while (frequency[num] > 0) {
                arr1[index++] = num;
                frequency[num]--;
            }
        }

        // Place remaining elements that were not in arr2 into the result array in ascending order
        for (int num = 0; num <= maxValue; num++) {
            while (frequency[num] > 0) {
                arr1[index++] = num;
                frequency[num]--;
            }
        }

        return arr1;
    }
    /**
     * Leetcode Problem #561: Array Partition I
     *
     * Given an array of 2n integers, this method forms n pairs such that the sum
     * of the minimum value in each pair is maximized.
     *
     * Approach:
     * 1. Sort the input array in ascending order.
     * 2. Iterate through the array in steps of 2, summing up elements at even indices (which are the smaller elements in each pair).
     *
     * Time Complexity: O(N log N)
     *    - Due to the sorting step.
     *
     * Space Complexity: O(1)
     *    - Sorting is done in-place (assuming the underlying sort implementation is in-place), and only a constant amount of extra space is used.
     *
     * @param nums Input array of 2n integers.
     * @return The maximum sum of the minimum values from n pairs.
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
    /**
     * Leetcode Problem #905: Sort Array By Parity
     *
     * Rearranges the input array so that all even numbers appear before all odd numbers.
     * The relative order of even and odd numbers is not preserved.
     *
     * Approach:
     * 1. Create a result array of the same length as the input array.
     * 2. Use two pointers:
     *    - One (`j`) starting from the beginning to place even numbers.
     *    - One (`k`) starting from the end to place odd numbers.
     * 3. Iterate through the input array:
     *    - If the current element is even, place it at index `j` and increment `j`.
     *    - If the current element is odd, place it at index `k` and decrement `k`.
     *
     * Time Complexity: O(N)
     *    - Single pass through the input array of length N.
     *
     * Space Complexity: O(N)
     *    - Additional array of size N is used to store the result.
     *
     * @param nums Input array of integers.
     * @return A new array with even elements first, followed by odd elements.
     */
    public static int[] sortArrayByParity(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;
        int k = res.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                res[j] = nums[i];
                j++;
            } else {
                res[k] = nums[i];
                k--;
            }
        }
        return res;
    }
}

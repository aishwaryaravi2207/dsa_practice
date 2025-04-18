import java.util.*;

public class TwoPointers {
    public static void main(String args[]){
        int[] nums = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i != 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                List<Integer> temp = new ArrayList<>();
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    int min = nums[j];
                    int max = nums[k];
                    while(min == nums[j] && j < k){
                        j++;
                    }
                    while(max == nums[k] && k > j){
                        k--;
                    }
                } else if (sum > 0) {
                    int max = nums[k];
                    while(max == nums[k] && k > j) {
                        k--;
                    }
                } else {
                    int min = nums[j];
                    while(min == nums[j] && j < k) {
                        j++;
                    }
                }
            }
        }
        return res;
    }
    /**
     * Leetcode Problem #1: Two Sum
     *
     * This method returns the indices of the two numbers in the input array that add up to the target value.
     *
     * Approach:
     * 1. Iterate through the array while maintaining a hashmap of numbers seen so far and their indices.
     * 2. For each number, calculate the difference between the target and the current number.
     * 3. If this difference already exists in the map, return the current index and the index of the difference.
     * 4. Otherwise, store the current number and its index in the map.
     *
     * Time Complexity: O(N)
     *    - The array is traversed once, where N is the number of elements in the array.
     *
     * Space Complexity: O(N)
     *    - In the worst case, all elements are stored in the map.
     *
     * @param nums An array of integers.
     * @param target The target sum to find.
     * @return An array containing the indices of the two numbers that add up to the target.
     *         Returns {-1, -1} if no such pair exists.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1-1};
    }
}

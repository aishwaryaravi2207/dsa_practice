import java.util.*;

public class ArrayOperations {
    public static void main(String[] args){
//        int[] nums = {2,3,1,3,2,4,6,7,9,2,19};
//        int[] input = {2,1,4,3,9,6};
//        int[] nums2 = {6,2};
//        int[] nums3 = {0,1,2,3,4};
//        int[] index = {0,1,2,2,1};
//        int[] num4 = { 40, 30, 20, 10};
//        int[] num5 = {4,5,6,4,4};
//        int[] num6 = {4,3,2,1};
//        int[] num7 = {6,8,4,5,5,7,3};
//        int[] num8 = {46,49,46,47,48,45,44};
//        int[][] mum9 = {{1950,1961},{1960,1971},{1970,1981}};
//        int[] num10 = {-1,1,-6,4,5,-6,1,4,1};
//        int[] num11 = {2,2,2,3,1,1};
//        int[] nums12 = {4,4,2,4,3};
//        System.out.println(unequalTriplets_advanced(nums12));
//        System.out.println(frequencySort_advanced(num11));
//        System.out.println(maximumPopulation(mum9));
//        System.out.println(frequencySort(num10));
//        System.out.println(minimumOperations(num5));
//        for(int temp : createTargetArray(nums3,index)){
//            System.out.println(temp);
//        }
//        System.out.println(runningSum(nums));
//        System.out.println(countHillValley(input));
//        System.out.println(relativeSortArray(nums,input).toString());
//        System.out.println(arrayPairSum(nums2));
//        System.out.println(sortArrayByParity(nums));
//        System.out.println(sortArrayByParityII(num11));
//        System.out.println(repeatedNTimes(nums));
//        System.out.println(arrayRankTransform(num4));
//        System.out.println(transformArray(num6));
//        System.out.println(addedInteger(num7,num8));
//        int[] num13 = {3,5,12,-1,-3,-5};
//        String[] temp = {"jump","add","add","jump","jump","jump"};
//        System.out.println(calculateScore(temp,num13));
        String s = "acb";
        String t = "aebdc";
        System.out.println(isSubsequence(s,t));
        int[] nums = {0,1,2,6,8,9};
        System.out.println(summaryRanges(nums));

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
    /**
     * Leetcode Problem #922: Sort Array By Parity II
     *
     * Rearranges the input array such that elements at even indices are even,
     * and elements at odd indices are odd.
     *
     * Approach:
     * 1. Initialize a result array of the same length as the input.
     * 2. Use two pointers:
     *    - `i` starts at index 0 to place even numbers.
     *    - `j` starts at index 1 to place odd numbers.
     * 3. Iterate through each element in the input array:
     *    - If the element is even, place it at index `i` and increment `i` by 2.
     *    - If the element is odd, place it at index `j` and increment `j` by 2.
     *
     * Time Complexity: O(N)
     *    - Each element is visited once, where N is the length of the array.
     *
     * Space Complexity: O(N)
     *    - An additional array of size N is used for the result.
     *
     * @param nums Input array of integers (with equal number of even and odd elements).
     * @return A new array where even numbers occupy even indices and odd numbers occupy odd indices.
     */
    public static int[] sortArrayByParityII(int[] nums) {
        int i = 0;
        int j = 1;
        int[] res = new int[nums.length];
        for(int k = 0; k < nums.length; k++){
            if(nums[k] % 2 == 0){
                res[i] = nums[k];
                i += 2;
                continue;
            }
            res[j] = nums[k];
            j += 2;
        }
        return res;
    }
    /**
     * Leetcode Problem #1389: Create Target Array in the Given Order
     *
     * Problem Description:
     * Given two arrays, `nums` and `index`, insert each element from `nums` into a new array at the position
     * specified by the corresponding element in `index`. If an index position is already occupied,
     * shift existing elements one position to the right to make space.
     *
     * Approach:
     * 1. Use a HashMap to track if an index has already been used.
     * 2. Iterate through the `index` array:
     *    a. If the current index is not present in the map, mark it as used.
     *    b. If the index already exists:
     *       - Iterate from the beginning of the `index` array up to the current position.
     *       - For each earlier index greater than or equal to the current one, increment it by 1
     *         to simulate shifting elements to the right.
     * 3. Construct the final result array by placing elements from `nums` at the updated indices.
     *
     * Time Complexity: O(N^2)
     *    - For every duplicate index, the loop may shift multiple earlier entries.
     *
     * Space Complexity: O(N)
     *    - A HashMap is used to track used indices, and an array of size N is created for the result.
     *
     * @param nums  Input array of integers to insert.
     * @param index Array representing the target indices for insertion.
     * @return      An array representing the final ordering after all insertions.
     */

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0; i < index.length; i++){
            if(!map.containsKey(index[i])){
                map.put(index[i],true);
            }
            else{
                for(int j = 0; j < i; j++){
                    if(index[j] >= index[i]){
                        map.put(++index[j],true);
                    }
                }
            }
        }
        for(int k : index){
            res[index[k]] = nums[k];
        }
        return res;
    }
    /**
     * Leetcode Problem #961: N-Repeated Element in Size 2N Array
     *
     * Problem Description:
     * Given an array `nums` of size 2N, where there are N+1 unique elements and one of these elements is repeated N times,
     * return the element that is repeated N times.
     *
     * Approach:
     * 1. Create an integer array `res` of size 10000 to count occurrences of each element (assuming input range is within 0–9999).
     * 2. Iterate through `nums`, incrementing the count at index `nums[i]`.
     * 3. Iterate through `nums` again and return the element whose count equals `N`.
     * 4. Return -1 only if no such element is found (though this should not happen based on problem constraints).
     *
     * Time Complexity: O(N)
     *    - Single pass through the input array to count occurrences.
     *    - Another pass through the input array to find the repeated element.
     *
     * Space Complexity: O(1)
     *    - Fixed-size auxiliary array used for counting (10000 elements), independent of input size.
     *
     * @param nums Input array of integers of size 2N.
     * @return     The element that is repeated N times.
     */
    public static int repeatedNTimes(int[] nums) {
        int[] res = new int[10000];
        int len = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;
        }
        for (int j : res) {
            if (j == len) {
                return j;
            }
        }
        return -1;
    }
    /**
     * Leetcode Problem #1331: Rank Transform of an Array
     *
     * Problem Description:
     * Given an array of integers, transform the array such that each element is replaced by its rank.
     * The rank represents the relative size of the element among all elements in the array,
     * where the smallest element has rank 1. Equal elements receive the same rank.
     *
     * Approach:
     * 1. Make a copy of the input array and sort it.
     * 2. Use a HashMap to assign ranks to each unique element in the sorted array.
     *    - If an element is already assigned a rank, skip it.
     *    - Otherwise, assign it the next available rank.
     * 3. Iterate over the original array and replace each element with its corresponding rank from the map.
     *
     * Time Complexity: O(N log N)
     *    - Sorting the array takes O(N log N)
     *    - Creating the rank map and transforming the original array both take O(N)
     *
     * Space Complexity: O(N)
     *    - Extra space is used for the sorted copy of the array and the rank map
     *
     * @param arr Input array of integers
     * @return    Transformed array with ranks
     */
    public static int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Map<Integer,Integer> store = new HashMap<>();
        Arrays.sort(copy);
        int counter = 1;
        for(int i = 0; i < copy.length; i++){
            if(!store.containsKey(copy[i])){
                store.put(copy[i],counter);
                counter++;
            }
        }
        for(int j = 0; j < arr.length; j++){
            arr[j] = store.get(arr[j]);
        }
        return arr;
    }
    /**
     * Leetcode Problem #3396: Minimum Number of Operations to Make Elements in Array Distinct
     *
     * Problem Description:
     * Given an integer array, determine the minimum number of operations required
     * to make all elements distinct. In each operation, you can remove the first
     * three elements from the array.
     *
     * The goal is to find the earliest point in reverse traversal where a duplicate is found,
     * and compute how many "removal operations" (each removing three elements from the start)
     * would be needed to eliminate the duplicate.
     *
     * Approach:
     * 1. Use a HashMap to track the occurrence of elements.
     * 2. Iterate over the array in reverse (from the last element to the first).
     * 3. If the current element is not already in the map, add it.
     * 4. If a duplicate is found:
     *    - Compute its position from the beginning (`i + 1`)
     *    - Calculate the minimum number of operations required to remove it,
     *      using `Math.ceil((i + 1) / 3.0)`
     * 5. Return the computed number of operations.
     * 6. If no duplicates are found, return 0.
     *
     * Time Complexity: O(N)
     *    - Single pass through the array.
     *
     * Space Complexity: O(N)
     *    - Space used for the HashMap to store seen elements.
     *
     * @param nums Input array of integers
     * @return     Minimum number of operations needed to make all elements distinct
     */
    public static int minimumOperations(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = nums.length-1; i >= 0; i--){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                double pos = i+1;
                double ops  = Math.ceil((pos) / 3);
                return (int) ops;
            }
        }
        return 0;
    }
    /**
     * Leetcode Problem #1929: Concatenation of Array
     *
     * Problem Description:
     * Given an integer array `nums`, return a new array that is the concatenation of `nums` with itself.
     * For example, if nums = [1, 2, 3], the result should be [1, 2, 3, 1, 2, 3].
     *
     * Approach:
     * 1. Create a new result array of size twice the input array (`2 * nums.length`).
     * 2. Iterate through the input array once.
     *    - For each element at index `i`, place it at both `res[i]` and `res[i + nums.length]` in the result array.
     * 3. Return the result array.
     *
     * Time Complexity: O(N)
     *    - Single pass through the input array of length N.
     *
     * Space Complexity: O(N)
     *    - Extra space used for the result array of size 2N.
     *
     * @param nums Input array of integers
     * @return     New array formed by concatenating the input array with itself
     */
    public static int[] getConcatenation(int[] nums) {
        int j = nums.length;
        int[] res = new int[nums.length*2];
        for(int i = 0; i < res.length; i++){
            res[i] = nums[i];
            res[j] = nums[i];
            j++;
        }
        return res;
    }
    /**
     * Leetcode Problem #3467: Transform Array by Parity
     *
     * Problem Description:
     * Given an integer array `nums`, transform the array such that:
     * - Replace all odd numbers with 0.
     * - Replace all even numbers with 1.
     * After transforming the array, return the sorted version of the transformed array.
     *
     * Approach:
     * 1. Create a new result array of the same size as the input array.
     * 2. Use a single pointer (`i`) to iterate through the input array.
     * 3. For every odd number, set the corresponding index in the result array to 0.
     * 4. For every even number, set the corresponding index in the result array to 1.
     * 5. Return the result array after the transformation.
     * 6. The array will be returned in the same order; sorting is not explicitly done in the logic here.
     *
     * Time Complexity: O(N)
     *    - Single pass through the input array of length N.
     *
     * Space Complexity: O(N)
     *    - Extra space used for the result array, which is the same size as the input array.
     *
     * @param nums Input array of integers
     * @return     Transformed array where odd numbers are replaced by 0 and even numbers by 1
     */
    public static int[] transformArray(int[] nums) {
        int[] res = new int[nums.length];
        int j = nums.length-1;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] % 2 != 0){
                res[j] = 1;
                j--;
            }
        }
        return res;
    }
    /**
     * Leetcode Problem #3131: Find the Integer Added to Array I
     *
     * Problem Description:
     * Given two integer arrays `nums1` and `nums2`, find the constant `x` such that when `x` is added to every element in `nums1`,
     * it results in the corresponding element in `nums2`. In other words, for every element `nums1[i]`, we have:
     * `nums1[i] + x = nums2[i]` for all `i`. The task is to find this constant `x`.
     *
     * Approach:
     * 1. Create a HashMap to store potential values of `x`.
     * 2. In the first loop, iterate through `nums2` and compute `x` by subtracting `nums1[0]` from each element of `nums2`.
     *    - This will give us the candidate values for `x`.
     *    - Store these values in the map with a count of 1 (indicating the first occurrence).
     * 3. In the second loop, for each subsequent element in `nums1` (starting from `nums1[1]`), iterate through `nums2`:
     *    - For each pair `(nums1[i], nums2[j])`, compute the difference `x = nums2[j] - nums1[i]`.
     *    - If the value of `x` already exists in the map and its count matches the current index `i`, increment its count in the map.
     * 4. After both loops, iterate through the map and find the entry where the value equals `nums1.length`, which corresponds to the correct `x`.
     * 5. Return the value of `x`. If no valid `x` is found, return `-1`.
     *
     * Time Complexity: O(N^2)
     *    - The algorithm involves two nested loops: the outer loop iterates over `nums1` and the inner loop iterates over `nums2`.
     *    - This results in a time complexity of O(N^2), where `N` is the length of `nums1` and `nums2`.
     *
     * Space Complexity: O(N)
     *    - Space is used for the HashMap, which stores the possible values of `x` and their counts. The size of the map can be at most `N`.
     *
     * @param nums1 Input array of integers (first array).
     * @param nums2 Input array of integers (second array).
     * @return     The constant `x` that is added to every element of `nums1` to obtain `nums2`, or -1 if no such constant exists.
     */
    public static int addedInteger(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int k : nums2) {
            int val = k - nums1[0];
            map.put(val, 1);
        }
        for(int i = 1; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int val = nums2[j] - nums1[i];
                if(map.containsKey(val) && map.get(val) == i){
                    map.put(val,map.get(val) + 1);
                }
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() == nums1.length){
                return entry.getKey();
            }
        }
        return -1;
    }
    /**
     * Leetcode Problem #1854: Maximum Population Year
     *
     * Problem Description:
     * Given a list of birth and death years represented as a 2D array `logs`,
     * where each element contains [birthYear, deathYear), return the earliest year
     * with the maximum population alive.
     *
     * Approach:
     * 1. Create an array `pop` of size 2051 to store the population delta for each year.
     * 2. For each interval [birth, death), increment `pop[birth]` and decrement `pop[death]`
     *    to mark population entry and exit.
     * 3. Initialize `maxPop` with the population in 1950 and set `year` to 1950.
     * 4. Iterate from 1951 to 2050, updating each year’s population as a cumulative sum.
     * 5. While iterating, check if the current year’s population exceeds `maxPop`.
     *    If so, update `maxPop` and `year`.
     * 6. Return the earliest year with the maximum population.
     *
     * Time Complexity: O(N + R)
     *    - O(N) to process the birth-death intervals.
     *    - O(R) where R is the number of years (1950 to 2050) to compute prefix sums.
     *
     * Space Complexity: O(R)
     *    - Uses a fixed-size array `pop` for the range of years (1950–2050).
     *
     * @param logs 2D array where each entry represents a person's birth and death year.
     * @return     The earliest year with the maximum population alive.
     */
    public static int maximumPopulation(int[][] logs) {
        int[] pop = new int[2051];
        for(int i = 0; i < logs.length; i++){
            pop[logs[i][0]]++;
            pop[logs[i][1]]--;
        }
        int max = pop[1950];
        int res = 1950;
        for(int j = 1951; j < 2051; j++){
            pop[j] += pop[j-1];
            if(max < pop[j]){
                max = pop[j];
                res = j;
            }
        }
        return res;
    }

    /**
     * Leetcode Problem #1636: Sort Array by Increasing Frequency
     *
     * Problem Description:
     * Given an integer array `nums`, sort the elements in increasing order of their frequency.
     * If multiple elements have the same frequency, sort them in decreasing order of their value.
     *
     * Approach:
     * 1. Create a result array `res` of the same size as the input array.
     * 2. Use a HashMap to count the frequency of each element in the array.
     * 3. While the result array is not yet filled:
     *    - Find the current minimum frequency among the remaining elements.
     *    - Collect all elements with this minimum frequency into a list.
     *    - Sort this list in descending order (as per problem requirement).
     *    - Add each element in the sorted list to the result array `min` number of times (its frequency),
     *      and remove it from the map to avoid reprocessing.
     *
     * Time Complexity: O(N log N)
     *    - O(N) to count frequencies and fill the result.
     *    - O(N log N) for repeated sorting of frequency groups.
     *
     * Space Complexity: O(N)
     *    - O(N) for the frequency map and temporary lists used in sorting and output.
     *
     * @param nums Input array of integers
     * @return     Array sorted by increasing frequency and decreasing value for ties
     */

    public static int[] frequencySort(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        int counter = 0;
        while(counter < res.length){
            int min = 101;
            List<Integer> pos = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                if(min > entry.getValue()){
                    min = entry.getValue();
                    pos = new ArrayList<>();
                    pos.add(entry.getKey());
                }
                else if(min == entry.getValue()){
                    pos.add(entry.getKey());
                }
            }
            Collections.sort(pos, Collections.reverseOrder());
            for(int j = 0; j < pos.size(); j++){
                int k = min;
                while(k > 0){
                    res[counter] = pos.get(j);
                    counter++;
                    k--;
                }
                map.remove(pos.get(j));
            }
        }
        return res;
    }
    /**
     * Leetcode Problem #1636: Sort Array by Increasing Frequency
     *
     * Problem Description:
     * Given an integer array `nums`, sort the elements in increasing order of their frequency.
     * If multiple elements have the same frequency, sort them in decreasing order of their value.
     *
     * Approach:
     * 1. Create a result array `res` of the same size as the input array.
     * 2. Use a list of lists (`List<List<Integer>>`) where the index represents the frequency,
     *    and each list at that index stores the elements that occur with that frequency.
     * 3. Sort the input array in descending order so that higher values come first when frequencies are equal.
     * 4. Traverse the sorted array in reverse to count the frequency of each distinct number.
     *    - For each number and its count, add it `count` times to the corresponding list based on its frequency.
     * 5. Iterate over the frequency list (from low to high frequency) and fill the result array accordingly.
     *
     * Time Complexity: O(N)
     *    - O(N) to count frequencies and populate the result array.
     *    - Sorting the input array is O(N log N), but all other operations are linear.
     *
     * Space Complexity: O(N)
     *    - O(N) for storing the frequency list and the result array.
     *
     * @param nums Input array of integers
     * @return     Array sorted by increasing frequency and decreasing value for ties
     */
    public static int[] frequencySort_advanced(int[] nums) {
        int[] res = new int[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        while(list.size() < 101){
            list.add(new ArrayList<>());
        }
        Arrays.sort(nums);
        int cur = nums[nums.length-1];
        int count = 1;
        for(int i = nums.length-2; i >= 0; i--){
            if(cur == nums[i]){
                count++;
            }
            else {
                int rep = count;
                while(rep > 0) {
                    list.get(count).add(cur);
                    rep--;
                }
                cur = nums[i];
                count = 1;
            }
        }
        int rep = count;
        while(rep > 0) {
            list.get(count).add(cur);
            rep--;
        }
        int pos = 0;
        for(List<Integer> temp : list) {
            for (int j : temp) {
                res[pos++] = j;
            }
        }
        return res;
    }
    /**
     * Leetcode Problem #1848: Minimum Distance to the Target Element
     *
     * Problem Description:
     * Given an integer array `nums`, a target value, and a starting index,
     * return the minimum distance between the starting index and any index `i`
     * such that `nums[i] == target`. The distance is calculated as `abs(i - start)`.
     *
     * Approach:
     * 1. Iterate through the array.
     * 2. For each index `i` where `nums[i] == target`, compute the absolute
     *    distance from `start`.
     * 3. Track the minimum of these distances using a variable `pos`.
     *
     * Time Complexity: O(N)
     *    - We traverse the entire array once to check for matches with the target.
     *
     * Space Complexity: O(1)
     *    - Only a constant amount of extra space is used to store the result.
     *
     * @param nums   Input array of integers
     * @param target The target value to find in the array
     * @param start  The starting index from which distance is calculated
     * @return       The minimum distance between start and any index with target value
     */
    public static int getMinDistance(int[] nums, int target, int start) {
        int pos = 1001;
        for(int i  = 0; i < nums.length; i++){
            if(nums[i] == target){
                pos = Math.min(pos, Math.abs(i - start));
            }
        }
        return pos;
    }
    /**
     * Leetcode Problem #1848: Minimum Distance to the Target Element
     *
     * Problem Description:
     * Given an integer array `nums`, a target value, and a starting index `start`,
     * return the minimum distance between `start` and any index `i` such that
     * `nums[i] == target`. The distance is calculated as `abs(i - start)`.
     *
     * Approach:
     * - Use a two-pointer technique:
     *   1. Initialize two pointers `i` and `j` at `start`.
     *   2. Expand outward in both directions simultaneously.
     *   3. At each step, check if either `nums[i]` or `nums[j]` equals the target.
     *   4. If found, return the current distance counter as the minimum distance.
     *   5. Continue expanding until the bounds of the array are exceeded.
     *
     * This approach finds the closest occurrence of the target in minimal steps.
     *
     * Time Complexity: O(N)
     *    - In the worst case, we might have to scan the entire array.
     *    - However, in practice, it may return early upon finding the closest target.
     *
     * Space Complexity: O(1)
     *    - Only a constant amount of space is used for pointers and counters.
     *
     * @param nums   Input array of integers
     * @param target The target value to search for in the array
     * @param start  The starting index from which distance is measured
     * @return       The minimum distance to an index where the value equals the target
     */
    public static int getMinDistance_advanced(int[] nums, int target, int start) {
        int i = start, j = start;
        int pos = 1001;
        int counter = 0;
        while(i > -1 || j < nums.length){
            if(i > -1 && nums[i] == target){
                return counter;
            }
            else if(j < nums.length && nums[j] == target){
                return counter;
            }
            counter++;
            i--;
            j++;
        }
        return pos;
    }
    /**
     * Leetcode Problem #2161: Partition Array According to Given Pivot
     *
     * Problem Description:
     * Given an integer array `nums` and a pivot value, rearrange the elements in the array such that:
     * - All elements less than the pivot appear before elements equal to the pivot.
     * - All elements equal to the pivot appear in the middle.
     * - All elements greater than the pivot appear after the pivot elements.
     * The relative order of elements in each group should be preserved.
     *
     * Approach:
     * 1. Initialize a result array `res` of the same length as the input.
     * 2. Use a list `list2` to store elements greater than the pivot.
     * 3. Maintain two counters:
     *    - `equalCount`: to count occurrences of the pivot.
     *    - `pos`: to track the current index in the result array.
     * 4. Iterate through the input array:
     *    - If an element is less than the pivot, insert it into `res` and increment `pos`.
     *    - If it is equal to the pivot, increment `equalCount`.
     *    - If it is greater, add it to `list2`.
     * 5. After the loop, insert the pivot value `equalCount` times into the result array.
     * 6. Append all elements from `list2` to the result array.
     *
     * Time Complexity: O(N)
     *    - One pass to process the array and one pass to fill the result array.
     *
     * Space Complexity: O(N)
     *    - Extra space used for the result array and the list of elements greater than the pivot.
     *
     * @param nums  Input array of integers
     * @param pivot Pivot value to partition around
     * @return      New array with elements partitioned around the pivot
     */
    public static int[] pivotArray(int[] nums, int pivot) {
        int[] res = new int[nums.length];
        List<Integer> list2 = new ArrayList<>();
        int equalCount = 0;
        int pos = 0;
        for(int  i = 0; i < nums.length; i++){
            if(pivot > nums[i]){
                res[pos] = nums[i];
                pos++;
            }
            else if(pivot == nums[i]){
                equalCount++;
            }
            else{
                list2.add(nums[i]);
            }
        }
        while(pos < res.length){
            int pt = 0;
            while(equalCount > 0){
                res[pos] = pivot;
                pos++;
                equalCount--;
            }
            pt = 0;
            while(pt < list2.size()){
                res[pos] = list2.get(pt);
                pt++;
                pos++;
            }
        }
        return res;
    }
    public static int[] pivotArray_advanced(int[] nums, int pivot) {
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] < pivot){
                continue;
            }
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] < pivot && nums[j] < nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    continue;
                }
                //write logic for element greater than and equal to pivot
            }
        }
        return nums;
    }
    /**
     * Leetcode Problem #1534: Count Good Triplets
     *
     * Problem Description:
     * Given an integer array `arr`, and three integers `a`, `b`, and `c`,
     * return the number of good triplets. A triplet (i, j, k) is good if:
     *  - 0 <= i < j < k < arr.length
     *  - |arr[i] - arr[j]| <= a
     *  - |arr[j] - arr[k]| <= b
     *  - |arr[i] - arr[k]| <= c
     *
     * Approach:
     * 1. Use three nested loops to iterate over all possible triplets (i, j, k) such that i < j < k.
     * 2. For each triplet, check if all three absolute difference conditions are satisfied.
     * 3. If they are, increment the count of good triplets.
     * 4. Return the final count.
     *
     * Time Complexity: O(N^3)
     *    - Three nested loops over the array of length N.
     *
     * Space Complexity: O(1)
     *    - Uses a constant amount of extra space for the counter.
     *
     * @param arr Input array of integers
     * @param a   Maximum allowed absolute difference between arr[i] and arr[j]
     * @param b   Maximum allowed absolute difference between arr[j] and arr[k]
     * @param c   Maximum allowed absolute difference between arr[i] and arr[k]
     * @return    The number of good triplets in the array
     */
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i + 1; j < arr.length-1; j++){
                if((Math.abs(arr[i] - arr[j]) > a)){
                    continue;
                }
                for(int k = j + 1; k < arr.length; k++){
                    if((Math.abs(arr[j] - arr[k]) > b)){
                        continue;
                    }
                    if(Math.abs(arr[i] - arr[k]) > c){
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Leetcode Problem #1995: Count Special Quadruplets
     *
     * Problem Description:
     * Given an integer array `nums`, return the number of **special quadruplets** (i, j, k, l)
     * such that:
     *  - 0 <= i < j < k < l < nums.length
     *  - nums[i] + nums[j] + nums[k] == nums[l]
     *
     * Approach:
     * 1. Use four nested loops to iterate over all combinations of indices (i, j, k, l) such that i < j < k < l.
     * 2. For each quadruplet, check if the sum of nums[i], nums[j], and nums[k] equals nums[l].
     * 3. If the condition is met, increment the counter.
     * 4. Return the final count after all combinations are checked.
     *
     * Time Complexity: O(N^4)
     *    - Four nested loops over the array of length N.
     *
     * Space Complexity: O(1)
     *    - Only a constant amount of space is used for the counter variable.
     *
     * @param nums Input array of integers
     * @return     The number of special quadruplets satisfying the given condition
     */
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length-3; i++){
            for(int j = i+1; j < nums.length-2; j++){
                for(int k = j+1; k < nums.length-1; k++){
                    for(int l = k+1; l < nums.length; l++){
                        if(nums[i] + nums[j] + nums[k] == nums[l]){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    /**
     * Leetcode Problem #2475: Count Special Quadruplets
     *
     * Problem Description:
     * Given an integer array `nums`, return the number of **special quadruplets** (i, j, k, l)
     * such that:
     *  - 0 <= i < j < k < l < nums.length
     *  - nums[i] + nums[j] + nums[k] == nums[l]
     *
     * Approach:
     * 1. Use four nested loops to iterate over all combinations of indices (i, j, k, l) such that i < j < k < l.
     * 2. For each quadruplet, check if the sum of nums[i], nums[j], and nums[k] equals nums[l].
     * 3. If the condition is met, increment the counter.
     * 4. Return the final count after all combinations are checked.
     *
     * Time Complexity: O(N^4)
     *    - Four nested loops over the array of length N.
     *
     * Space Complexity: O(1)
     *    - Only a constant amount of space is used for the counter variable.
     *
     * @param nums Input array of integers
     * @return     The number of special quadruplets satisfying the given condition
     */

    public static int unequalTriplets(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i+1; j < nums.length - 1; j++){
                if(nums[i] == nums[j]){
                    continue;
                }
                for (int k = j+1; k < nums.length; k++){
                    if(nums[i] == nums[k] || nums[j] == nums[k]){
                        continue;
                    }
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Leetcode Problem #2475: Number of Unequal Triplets in an Array
     *
     * Problem Description:
     * Given an array of positive integers `nums`, return the number of triplets (i, j, k)
     * such that:
     *   - 0 <= i < j < k < nums.length
     *   - nums[i], nums[j], and nums[k] are pairwise distinct
     *
     * Optimized Approach:
     * 1. Use a HashMap to count the frequency of each unique number in the array.
     * 2. Iterate over the unique values in sorted order (via map entries):
     *    - For each unique number, calculate how many values are on its left and right.
     *    - Compute the number of triplets with current value in the middle using:
     *         left_count * current_count * right_count
     *    - Accumulate the result and update the left count.
     * 3. Return the total number of valid triplets.
     *
     * This approach avoids O(N^3) brute-force and leverages combinatorial logic.
     *
     * Time Complexity: O(N)
     *    - Single pass to count elements, followed by iteration over unique keys.
     *
     * Space Complexity: O(U)
     *    - Where U is the number of unique elements in the array (for the map).
     *
     * @param nums Input array of integers
     * @return     Total number of unequal triplets with pairwise distinct values
     */
    public static int unequalTriplets_advanced(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                continue;
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        int left = 0;
        int right = nums.length;
        int res = 0;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            right -= entry.getValue();
            res += left *  entry.getValue() * right;
            left += entry.getValue();
         }
        return res;
    }
    public static long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0; i < instructions.length; i++){
            if(!map.containsKey(i)) {
                System.out.println("instruction[i]"+instructions[i]);
                if (instructions[i].equalsIgnoreCase("add")){
                    score += values[i];
                    map.put(i,true);
                    continue;
                }
                map.put(i,true);
                i = (i + values[i]) -1;
                System.out.println("i = " +i);
            }
            else{
                System.out.println("here");
                break;
            }
        }
        System.out.println("score" +score);
        return score;
    }
    public static int maximumPossibleSize(int[] nums) {
        int count = 0;
        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(max == min){
                if(nums[i] > max) {
                    max = nums[i];
                    min = nums[i];
                }
                else{
                    min = nums[i];
                    count++;
                }
            }
            else{
                if(min < nums[i]){
                    if(max < nums[i]){
                        max = nums[i];
                        min = nums[i];
                    }
                    else{
                        min = nums[i];
                        count++;
                    }
                }
                else{
                    count++;
                }
            }
        }
        return len-count;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k > 0){
            int min = nums[0];
            int pos = 0;
            for(int i = 1; i < nums.length; i++){
                if(min > nums[i]){
                    min = nums[i];
                    pos = i;
                }

            }
            nums[pos] = nums[pos] * multiplier;
            k--;
        }
        return nums;
    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        int prev = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(A[i] == B[i]){
                map.put(A[i],2);
                res[i] = prev + 2;
            }
            else {
                if (map.containsKey(A[i])) {
                    map.put(A[i], map.get(A[i]) + 1);
                    res[i] = prev + 2;
                } else {
                    map.put(A[i], 1);
                }
                if (map.containsKey(B[i])) {
                    map.put(B[i], map.get(B[i]) + 1);
                    res[i] = prev + 2;
                } else {
                    map.put(B[i], 1);
                }
            }
            res[i] = prev;
        }
        return res;
    }
    public static boolean isSubsequence(String s, String t){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                continue;
            }
            j++;
        }
        if(i == s.length()){
            return true;
        }
        return false;
    }
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums.length == 0){
            return list;
        }
        String temp = String.valueOf(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1] + 1){
                if(!temp.equals(String.valueOf(nums[i-1]))) {
                    temp += "->" + nums[i - 1];
                }
                list.add(temp);
                temp = String.valueOf(nums[i]);
            }
            else{
                if(i == nums.length-1){
                    temp += "->" + nums[i];
                    list.add(temp);
                    temp = "";
                }
            }
        }
        if(!temp.isEmpty()){
            list.add(temp);
        }
        return list;
    }
    public static boolean isBoomerang(int[][] points) {
        if(points[0][0] != points[1][0] && points[0][1] != points[1][1] ||
                points[0][0] != points[2][0] && points[0][1] != points[2][1] || points[1][0] != points[2][0] && points[1][1] != points[2][1]){
            return false;
        }
        int x = (points[1][1] - points[0][1]) * (points[2][0] - points[1][0]);
        int y = (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]);
        if(x != y){
            return true;
        }
        return false;
    }
}





















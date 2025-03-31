import java.util.*;

public class Intersection {
    public static void main(String args[]){
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {2,3};
        int[][] nums3 = {{1,2,3,4},{2,3}};
        System.out.println(Arrays.toString(intersection_one(nums1, nums2)));
        System.out.println(Arrays.toString(intersection_two(nums1, nums2)));
        System.out.println(findDifference(nums1,nums2));
        System.out.println((intersection_multiple(nums3)));
    }
    /**
     * # Leetcode Problem #349: Intersection of Two Arrays 1
     *
     * This method finds the intersection of two integer arrays, returning an array of unique common elements.
     *
     * Steps:
     * 1. Create an ArrayList to store the result.
     * 2. Use a HashMap to store elements from the first array for quick lookup.
     * 3. Iterate through the second array and check if each element exists in the map.
     * 4. If an element is found, add it to the result list and remove it from the map
     *    to ensure uniqueness in the output.
     * 5. Convert the result list to an integer array and return it.
     *
     * Time Complexity: O(N + M)
     *    - Storing elements in the HashMap: O(N)
     *    - Checking elements in the second array: O(M)
     *    - Converting the ArrayList to an array: O(K), where K is the number of common elements
     *
     * Space Complexity: O(N + K)
     *    - HashMap stores elements from nums1: O(N)
     *    - ArrayList stores unique intersection elements: O(K)
     *    - Final array to return the result: O(K)
     */
    public static int[] intersection_one(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        // Store elements of nums1 in the map
        for (int num : nums1) {
            map.put(num, true);
        }

        // Check for common elements in nums2
        for (int num : nums2) {
            if (map.containsKey(num)) {
                res.add(num);
                map.remove(num); // Remove to prevent duplicates in the result
            }
        }

        // Convert ArrayList to int array and return
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    /**
     * # Leetcode Problem #350: Intersection of Two Arrays II
     *
     * This method finds the intersection of two integer arrays, returning an array of common elements,
     * including duplicates (if an element appears multiple times in both arrays, it appears that many times in the result).
     *
     * Steps:
     * 1. Create an ArrayList to store the result.
     * 2. Use a HashMap to store elements from the first array and their frequencies.
     * 3. If an element appears more than once in the first array, increment its count in the HashMap.
     * 4. Iterate through the second array and check if each element exists in the map with a count > 0.
     * 5. If an element is found, add it to the result list and decrement its count in the map.
     * 6. Convert the result list to an integer array and return it.
     *
     * Time Complexity: O(N + M)
     *    - Storing elements and their counts in the HashMap: O(N)
     *    - Checking elements in the second array and updating counts: O(M)
     *    - Converting the ArrayList to an array: O(K), where K is the number of common elements
     *
     * Space Complexity: O(N + K)
     *    - HashMap stores elements from nums1 with their counts: O(N)
     *    - ArrayList stores the intersection elements (including duplicates): O(K)
     *    - Final array to return the result: O(K)
     */
    public static int[] intersection_two(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> seen = new HashMap<>();

        // Store elements of nums1 and their counts in the HashMap
        for (int num : nums1) {
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }

        // Check for common elements in nums2 and update counts
        for (int num : nums2) {
            if (seen.containsKey(num) && seen.get(num) > 0) {
                res.add(num);
                seen.put(num, seen.get(num) - 1);
            }
        }

        // Convert ArrayList to int array and return
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    /**
     * # Leetcode Problem #2215: Find the Difference of Two Arrays
     *
     * This method identifies the unique elements present in each of the two input arrays but not in the other.
     * It returns a list containing two lists:
     *    - The first list contains elements unique to nums1.
     *    - The second list contains elements unique to nums2.
     *
     * Steps:
     * 1. Create two ArrayLists to store unique elements from nums1 and nums2.
     * 2. Use a HashMap (seen_one) to track elements from nums1 and mark them as false initially.
     * 3. Iterate through nums2:
     *    - If an element is found in seen_one, mark it as true (indicating it's present in both arrays).
     *    - If not found, store it in a second HashMap (seen_two) to track elements unique to nums2.
     * 4. Add elements from seen_one where the value remains false (indicating uniqueness in nums1) to the first list.
     * 5. Add elements from seen_two (all elements are unique to nums2) to the second list.
     * 6. Return a list containing both lists.
     *
     * Time Complexity: O(N + M)
     *    - Storing elements from nums1 in HashMap: O(N)
     *    - Processing nums2 and updating the maps: O(M)
     *    - Collecting unique elements into lists: O(N + M)
     *
     * Space Complexity: O(N + M)
     *    - HashMap seen_one stores elements from nums1: O(N)
     *    - HashMap seen_two stores elements unique to nums2: O(M)
     *    - Two lists store unique elements: O(N + M)
     */
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstArray = new ArrayList<>();
        List<Integer> secondArray = new ArrayList<>();

        HashMap<Integer, Boolean> seen_one = new HashMap<>();
        HashMap<Integer, Integer> seen_two = new HashMap<>();

        // Store elements from nums1 and mark them as false (indicating they haven't been matched yet)
        for (int input1 : nums1) {
            seen_one.put(input1, false);
        }

        // Process nums2: mark matches in seen_one and store unique elements in seen_two
        for (int input2 : nums2) {
            if (seen_one.containsKey(input2)) {
                seen_one.put(input2, true); // Mark as found in both arrays
            } else {
                seen_two.put(input2, input2);
            }
        }

        // Collect elements unique to nums1 (where value remains false in seen_one)
        for (Map.Entry<Integer, Boolean> entry : seen_one.entrySet()) {
            if (!entry.getValue()) {
                firstArray.add(entry.getKey());
            }
        }

        // Collect elements unique to nums2
        for (Map.Entry<Integer, Integer> entry : seen_two.entrySet()) {
            secondArray.add(entry.getValue());
        }

        res.add(firstArray);
        res.add(secondArray);
        return res;
    }
    /**
     * # Leetcode Problem #2248 Intersection of Multiple Arrays
     *
     * This method finds the intersection of multiple arrays. Specifically, it identifies the elements that are common in all input arrays.
     * It returns a list containing the intersection elements, sorted in ascending order.
     *
     * Steps:
     * 1. Create a HashMap to store the occurrence of each element in the first array, nums[0].
     * 2. For each subsequent array, iterate through its elements and update the map:
     *    - If the element is found in the map (i.e., it was in the first array), increment its occurrence.
     *    - If not found, it’s ignored, as it's not in the intersection yet.
     * 3. After processing all arrays, check which elements appear in all arrays (i.e., the value in the map equals the number of input arrays).
     * 4. Add these elements to the result list.
     * 5. Sort the result list in ascending order before returning.
     *
     * Time Complexity: O(N * M)
     *    - N = average length of arrays, M = number of arrays
     *    - Storing elements from nums[0] in HashMap: O(N)
     *    - Processing each subsequent array (nums[i]) and updating the map: O(M * N)
     *    - Collecting intersection elements: O(N)
     *
     * Space Complexity: O(N + M)
     *    - HashMap stores elements from nums: O(N)
     *    - Result list stores intersection elements: O(N)
     */
    public static List<Integer> intersection_multiple(int[][] nums) {
        List<Integer> res = new ArrayList<>();  // Result list to store intersection elements
        Map<Integer, Integer> map = new HashMap<>();  // Map to track element occurrences
        int[] firstArray = nums[0];  // The first array in the input

        // Step 1: Populate the map with elements from the first array
        for (int val : firstArray) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);  // Increment count if element is already in the map
            } else {
                map.put(val, 1);  // Initialize count to 1 for the first occurrence
            }
        }

        // Step 2: Process each subsequent array
        for (int i = 1; i < nums.length; i++) {
            int[] next = nums[i];  // Current array to check for intersections
            int j = 0;

            // Step 3: Check if the element exists in the map and update its count
            while (j < next.length) {
                if (map.containsKey(next[j])) {
                    map.put(next[j], map.get(next[j]) + 1);
                }
                j++;
            }
        }

        // Step 4: Collect elements that appear in all arrays (count equals the number of arrays)
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == nums.length) {
                res.add(entry.getKey());  // Add element to result list if it appears in all arrays
            }
        }

        // Step 5: Sort the result list before returning
        Collections.sort(res);  // Sort the intersection elements in ascending order

        return res;
    }

}

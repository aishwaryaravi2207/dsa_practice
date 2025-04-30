import java.util.*;

public class StringOperations {
    public static void main(String[] args){
//        String s = "AALLPP";
//        System.out.println(checkRecord(s));
//        String input = "030";
//        System.out.println(digitCount(input));
        List<List<String>> input = new ArrayList<>();

        input.add(Arrays.asList("gk", "otg", "ia", "otg", "qs", "cwtk"));
        input.add(Arrays.asList("i", "otg", "otg", "otg", "otg", "otg", "otg"));

        System.out.println(findCommonResponse(input));
    }
    /**
     * Leetcode Problem #551: Student Attendance Record I
     *
     * This method checks whether a student is eligible for an attendance award based on their record.
     * A student is ineligible if:
     *   - They have been absent ('A') more than once, or
     *   - They have been late ('L') for 3 or more consecutive days.
     *
     * Approach:
     * 1. Iterate through the attendance record string.
     * 2. Use two counters: one for tracking total absences, and another for consecutive late days.
     * 3. Reset the late counter if the current character is not 'L'.
     * 4. If absences exceed 1 or if the late counter reaches 3, return false.
     * 5. If no violations are found, return true.
     *
     * Time Complexity: O(N)
     *    - The string is traversed once.
     *
     * Space Complexity: O(1)
     *    - Only a constant amount of space is used for counters.
     *
     * @param s Attendance record as a string consisting of characters 'A', 'L', and 'P'.
     * @return True if the student is eligible for the award; otherwise, false.
     */
    public static boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                absent++;
                late = 0;
            } else if (c == 'L') {
                late++;
            } else {
                late = 0;
            }

            if (absent > 1 || late == 3) {
                return false;
            }
        }
        return true;
    }
    /**
     * Leetcode Problem #2283: Check if Number Has Equal Digit Count and Digit Value
     *
     * This method checks whether a student is eligible for an attendance award based on their record.
     * A student is ineligible if:
     *   - They have been absent ('A') more than once, or
     *   - They have been late ('L') for 3 or more consecutive days.
     *
     * Approach:
     * 1. Iterate through the attendance record string.
     * 2. Use two counters: one for tracking total absences, and another for consecutive late days.
     * 3. Reset the late counter if the current character is not 'L'.
     * 4. If absences exceed 1 or if the late counter reaches 3, return false.
     * 5. If no violations are found, return true.
     *
     * Time Complexity: O(N)
     *    - The string is traversed once.
     *
     * Space Complexity: O(1)
     *    - Only a constant amount of space is used for counters.
     *
     * @param s Attendance record as a string consisting of characters 'A', 'L', and 'P'.
     * @return True if the student is eligible for the award; otherwise, false.
     */
    public static boolean digitCount(String num) {
        int[] check = new int[num.length() + 1];
        int[] res = new int[10];
        for(int i = 0 ; i < num.length(); i++){
            check[i] = num.charAt(i) - '0';
            res[num.charAt(i)-'0']++;
        }
        int k = 0;
        while(k < check.length){
            if(check[k] != res[k]){
                return false;
            }
            k++;
        }
        return true;
    }
    /**
     * Leetcode Problem #2544: Alternating Digit Sum
     *
     * Problem Description:
     * Given an integer `n`, calculate the alternating sum of its digits.
     * Starting from the leftmost digit, alternate the signs of each digit:
     * add the digit if it's at an even index, subtract if it's at an odd index.
     *
     * Approach:
     * 1. Convert the integer `n` to a string to easily access each digit.
     * 2. Iterate through each character in the string:
     *    - Convert the character to its integer value.
     *    - If the index is even, add the digit to the result.
     *    - If the index is odd, subtract the digit from the result.
     *
     * Time Complexity: O(N)
     *    - Where N is the number of digits in the integer.
     *
     * Space Complexity: O(1)
     *    - Uses a constant amount of space for the result and loop variables.
     *
     * @param n Input integer
     * @return  The alternating sum of the digits of the number
     */

    public static int alternateDigitSum(int n) {
        String temp = String.valueOf(n);
        int sum  = 0;
        for(int i = 0; i < temp.length(); i++){
            int num = temp.charAt(i) - '0';
            if(i % 2 != 0){
                num *= -1;
            }
            sum += num;
        }
        return sum;
    }
    /**
     * Leetcode Problem #1869: Longer Contiguous Segments of Ones than Zeros
     *
     * Problem Description:
     * Given a binary string `s`, determine if the longest contiguous segment of 1's
     * is strictly longer than the longest contiguous segment of 0's.
     *
     * Approach:
     * 1. Initialize counters for tracking current streaks of 0's and 1's.
     * 2. Initialize variables to keep track of the maximum streaks for both 0's and 1's.
     * 3. Iterate through each character in the string:
     *    - If the character is '0', increment the zero counter and reset the one counter.
     *    - If the character is '1', increment the one counter and reset the zero counter.
     *    - Update the maximum streak values accordingly.
     * 4. After processing the string, compare the maximum streaks and return true
     *    if the maximum number of contiguous 1's is greater than that of 0's.
     *
     * Time Complexity: O(N)
     *    - Single pass through the string of length N.
     *
     * Space Complexity: O(1)
     *    - Constant space usage for counters and result.
     *
     * @param s Input binary string
     * @return  True if the longest contiguous segment of 1's is greater than that of 0's, otherwise false
     */

    public  static boolean checkZeroOnes(String s) {
        int count_zero = 0, count_one = 0, max_zero = 0 , max_one = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                max_zero = Math.max(max_zero,++count_zero);
                count_one = 0;
            }
            else if(s.charAt(i) == '1') {
                max_one = Math.max(max_one,++count_one);
                count_zero = 0;
            }
        }
        return max_one > max_zero;
    }
    /**
     * Leetcode Problem #1556: Thousand Separator
     *
     * Problem Description:
     * Given an integer `n`, return a string representation of the number
     * with dots ('.') inserted as thousand separators from right to left.
     *
     * Approach:
     * 1. Convert the integer to a string.
     * 2. Initialize a counter to track every third digit from the right.
     * 3. Iterate through the string from the end:
     *    - Append the character to the result.
     *    - After every third character (except the last group), insert a dot.
     * 4. Return the final formatted string.
     *
     * Time Complexity: O(N)
     *    - Single pass through the number string of length N.
     *
     * Space Complexity: O(N)
     *    - Uses additional space proportional to the output string.
     *
     * @param n Input integer
     * @return  String representation of the number with thousand separators
     */

    public static String thousandSeparator(int n) {
        String temp = String.valueOf(n);
        String res = "";
        int counter = 1;
        for(int i = temp.length() - 1; i > 0; i--){
            if(counter % 3 == 0){
                res = "." +  temp.charAt(i) + res;
                counter = 1;
                continue;
            }
            res = temp.charAt(i) + res;
            counter++;
        }
        return temp.charAt(0) + res;
    }
    /**
     * Leetcode Problem #3248: Snake in Matrix
     *
     * This method returns the final position of a snake in a grid after executing a series of movement commands.
     * The snake starts at the top-left corner (0, 0), and moves based on the directions in the `commands` list.
     *
     * Approach:
     * 1. Initialize two indices `i` and `j` to 0 to represent the snake's current row and column position.
     * 2. Iterate through each command in the `commands` list:
     *    - "RIGHT" increments the column (`j++`)
     *    - "LEFT" decrements the column (`j--`)
     *    - "DOWN" increments the row (`i++`)
     *    - "UP" (any other input) decrements the row (`i--`)
     * 3. After processing all commands, calculate the snake's final linear position using:
     *    `grid[i][j] = (i * n) + j`, where `n` is the number of columns in the grid.
     *
     * Time Complexity: O(k)
     *    - k is the number of movement commands.
     *
     * Space Complexity: O(1)
     *    - Constant space is used.
     *
     * @param n The number of columns in the matrix.
     * @param commands A list of movement commands (e.g., "UP", "DOWN", "LEFT", "RIGHT").
     * @return The final position of the snake in linear form based on the grid layout.
     */
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0, j = 0;
        for(String temp : commands){
                if(temp.equalsIgnoreCase("RIGHT")) {
                    j++;
                }
                else if(temp.equalsIgnoreCase("LEFT")) {
                    j--;
                }
                else if(temp.equalsIgnoreCase("DOWN")) {
                    i++;
                }
                else {
                    i--;
                }
            }
        return (i*n) + j;
    }
    /**
     * Leetcode Problem #1572: Matrix Diagonal Sum
     *
     * This method calculates the sum of both the primary and secondary diagonals of a square matrix.
     * If the matrix has an odd dimension, the center element (which lies on both diagonals) is subtracted once
     * to avoid double-counting.
     *
     * Approach:
     * 1. Initialize two pointers:
     *    - `j` starting at 0 to traverse the primary diagonal (top-left to bottom-right).
     *    - `y` starting at n-1 to traverse the secondary diagonal (top-right to bottom-left).
     * 2. Loop through each row `i`, and at each step:
     *    - Add the primary diagonal element `mat[i][j]` and the secondary diagonal element `mat[i][y]` to the sum.
     *    - Increment `i` and `j`, decrement `y`.
     * 3. If the matrix has odd length, subtract the center element once since it was added twice.
     *
     * Time Complexity: O(n)
     *    - Single pass through the matrix diagonals.
     *
     * Space Complexity: O(1)
     *    - Only constant space is used.
     *
     * @param mat A square 2D integer matrix.
     * @return The sum of the primary and secondary diagonal elements.
     */
    public static int diagonalSum(int[][] mat) {
        int i = 0;
        int j = 0;
        int y = mat.length - 1;
        int sum = 0;
        while(i < mat.length){
            sum += mat[i][j++] + mat[i++][y--];
        }
        if(mat.length % 2 != 0){
            int pos = mat.length/2;
            sum -= mat[pos][pos];
        }
        return sum;
    }
    public static String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < responses.size(); i++){
            Map<String,Boolean> checker = new HashMap<>();
            for(int j = 0; j < responses.get(i).size(); j++){
                String temp = responses.get(i).get(j);
                System.out.println("temp:"+temp);
                    if(map.containsKey(temp)){
                        if(checker.containsKey(temp)) {
                            System.out.println("incrementing");
                            map.put(temp, map.get(temp) + 1);
                        }
                        continue;
                    }
                    else {
                        System.out.println("adding");
                        map.put(temp, 1);
                    }
                    checker.put(temp,true);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        System.out.println("Max="+max);
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }
        if(list.size() > 1){
            String temp1 = list.get(0);
            for(int k = 1; k < list.size(); k++){
                String temp2 = list.get(k);
                System.out.println("temp1"+temp1);
                System.out.println("temp2"+temp2);
                int x = 0, y = 0;
                boolean isFound = false;
                while(x < temp1.length() && y < temp2.length()){
                    if(temp1.charAt(x) < temp2.charAt(y)){
                        isFound = true;
                        break;
                    }
                    else if(temp1.charAt(x) > temp2.charAt(y)){
                        isFound = true;
                        temp1 = temp2;
                        break;
                    }
                    x++;
                    y++;
                }
                if(!isFound){
                    temp1 = (temp1.length() > temp2.length())? temp2 : temp1;
                }
                System.out.println("temp1"+temp1);
                System.out.println("temp2"+temp2);
            }
            return temp1;
        }
        return list.get(0);
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[\\s,!?':;]+");
        int max = Integer.MIN_VALUE;
        String res = "";
        Map<String,Integer> map = new HashMap<>();
        for(String temp : words){
            temp = temp.toLowerCase();
            int len = temp.length()-1;
            if(temp.charAt(len) < 97){
                temp = temp.substring(0,len);
            }
            if(Arrays.asList(banned).indexOf(temp) < 0){
                if(map.containsKey(temp)){
                    map.put(temp,map.get(temp) + 1);
                }
                else {
                    map.put(temp,1);
                }
                if(map.get(temp) > max){
                    res = temp;
                    max = map.get(temp);
                }
            }
        }
        return res;
    }
    public static boolean hasSpecialSubstring(String s, int k) {
        String temp = "1" + s + "1";
        for(int i = 0; i < s.length(); i++){
            int loop = i + k - 1;
            if(loop >= s.length()){
                break;
            }
            boolean isRecurring = true;
            while(loop > i){
                if(s.charAt(i) != s.charAt(loop)){
                    isRecurring = false;
                    break;
                }
                loop--;
            }
            if(isRecurring){
                if(s.charAt(i) != temp.charAt(i) && s.charAt(i) != temp.charAt(i+k+1)){
                    return true;
                }
            }
        }
        return false;
    }
}

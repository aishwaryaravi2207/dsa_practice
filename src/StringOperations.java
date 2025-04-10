public class StringOperations {
    public static void main(String[] args){
        String s = "AALLPP";
//        System.out.println(checkRecord(s));
        String input = "030";
        System.out.println(digitCount(input));
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
}

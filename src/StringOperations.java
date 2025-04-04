public class StringOperations {
    public static void main(String[] args){
        String s = "AALLPP";
        System.out.println(checkRecord(s));
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

}

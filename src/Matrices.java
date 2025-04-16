import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matrices {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{-1,10,11},{12,-1,-30}};
        int target = 11;
        System.out.println(modifiedMatrix(matrix));
        System.out.println(searchMatrix(matrix,11));
    }
    /**
     * Leetcode Problem #3033: Modify the Matrix
     *
     * Replaces all `-1` values in the matrix with the maximum value of their respective columns.
     *
     * Approach:
     * 1. For each column:
     *    - Identify the maximum non-`-1` value.
     *    - Track the row indices where `-1` values occur.
     * 2. Replace all `-1` values in that column with the column’s maximum value.
     *
     * Time Complexity: O(N * M)
     *    - Each element in the matrix is visited once, where N is the number of rows and M is the number of columns.
     *
     * Space Complexity: O(N * M)
     *    - A new matrix of the same size is created to store the modified result.
     *
     * @param matrix 2D integer array containing values and possible `-1` entries.
     * @return A new matrix with `-1` values replaced by the maximum values in their respective columns.
     */
    public static int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        for(int i = 0; i < col; i++){
            int maxCol = Integer.MIN_VALUE;
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < row; j++){
                if(matrix[j][i] == -1){
                    temp.add(j);
                    continue;
                }
                if(maxCol < matrix[j][i]){
                    maxCol = matrix[j][i];
                }
                res[j][i] = matrix[j][i];
            }
            for(int k : temp){
                res[k][i] = maxCol;
            }
        }
        return res;
    }

    /**
     * Leetcode Problem #74: Search a 2D Matrix
     *
     * This method checks whether a given target value exists in a 2D matrix.
     * The matrix is sorted such that:
     *   - Each row is sorted in ascending order.
     *   - The first integer of each row is greater than the last integer of the previous row.
     *
     * Approach:
     * 1. Iterate through each row:
     *    - Apply binary search on the row to check for the target.
     *    - Return true if the target is found.
     * 2. If the target is not found in any row, return false.
     *
     * Time Complexity: O(N * log M)
     *    - Binary search is applied on each of the N rows, where each row has M columns.
     *
     * Space Complexity: O(1)
     *    - No additional space is used beyond constant variables.
     *
     * @param matrix A 2D integer array with sorted rows.
     * @param target The value to search for in the matrix.
     * @return true if the target exists in the matrix; false otherwise.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row =  matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
             if(binarySearch(matrix,i,col,target)){
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[][] matrix, int row, int col, int target){
        int low = 0;
        int high = col-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return false;
    }
    /**
     * Leetcode Problem #2739: Total Distance Traveled
     *
     * This method calculates the total distance a vehicle can travel using fuel from both
     * the main tank and the additional tank, based on the following rules:
     *
     * Approach:
     * 1. The vehicle travels 10 kilometers for every liter of fuel consumed from the main tank.
     * 2. After every 5 liters consumed from the main tank, if the additional tank has fuel,
     *    1 liter is transferred from the additional tank to the main tank.
     * 3. This process continues until there is no fuel left in the main tank.
     *
     * Time Complexity: O(N)
     *    - N is the number of liters in the main tank (including any fuel added from the additional tank).
     *
     * Space Complexity: O(1)
     *    - Constant space is used regardless of the input size.
     *
     * @param mainTank The initial number of liters in the main tank.
     * @param additionalTank The number of liters available in the additional tank.
     * @return The total distance the vehicle can travel (in kilometers).
     */
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int total_distance = 0;
        int counter  = 1;
        for(int i  = mainTank; i > 0; i--){
            if(counter % 5 == 0 && additionalTank > 0){
                i += 1;
                additionalTank--;
            }
            total_distance += 10;
            counter++;
        }
        return total_distance;
    }
    /**
     * Leetcode Problem #2133: Check if Every Row and Column Contains All Numbers
     *
     * This method returns true if every row and column in a given n x n matrix contains
     * all the integers from 1 to n exactly once.
     *
     * Approach:
     * 1. Use two integer arrays (`row` and `col`) of size n+1 to track the frequency of elements in each row and column.
     * 2. For each row:
     *    - Increment a counter (`row[0]`) to represent the expected frequency.
     *    - Traverse the row and corresponding column simultaneously:
     *        - Increment the frequency count for each number in both `row` and `col` arrays.
     * 3. After processing each row:
     *    - Verify that every number from 1 to n appears exactly once in both the current row and column.
     *    - If any mismatch is found, return false.
     * 4. If all rows and columns pass the check, return true.
     *
     * Time Complexity: O(n^2)
     *    - Each element of the matrix is visited once.
     *
     * Space Complexity: O(n)
     *    - Additional space is used for the `row` and `col` arrays of size n+1.
     *
     * @param matrix An n x n matrix containing integers from 1 to n.
     * @return true if each row and column contains all numbers from 1 to n exactly once; false otherwise.
     */

    public static boolean checkValid(int[][] matrix) {
        int[] row = new int[matrix.length+1];
        int[] col = new int[matrix.length+1];
        for(int i  = 0; i < matrix.length; i++){
            row[0]++;
            for(int j = 0; j < matrix.length; j++){
                row[matrix[i][j]]++;
                col[matrix[j][i]]++;
            }
            for(int k = 1; k < matrix.length+1; k++){
                if(row[k] != row[0] || col[k] != row[0]){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Leetcode Problem #2661: First Completely Painted Row or Column
     *
     * This method returns the index of the first element in the input array that causes an entire row or column
     * of the matrix to be completely painted (i.e., all elements in that row or column have been seen in `arr`).
     *
     * Approach:
     * 1. Use two integer arrays, `row` and `col`, to count how many cells have been painted in each row and column.
     * 2. Create a map to store the position (row, column) of each value in the matrix.
     * 3. Iterate through `arr`, and for each value:
     *    - Look up its position using the map.
     *    - Increment the corresponding row and column counters.
     *    - If any row or column reaches its full length (fully painted), return the current index.
     *
     * Time Complexity: O(m * n + k)
     *    - O(m * n) to build the map from matrix values to their positions.
     *    - O(k) to iterate through the `arr` and update row/column counters, where k is the length of `arr`.
     *
     * Space Complexity: O(m * n)
     *    - Space is used for the position map and the row/column count arrays.
     *
     * @param arr The sequence in which cells of the matrix are painted.
     * @param mat A 2D matrix of integers.
     * @return The index in `arr` at which a full row or column is painted; -1 if none are fully painted.
     */
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j <  mat[0].length; j++){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                map.put(mat[i][j],temp);
            }
        }
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue().toString());
        }
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                col[(map.get(arr[i])).get(1)] += 1;
                row[(map.get(arr[i])).get(0)] += 1;
                if(col[(map.get(arr[i])).get(1)] == mat.length || row[(map.get(arr[i])).get(0)] == mat[0].length){
                    return i;
                }
            }
        }
        return -1;
    }
}

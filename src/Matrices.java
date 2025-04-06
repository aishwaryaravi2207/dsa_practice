import java.util.ArrayList;
import java.util.List;

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
}

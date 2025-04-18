import java.util.ArrayList;
import java.util.List;

public class Matrices {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};
        System.out.println(onesMinusZeros(matrix));
    }

    /**
     * Leetcode Problem #3033: Modify the Matrix
     * <p>
     * Replaces all `-1` values in the matrix with the maximum value of their respective columns.
     * <p>
     * Approach:
     * 1. For each column:
     * - Identify the maximum non-`-1` value.
     * - Track the row indices where `-1` values occur.
     * 2. Replace all `-1` values in that column with the column’s maximum value.
     * <p>
     * Time Complexity: O(N * M)
     * - Each element in the matrix is visited once, where N is the number of rows and M is the number of columns.
     * <p>
     * Space Complexity: O(N * M)
     * - A new matrix of the same size is created to store the modified result.
     *
     * @param matrix 2D integer array containing values and possible `-1` entries.
     * @return A new matrix with `-1` values replaced by the maximum values in their respective columns.
     */
    public static int[][] modifiedMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < col; i++) {
            int maxCol = Integer.MIN_VALUE;
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                if (matrix[j][i] == -1) {
                    temp.add(j);
                    continue;
                }
                if (maxCol < matrix[j][i]) {
                    maxCol = matrix[j][i];
                }
                res[j][i] = matrix[j][i];
            }
            for (int k : temp) {
                res[k][i] = maxCol;
            }
        }
        return res;
    }

    /**
     * Leetcode Problem #74: Search a 2D Matrix
     * <p>
     * This method checks whether a given target value exists in a 2D matrix.
     * The matrix is sorted such that:
     * - Each row is sorted in ascending order.
     * - The first integer of each row is greater than the last integer of the previous row.
     * <p>
     * Approach:
     * 1. Iterate through each row:
     * - Apply binary search on the row to check for the target.
     * - Return true if the target is found.
     * 2. If the target is not found in any row, return false.
     * <p>
     * Time Complexity: O(N * log M)
     * - Binary search is applied on each of the N rows, where each row has M columns.
     * <p>
     * Space Complexity: O(1)
     * - No additional space is used beyond constant variables.
     *
     * @param matrix A 2D integer array with sorted rows.
     * @param target The value to search for in the matrix.
     * @return true if the target exists in the matrix; false otherwise.
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (binarySearch(matrix, i, col, target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[][] matrix, int row, int col, int target) {
        int low = 0;
        int high = col - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    /**
     * Leetcode Problem #2739: Total Distance Traveled
     * <p>
     * This method calculates the total distance a vehicle can travel using fuel from both
     * the main tank and the additional tank, based on the following rules:
     * <p>
     * Approach:
     * 1. The vehicle travels 10 kilometers for every liter of fuel consumed from the main tank.
     * 2. After every 5 liters consumed from the main tank, if the additional tank has fuel,
     * 1 liter is transferred from the additional tank to the main tank.
     * 3. This process continues until there is no fuel left in the main tank.
     * <p>
     * Time Complexity: O(N)
     * - N is the number of liters in the main tank (including any fuel added from the additional tank).
     * <p>
     * Space Complexity: O(1)
     * - Constant space is used regardless of the input size.
     *
     * @param mainTank       The initial number of liters in the main tank.
     * @param additionalTank The number of liters available in the additional tank.
     * @return The total distance the vehicle can travel (in kilometers).
     */
    public static int distanceTraveled(int mainTank, int additionalTank) {
        int total_distance = 0;
        int counter = 1;
        for (int i = mainTank; i > 0; i--) {
            if (counter % 5 == 0 && additionalTank > 0) {
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
     * <p>
     * This method returns true if every row and column in a given n x n matrix contains
     * all the integers from 1 to n exactly once.
     * <p>
     * Approach:
     * 1. Use two integer arrays (`row` and `col`) of size n+1 to track the frequency of elements in each row and column.
     * 2. For each row:
     * - Increment a counter (`row[0]`) to represent the expected frequency.
     * - Traverse the row and corresponding column simultaneously:
     * - Increment the frequency count for each number in both `row` and `col` arrays.
     * 3. After processing each row:
     * - Verify that every number from 1 to n appears exactly once in both the current row and column.
     * - If any mismatch is found, return false.
     * 4. If all rows and columns pass the check, return true.
     * <p>
     * Time Complexity: O(n^2)
     * - Each element of the matrix is visited once.
     * <p>
     * Space Complexity: O(n)
     * - Additional space is used for the `row` and `col` arrays of size n+1.
     *
     * @param matrix An n x n matrix containing integers from 1 to n.
     * @return true if each row and column contains all numbers from 1 to n exactly once; false otherwise.
     */

    public static boolean checkValid(int[][] matrix) {
        int[] row = new int[matrix.length + 1];
        int[] col = new int[matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            row[0]++;
            for (int j = 0; j < matrix.length; j++) {
                row[matrix[i][j]]++;
                col[matrix[j][i]]++;
            }
            for (int k = 1; k < matrix.length + 1; k++) {
                if (row[k] != row[0] || col[k] != row[0]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Leetcode Problem #2661: First Completely Painted Row or Column
     * <p>
     * This method returns the index of the first element in the input array that causes an entire row or column
     * of the matrix to be completely painted (i.e., all elements in that row or column have been seen in `arr`).
     * <p>
     * Approach:
     * 1. Use two integer arrays, `row` and `col`, to count how many cells have been painted in each row and column.
     * 2. Create a map to store the position (row, column) of each value in the matrix.
     * 3. Iterate through `arr`, and for each value:
     * - Look up its position using the map.
     * - Increment the corresponding row and column counters.
     * - If any row or column reaches its full length (fully painted), return the current index.
     * <p>
     * Time Complexity: O(m * n + k)
     * - O(m * n) to build the map from matrix values to their positions.
     * - O(k) to iterate through the `arr` and update row/column counters, where k is the length of `arr`.
     * <p>
     * Space Complexity: O(m * n)
     * - Space is used for the position map and the row/column count arrays.
     *
     * @param arr The sequence in which cells of the matrix are painted.
     * @param mat A 2D matrix of integers.
     * @return The index in `arr` at which a full row or column is painted; -1 if none are fully painted.
     */
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int rowSize = mat.length;
        int colSize = mat[0].length;
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        int[][] map = new int[rowSize*colSize+1][2];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                map[mat[i][j]][0] = i;
                map[mat[i][j]][1] = j;

            }
        }
        for(int i = 0; i < arr.length; i++){
            if(++col[map[arr[i]][1]] == rowSize || ++row[map[arr[i]][0]] == colSize){
                return i;
            }
        }
        return -1;
    }

    /**
     * Leetcode Problem #2482: Difference Between Ones and Zeros in Row and Column
     *
     * This method computes a new matrix where each cell at position (i, j) is computed as:
     * diff[i][j] = onesRow[i] + onesCol[j] - zerosRow[i] - zerosCol[j]
     *            = 2 * onesRow[i] + 2 * onesCol[j] - rowSize - colSize
     *
     * Approach:
     * 1. Use two arrays `rowOnes` and `colOnes` to count the number of 1s in each row and column.
     * 2. Iterate through the matrix once to fill in these arrays.
     * 3. Construct a result matrix using the difference formula above.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     *
     * @param grid A 2D matrix of integers containing only 0s and 1s.
     * @return A 2D matrix representing the difference as described.
     */
    public static int[][] onesMinusZeros(int[][] grid) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[] row = new int[rowSize];
        int[] col = new int[colSize];
        int rowCount = 0;
        for (int i = 0; i < rowSize; i++) {
            int colCount = 0;
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 0) {
                    row[rowCount]--;
                    col[colCount]--;
                } else {
                    row[rowCount]++;
                    col[colCount]++;
                }
                colCount++;
            }
            rowCount++;
        }

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                grid[i][j] = row[i] + col[j];
            }
        }
        return grid;
    }

    /**
     * Leetcode Problem #1582. Special Positions in a Binary Matrix
     *
     * This method returns the total number of special positions in a binary matrix.
     * A position is considered special if the value is 1 and there are no other 1s
     * in the same row or column.
     *
     * Approach:
     * 1. Use two integer arrays to count the number of 1s in each row and column.
     * 2. Iterate through the matrix, and for each cell with a 1, check if the
     *    corresponding row and column each have exactly one 1.
     *
     * Time Complexity: O(m * n)
     * Space Complexity: O(m + n)
     *
     * @param mat A 2D matrix of integers containing only 0s and 1s.
     * @return The total number of special positions in the matrix.
     */
    public static int numSpecial(int[][] mat) {
        int rowSize = mat.length;
        int colSize = mat[0].length;
        int[] row = new int[rowSize];
        int[] col = new int[colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
}
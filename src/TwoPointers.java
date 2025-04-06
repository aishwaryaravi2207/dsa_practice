import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
}

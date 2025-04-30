import java.util.HashMap;
import java.util.Map;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }

    public static int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
        }
        int windowSize = map.size();
        int count = 1;
        while (windowSize < nums.length) {
            System.out.println("Window Size:" +windowSize);
            int j = windowSize-1;
            int i = 0;
            while(j < nums.length) {
                Map<Integer,Integer> map1 = new HashMap<>();
                int k = i;
                System.out.println("i="+i+"|j="+j);
                while(k <= j){
                    if(!map1.containsKey(nums[k])){
                        System.out.println("nums[k]:" +nums[k]);
                        map1.put(nums[k], 1);
                    }
                    k++;
                }
                System.out.println("map1.size="+map1.size());
                if(map1.size() == map.size()){
                    count++;
                    System.out.println("count="+count);
                }
                i++;
                j++;
            }
            windowSize++;
        }
        return count;
    }
}

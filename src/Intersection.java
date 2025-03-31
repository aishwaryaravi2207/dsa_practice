import java.util.*;

public class Intersection {
    public static void main(String args[]){
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {2,3};
        System.out.println(intersection_advanced(nums1,nums2).toString());
        System.out.println(intersection_basic(nums1,nums2).toString());
        System.out.println(intersection_two(nums1,nums2).toString());
        System.out.println(findDifference(nums1,nums2).toString());
    }
    public static int[] intersection_advanced(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0 ; i < nums1.length; i++){
                map.put(nums1[i], true);

        }
        for(int j = 0; j < nums2.length; j++){
            if(map.containsKey(nums2[j])){
                res.add(nums2[j]);
                map.remove(nums2[j]);
            }
        }
        int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
        return resArray;
    }
    public static int[] intersection_basic(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int prev = 0;
        int pos = 0;
        int[] min = (nums1.length >= nums2.length) ? nums2 : nums1;
        int[] max = (nums1.length >= nums2.length) ? nums1 : nums2;
        for (int i = 0; i < min.length; i++) {
            if (i != 0 && prev == min[i]) {
                continue;
            }
            for (int j = pos; j < max.length; j++) {
                prev = min[i];
                if (min[i] == max[j]) {
                    res.add(max[j]);
                    while (pos + 1 < max.length && max[pos] == max[pos + 1]) {
                        pos++;
                    }
                    break;
                }
            }
            if (pos >= max.length) {
                break;
            }
        }
        int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
        return resArray;
    }
    public static int[] intersection_two(int[] nums1, int[] nums2){
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> seen = new HashMap<>();
        for(int input : nums1){
            if(seen.containsKey(input)){
                seen.put(input, seen.get(input)+1);
            }
            else{
                seen.put(input, 1);
            }
        }
        for(int check : nums2){
            if(seen.containsKey(check) && seen.get(check) > 0){
                res.add(check);
                seen.put(check, seen.get(check)-1);
            }
        }
        int[] output = new int[res.size()];
        for(int i = 0; i < output.length; i++){
            output[i] = res.get(i);
        }
        return output;
    }
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstArray = new ArrayList<>();
        List<Integer> secondArray = new ArrayList<>();

        HashMap<Integer,Boolean> seen_one = new HashMap<>();
        HashMap<Integer,Integer> seen_two = new HashMap<>();
        for(int input1 : nums1){
            seen_one.put(input1,false);
        }
        for(int input2 : nums2){
            if(seen_one.containsKey(input2)) {
                seen_one.put(input2,true);
            }
            else{
                seen_two.put(input2,input2);
            }
        }

        for (Map.Entry<Integer, Boolean> entry : seen_one.entrySet()) {
            if (!entry.getValue()) {
                firstArray.add(entry.getKey());
            }
        }

        for (Map.Entry<Integer, Integer> entry : seen_two.entrySet()) {
            secondArray.add(entry.getValue());
        }
        res.add(firstArray);
        res.add(secondArray);
        return res;
    }
}

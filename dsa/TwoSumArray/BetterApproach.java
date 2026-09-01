
import java.util.*;

public class BetterApproach {

    /*
Time Complexity = 0(n)


Approach use hashmap for storing the number and their index.

loop the array only 1 time, so efficent.

usage of hashmap makes retrieval fast o(1) on avg and o(log n) at worse case



     */
    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;

        // code start
        Map<Integer, Integer> map = new HashMap<>();

        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int more = target - nums[i];

            if (map.containsKey(more)) {
                indices[0] = i;
                indices[1] = map.get(more);

            }

            map.put(nums[i], i);
        }

//        return indices;
        // code end
        for (int i : indices) {
            System.out.println(i);
        }
    }
}


import java.util.*;

public class AnotherBetterApproach {

    public static void main(String[] args) {

        /*

Another approach is using 2 pointers.

one left (index 0 ) and right ( last index ) and they use greedy approach

we sort the given array.

now if the more num (target - cur) is less then we move the left pointer to next index otherwise the right pointer

But This Approach is only Efficient if we only want to check if the target exist, because for getting index we need to store those in some other data stucture than map (if we given requirement that not use hashmap to solve this.)
         */
        int[] nums = {3, 2, 4};
        int target = 6;

        int leftPtr = 0;
        int rightPtr = nums.length - 1;

        Arrays.sort(nums);

        while (leftPtr < rightPtr) {
            if ((nums[leftPtr] + nums[rightPtr]) < target) {
                leftPtr++;
            } else if ((nums[leftPtr] + nums[rightPtr]) > target) {
                rightPtr--;
            } else if ((nums[leftPtr] + nums[rightPtr]) == target) {
                System.out.println("YES");
                return;
            } else {
                System.out.println("NO");
                return;
            }
        }

    }
}

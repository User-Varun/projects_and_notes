
import java.util.HashSet;
import java.util.Set;

public class something {

    public static void main(String[] args) {

        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k = removeDuplicates(nums); // Calls your implementation

        System.out.println(k);
    }

    public static int removeDuplicates(int[] nums) {

        Set<Integer> map = new HashSet<>();
        int writes = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (!map.contains(nums[i])) {

                map.add(nums[i]);
                nums[writes] = nums[i];
                writes++;
            }
        }

        for (int n : nums) {
            System.out.println(n);
        }

        return writes;
    }
;
}

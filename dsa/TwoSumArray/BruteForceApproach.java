
public class BruteForceApproach {

    /*
Time Complexity = 0(n^2)

I Check Every Element after looping at each element ( minus the index i previous addressed e.g. sum of 2 ,5 is same as 5, 2 so skipping that calculation) 




     */
    public static void main(String[] args) {

        int[] nums = {3, 2, 4};
        int target = 6;

        // Code Start
        int[] indices = new int[2];
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if ((nums[i] + nums[j]) == target) {
                    indices[0] = i;
                    indices[1] = j;
                }
            }
        }
        // return indices;
        // code end

        for (int i : indices) {
            System.out.println(i);
        }

    }
}

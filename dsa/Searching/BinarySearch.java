

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {1 , 2 ,3 ,5 ,3 ,54 ,64 };

        System.out.println(binarySearch(nums , 54));
    }


    /**
     * Half the search length after each iteration (efficient than linear search)
     *
     * <p></p>
     *
     * <p>Time complexity :- best o(1) , worst,avg o(log n)</p>          
     * If target value doesn't exist, still it need to search for o(log n)
     *
     * @param nums
     * @param target
     *
     */
    public static String binarySearch(int[] nums, int target) {
         int low = 0;
         int high = nums.length - 1;

        while(low <= high){
//         int mid = (low + high)/2;
            int mid = low + (high - low)/ 2; // to prevent from integer overflow in mid when both value are near int_max;
             if(nums[mid] == target){
                   return mid + " " + nums[mid];
             }else if(nums[mid] > target){
                 high = mid - 1;
             }else{
                 low = mid + 1;
             }
         }

         return "not found";
    }
}
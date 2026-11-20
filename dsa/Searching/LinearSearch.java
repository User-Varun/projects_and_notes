

public class LinearSearch{


    /**
     * Sequencially Searches the data structure;
     *
     * Time complexity :- best o(1) , worst o(n)
     *
     * <p>If target value doesn't exist, still it need to search for o(n)</p>
     *
     *
     * @param nums
     * @param numToFind
     *
     */
    public static int linearSearch(int[] nums , int numToFind){

        for(int n : nums){
            if(n == numToFind){
                return n;
            }
        }

        return -1;

    }

   public static void main(){
        int[] nums = {1 , 2 ,3 ,5 ,3 ,54 ,64 };

    System.out.println(linearSearch(nums , 81));
}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {

    /**
     * Works by comparing and swapping adjacent element; sends max element at last;
     *
     ** <p>Time complexity :- Best o(n) if optimized which I did , worst o(n^2), avg o(n^2)  </p>
     *
     * <p>Generic method structure :- 1.modifiers  2.type parameters  3.return-type  4.method-name(params)</p>
     */
    public static <T extends Comparable<T>> T[] bubbleSort(T[] nums) {

        for(int i = nums.length - 1; i >= 0 ; i-- ){

            int swapped = 0;
            for(int j = 0; j <= i-1; j++  ){
                if(nums[j].compareTo(nums[j+1]) > 0){
                    //swap
                    T temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped++;
                }
            }
            if(swapped == 0){
                break;
            }
        }

        return nums;

    }


    /**
     * Works by finding minimum at each pass and swap it with current assumed minimum;
     *
     * Sends minimum to current assumed front;
     *
     * <p>Time complexity :- Best, worst, avg  0(n^2) </p>
     *
     * @param nums
     */
    public static <T extends Comparable<T>> T[] selectionSort(T[] nums){
        int n = nums.length;

        for(int i = 0; i < n; i++){


            int minInd = i;
            for(int j = i+1; j < n; j++){
                // find the min
                if(nums[minInd].compareTo(nums[j]) > 0){
                    minInd = j;
                }

            }
            // swap
            T temp = nums[i];
            nums[i] = nums[minInd];
            nums[minInd] = temp;

        }

        return nums;
    }

    /**
     * Takes current element and place it in the correct order by swapping all the way to the left util correct place;
     *
     * <p>Time Complexity :- Best o(n) , worst,avg o(n^2)</p>
     * @param nums
     *
     */
    public static <T extends Comparable<T>> T[] insertionSort(T[] nums){
        for(int i = 0; i < nums.length; i++){

            int j = i;
            while(j > 0 && nums[j-1].compareTo(nums[j]) > 0){
                // swap
                T temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;

                j--;
            }
        }
        return nums;
    }


    /**
     * Divides the structure into half and then merge ( recursively)
     *
     * <p>Time Complexity:- best, worst, avg o(n log n)  n: coz of the merge, log n: coz of the divide recursively </p>
     * <p>Space Complexity:- worse o(n) coz of temp arr at merge step</p>
     *
     * @param nums
     * @param low
     * @param high
     * @param <T>
     */
    public static <T extends Comparable<T>> void mergeSort(List<T> nums , int low , int high){

        if(low >= high) return;

        int mid = (low + high)/2;

        // left
        mergeSort(nums ,low , mid );
        //right
        mergeSort(nums , mid+1 , high);
        merge(nums , low , mid , high);
    }

    /**
     * The Merge step, merges based on comparison of logical arrays (indexes) with at pointer on start of each array
     * and then storing the minimum into temp and then adding back to the nums
     * @param nums
     * @param low
     * @param mid
     * @param high
     * @param <T>
     */
    public static <T extends Comparable<T>> void merge(List<T> nums , int low , int mid , int high){

        ArrayList<T> temp = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high ) {

            if(nums.get(left).compareTo(nums.get(right)) < 0){
                temp.add(nums.get(left));
                left++;
            }else{
                temp.add(nums.get(right));
                right++;
            }
        }

        // for remaining  left elements
        while(left <= mid){
            temp.add(nums.get(left));
            left++;
        }
        // for remaining right elements
        while(right <= high){
            temp.add(nums.get(right));
            right++;
        }

        // push the temp to nums
       for(int i = low; i <= high; i++){
           nums.set(i , temp.get(i - low));
       }
    }


    /**
     * take first element as pivot, recursively go through left and right array (logical) and places pivot into it's right position
     * The Pivot is found using :- the left and right index is pointed at low and high  then look for greater than pivot of left and smaller than pivot on the right,
     * when found both smaller and greater and left and right don't cross eachOther we swap, otherwise outside of that loop we swap the low with our right(which means placing pivot at it's right place.)
     *
     * <p>Time Complexity:- best,worst,avg o( n log n)</p>
     * <p>Space Complexity:- 0(1) other than stack mem for recursive calls</p>
     *
     * @param nums
     * @param low
     * @param high
     * @param <T>
     */
    public static <T extends Comparable<T>> void quickSort(List<T> nums , int low , int high){

        if(low < high){
            
        int partitionIndex = findPivot(nums , low , high);

        quickSort(nums , low , partitionIndex - 1 );
        quickSort(nums , partitionIndex+1 , high);
        }
    }

    public static <T extends Comparable<T>> int findPivot(List<T> nums ,int  low , int high){

        int i = low;
        int j = high;
        T pivot = nums.get(low);

        while(i < j){

            // left ptr (i)
            while(nums.get(i).compareTo(pivot) <= 0  && i <= high-1){
                i++;
            }

            // right ptr (j)
            while(nums.get(j).compareTo(pivot) > 0 && j >=  low+1){
                j--;
            }

            if(i < j){
                T temp = nums.get(i);
                nums.set(i , nums.get(j));
                nums.set(j , temp);
            }
            
        }

        // swap arr[low] and arr[j]
        T temp  = nums.get(low);
        nums.set(low , nums.get(j));
        nums.set(j , temp);

        return j;
    }


    public static void main(String[] args){

        // Strings
        String[] s1 = bubbleSort(new String[]{"sd", "sdkf", "sdfsafsd", "sd", "sdkf"});

        // Integers (boxed)
        Integer[] s2 = bubbleSort(new Integer[]{5, 3, 8, 1, 9, 2});

// Doubles
        Double[] s3 = bubbleSort(new Double[]{3.14, 1.41, 2.72, 0.57, 1.73});

// Characters
        Character[] s4 = bubbleSort(new Character[]{'z', 'a', 'm', 'b', 'y'});


        ArrayList<Integer> nums = new ArrayList<>(List.of(3 , 1 , 2 ,4 , 1 ,5 , 6 , 2 ,4));

        mergeSort(nums , 0 , nums.toArray().length -1);
//          quickSort(nums , 0 , nums.toArray().length -1);
      

          for(int n : nums){
              System.out.println(n);
          }

//        for(String n : s1){
//            System.out.print(n + " ");
//        }
//        System.out.println();
//
//        for(int n : s2){
//            System.out.print(n + " ");
//
//        }
//        System.out.println();
//
//        for(double n : s3){
//            System.out.print(n + " ");
//        }
//        System.out.println();
//
//        for(char n : s4){
//            System.out.print(n + " ");
//        }



    }
}

package interviewQA.BinarySearchQA;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,1,1,1};
        int k = 5;
        int ans = splitArrayOptimised(nums, k);//3
        System.out.println(ans);
    }

    //Linear Search Approach
    public static int splitArray(int[] nums, int k) {
        int starting = max(nums);
        int limit = sum(nums);
        for(int i = starting; i <= limit; i++){
            int noOfSubArrays = calculateSubArrays(nums, i);
            if(noOfSubArrays == k){
                return i;
            }
        }
        return starting;
    }

    //Binary Search Approach
    public static int splitArrayOptimised(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for(int i = 0; i <= nums.length-1; i++){
            sum = sum + nums[i];
            max = Math.max(nums[i],max);
        }
        int low = max;
        int high = sum;
        while(low <= high){
            int mid = (low + high)/2;
            int noOfSubArrays = calculateSubArrays(nums, mid);
            if(noOfSubArrays > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int calculateSubArrays(int[] nums, int sumAtThatPoint){
        int sum = 0;
        int noOfSubArrays = 1;
        for(int i = 0; i <= nums.length-1; i++){
            if(sum + nums[i] <= sumAtThatPoint){
                sum+= nums[i];
            }else{
                noOfSubArrays++;
                sum = nums[i];
            }
        }
        return noOfSubArrays;
    }

    private static int sum(int[] nums){
        int sum = 0;
        for(int i = 0; i <= nums.length-1; i++){
            sum = sum + nums[i];
        }
        return sum;
    }

    private static int max(int[] nums){
        int max = 0;
        for(int i = 0; i <= nums.length-1; i++){
            max = Math.max(nums[i],max);
        }
        return max;
    }


}

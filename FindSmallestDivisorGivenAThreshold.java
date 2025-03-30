package interviewQA.BinarySearchQA;

public class FindSmallestDivisorGivenAThreshold {

    public static void main(String[] args){
        int[] nums = {44,22,33,11,1};
        int threshold = 5;
        System.out.println(smallestDivisor(nums, threshold));//44
    }

    public static int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = max(nums);
        int divisor = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            divisor = findSmallestDivisor(nums, mid);
            if(divisor <= threshold){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    private static int findSmallestDivisor(int[] nums, int num){

        double total = 0;
        for(int i = 0; i <= nums.length-1; i++){
            total = total + Math.ceil((double)nums[i]/(double)num);
        }
        return (int)total;
    }

    private static int max(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= nums.length - 1; i++){
            max = Math.max(nums[i], max);
        }
        return max;
    }
}

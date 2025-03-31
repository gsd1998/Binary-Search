package interviewQA.BinarySearchQA;

public class KthMissingPositiveNumber {

    public static void main(String[] args){
        int[] arr = {2,3,4,7,11};
        int k = 5;
        //System.out.println(findKthPositive(arr, k));//9
        System.out.println(findKthPositiveOptimised(arr, k));//9
    }

    public static int findKthPositive(int[] arr, int k) {
        for(int i = 0; i <=  arr.length-1; i++){
            if(arr[i] <= k){
                k++;
            }else{
                break;
            }
        }
        return k;
    }

    public static int findKthPositiveOptimised(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        /*
        After this while loop low and high will end up at a position such that low will point to an index the
        missing numbers are greater than K and hihg will point to an index where the missing numbers are lesser than K
       */
        while(low <= high){
            int mid = low + (high-low)/2;
            int missingNumber = arr[mid] - (mid+1);
            if(missingNumber < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return high+1+k;
    }
}

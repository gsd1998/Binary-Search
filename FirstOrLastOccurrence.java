package interviewQA.BinarySearchQA;

import java.util.Arrays;

public class FirstOrLastOccurrence {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int x = 8;
        System.out.println(Arrays.toString(searchRange(arr, x))); //[3, 4]
    }

    public static int[] searchRange(int[] nums, int target) {
        return binarySearch(nums,target);
    }
    private static int[] binarySearch(int[] arr, int x){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int leftIndex = -1;
        int rightIndex = -1;
        while(low <= high){
            int mid = (low + (high-low)/2);
            if(arr[mid] == x){
                if(leftIndex == -1){
                    leftIndex = mid;
                }
                if(mid < leftIndex)
                    leftIndex = mid;
                high = mid-1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        low = 0;
        high = n-1;
        while(low <= high){
            int mid = (low + (high-low)/2);
            if(arr[mid] == x){
                if(rightIndex == -1){
                    rightIndex = mid;
                }
                if(mid > rightIndex)
                    rightIndex = mid;

                low = mid+1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[]{leftIndex , rightIndex};
    }

}

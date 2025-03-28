package interviewQA.BinarySearchQA;

import java.util.Arrays;
import java.util.List;

public class SingleElementInSortedArray {

    public static void main(String[] args){
        int[] nums = {1,1,2,2,4,5,5};
        System.out.println(singleNonDuplicate(nums));//4
    }

    public static int singleNonDuplicate(int[] arr) {
        int n = arr.length;

        if(n == 1){
            return arr[0];
        }
        if(arr[0] != arr[1]){
            return arr[0];
        }
        if(arr[n-1] != arr[n-2]){
            return arr[n-1];
        }
        int low = 1;
        int high = n - 2;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]){
                return arr[mid];
            }
            if(mid % 2 == 1){
                if(arr[mid] == arr[mid-1]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }else if(mid % 2 == 0){
                if(arr[mid] == arr[mid-1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}

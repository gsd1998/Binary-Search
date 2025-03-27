package interviewQA.BinarySearchQA;

import java.util.Arrays;
import java.util.List;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args){
        int[] nums = {4,5,6,7,9,1,2};
        List<Integer> list = Arrays.asList(4,5,6,7,9,1,2);
        System.out.println(findMin(nums));//1
        System.out.println(findKRotation(list));//5
    }

    //Minimum
    public static int findMin(int []nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[low] <= nums[mid]){
                min = Math.min(min,nums[low]);
                low = mid+1;
            }else{
                min = Math.min(min,nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }

    //Find Kth Rotation
    public static int findKRotation(List<Integer> arr) {

        int n = arr.size();
        int low = 0;
        int high = n-1;
        int min = Integer.MAX_VALUE;
        int index = -1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr.get(low) <= arr.get(mid)){s
                if(arr.get(low) < min){
                    min = arr.get(low);
                    index = low;
                }
                low = mid+1;
            }else{
                if(arr.get(mid) < min){
                    min = arr.get(mid);
                    index = mid;
                }
                high = mid-1;
            }
        }
        return index;
    }

}

package interviewQA.BinarySearchQA;

public class SearchInRotatedSortedArray {

    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(rotateLeft(nums, target));//4
        System.out.println(rotateLeftDuplicates(nums, target));//true
    }

    //Without Duplicates
    private static int rotateLeft(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }else {
                if(nums[mid] <= target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }


    //With Duplicates
    private static boolean rotateLeftDuplicates(int[] nums, int target){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                return true;
            }
            /* handles duplicates as low = mid = high would give incorrect sorted array assumptions,
            hence we trim down search space till any of low or high is different
             */
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }

            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }else {
                if(nums[mid] <= target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return false;
    }
}

package interviewQA;

public class BinarySearch {

    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        int target =9;
        int index = search(nums, target);
        System.out.println(index);//4
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        return binarySearch(nums,low,high,target);
    }

    private static int binarySearch(int[] nums, int low, int high, int target){
        if(low > high){
            return -1;
        }
        int mid = low + (high - low)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if (target > nums[mid]){
            return binarySearch(nums,mid+1,high,target);
        }
        return binarySearch(nums,low,mid-1,target);
    }
}

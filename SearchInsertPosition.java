package interviewQA.BinarySearchQA;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 4};
        int x = 3;
        int n = arr.length;
        System.out.println(searchInsert(arr, x)); //5
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target);
    }

    private static int binarySearch(int[] nums, int x){
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] >= x){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}

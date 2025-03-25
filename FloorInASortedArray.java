package interviewQA.BinarySearchQA;

public class FloorInASortedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int x = 0;
        int n = arr.length;
        System.out.println(findFloor(arr, x)); //-1
    }

    static int findFloor(int[] arr, int x) {
        return binarySearch(arr, x);
    }

    private static int binarySearch(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] <= target){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}

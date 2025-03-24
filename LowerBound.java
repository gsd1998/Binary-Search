package interviewQA.BinarySearchQA;

public class LowerBound {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int x = 0;
        int n = arr.length;
        System.out.println(lowerBound(arr, n, x)); // 0
    }

    public static int lowerBound(int []arr, int n, int x) {
        return binarySearch(arr,n,x);
    }

    private static int binarySearch(int[] arr, int n,int x){
        int low = 0;
        int high = n-1;
        int ans = n;
        while(low <= high){
            int mid = (low + (high-low)/2);
            if(arr[mid] >= x){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

}

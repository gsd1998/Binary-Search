package interviewQA.BinarySearchQA;

import java.util.Arrays;

public class CeilTheFloor {

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
        int x = 7;
        System.out.println(Arrays.toString(getFloorAndCeil(x, arr))); // [6, 8]
    }

    public static int[] getFloorAndCeil(int x, int[] arr) {
        Arrays.sort(arr);
        return binarySearch(arr, x);
    }

    private static int[] binarySearch(int[] arr, int x){
        int n = arr.length;
        int low1 = 0;
        int high1 = n-1;
        int low2 = 0;
        int high2 = n-1;
        int ansFloor = -1;
        int ansCeil = n;
        boolean ceilExists = false;
        boolean floorExists = false;
        int[] op = new int[2];
        while(low1 <= high1){
            int mid1 = low1 + (high1 - low1)/2;
            if(arr[mid1] >= x){
                ceilExists = true;
                ansCeil = arr[mid1];
                high1 = mid1-1;
            }else{
                low1 = mid1+1;
            }
        }
        op[1] = ceilExists ? ansCeil : -1;

        while(low2 <= high2){
            int mid2 = low2 + (high2 - low2)/2;
            if(arr[mid2] <= x){
                floorExists = true;
                ansFloor = arr[mid2];
                low2 = mid2+1;
            }else{
                high2 = mid2-1;
            }
        }
        op[0] = floorExists ? ansFloor : -1;

        return op;
    }
}

package interviewQA.BinarySearchQA;

import java.util.Arrays;

public class NumberOfOccurrence {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        System.out.println(countFreq(arr, x)); //4
    }

    static int countFreq(int[] arr, int target) {
        int output = 0;
        int[] result = binarySearch(arr, target);
        int leftIndex = result[0];
        int rightIndex = result[1];
        if(leftIndex != -1 && rightIndex != -1){
            output = rightIndex - leftIndex + 1;
        }
        return output;
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

package interviewQA.BinarySearchQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//This Question is not from Striver A2Z DSA Sheet
public class FindDuplicateInArray {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(3, 1, 3, 4, 2);
        int n = 5;
        System.out.println(findDuplicate(list, n));//3
    }

    public static int findDuplicate(List<Integer> arr, int n){
        int no = 0;
        int low = 1;
        int high = n-1;
        while(low <= high){
            int count = 0;
            int mid = (low + high)/2;
            for(int a : arr){
                if(a <= mid){
                    count++;
                }
            }
            if(count > mid){
                no = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return no;
    }
}

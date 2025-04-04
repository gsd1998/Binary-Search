package interviewQA.BinarySearchQA;

import java.util.Arrays;
import java.util.List;

public class AllocateBooks {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 34, 67, 90);
        int m = 2;
        int n = 4;
        int ans = findPagesOptimised(list, n, m);//113
        System.out.println(ans);
    }

    //Linear Search
    public static int findPages(List<Integer> arr, int n, int m) {
        int sum = 0;
        int max = 0;
        for(int i = 0; i <= arr.size()-1; i++){
            sum = sum + arr.get(i);
            max = Math.max(arr.get(i),max);
        }
        int low = max;
        int high = sum;

        for(int page = low; page <= high; page++){
            int noOfStuds = findNoOfStudents(arr, page);
            if(noOfStuds == m){
                return page;
            }
        }
        return -1;
    }

    //Binary Search
    public static int findPagesOptimised(List<Integer> arr, int n, int m) {
        int sum = 0;
        int max = 0;
        for(int i = 0; i <= arr.size()-1; i++){
            sum = sum + arr.get(i);
            max = Math.max(arr.get(i),max);
        }
        int low = max;
        int high = sum;
        if(m > n){
            return -1;
        }
        while(low <= high){
            int mid = (low+high)/2;
            int noOfStuds = findNoOfStudents(arr, mid);
            if(noOfStuds > m){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private static int findNoOfStudents(List<Integer>arr, int page){
        int noOfStuds = 1;
        int sumOfPages = 0;
        for(int i = 0; i <= arr.size()-1; i++){
            if(sumOfPages + arr.get(i) <= page){
                sumOfPages += arr.get(i);
            }else{
                noOfStuds++;
                sumOfPages = arr.get(i);
            }
        }
        return noOfStuds;
    }
}

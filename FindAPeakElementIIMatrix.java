package interviewQA.BinarySearchQA;

import java.util.Arrays;

public class FindAPeakElementIIMatrix {

    public static void main(String[] args) {
        int[][] mat = {{-1,-1,-1,-1,-1}, {-1,10,20,15,-1}, {-1,21,30,14,-1}, {-1,7,16,32,-1}, {-1,-1,-1,-1,-1}};
        System.out.println(Arrays.toString(findPeakGrid(mat)));//[2, 2]
    }

    public static int[] findPeakGrid(int[][] mat) {
        int low = 0;
        int high = mat[0].length;
        int m = mat[0].length;
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        while(low <= high){
            int mid = (low+high)/2;
            int row = findRowOfLargestFromColumn(mat, mid);
            int left = mid-1 >= 0 ? mat[row][mid-1] : -1;
            int right = mid+1 <= m-1 ? mat[row][mid+1] : -1;
            if(mat[row][mid] > left && mat[row][mid] > right){
                ans[0] = row;
                ans[1] = mid;
                return ans;
            }else if(mat[row][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static int findRowOfLargestFromColumn(int[][] mat , int col){
        int index = -1;
        int max = -1;
        for(int i = 0; i <= mat.length-1; i++){
            if(mat[i][col] > max){
                max = mat[i][col];
                index = i;
            }
        }
        return index;
    }
}

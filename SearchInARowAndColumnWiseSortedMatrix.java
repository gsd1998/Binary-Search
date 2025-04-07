package interviewQA.BinarySearchQA;

public class SearchInARowAndColumnWiseSortedMatrix {

    public static void main(String[] args) {
        int[][] nums = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        System.out.println(searchMatrix(nums,5));//true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m-1;
        while(row <= n-1 && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(target > matrix[row][col]){
                row++;
            }else{
                col--;
            }
        }
        return false;
    }
}

package interviewQA.BinarySearchQA;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] nums = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrixOptimal(nums,0));//false
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix[0].length;
        boolean isPresent = false;
        for(int i = 0; i <= matrix.length-1; i++){
            if(matrix[i][0] <= target && matrix[i][m-1] >= target){
                isPresent = searchElement(matrix[i], target);
            }
            if(isPresent)
                return true;
        }
        return false;
    }

    private static boolean searchElement(int[] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(matrix[mid] == target){
                return true;
            }else if(matrix[mid] > target){
                high = mid-1;
            }else{
                low =  mid+1;
            }
        }
        return false;
    }

    public static boolean searchMatrixOptimal(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = n*m-1;
        while(low <= high){
            int mid = (low + high)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                high = mid-1;
            }else{
                low =  mid+1;
            }
        }
        return false;
    }
}

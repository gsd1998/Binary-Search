package interviewQA.BinarySearchQA;

public class RowWithMax1s {

    public static void main(String[] args) {
        int[][] nums = {{0,1,1,1}, {0,0,1,1}, {1,1,1,1}, {0,0,0,0}};
        System.out.println(rowWithMax1sOptimal(nums));//2
    }

    public static int rowWithMax1s(int arr[][]) {
        int maxIndex = -1;
        int max = -1;
        for(int i=0; i <= arr.length-1; i++){
            int count = 0;
            for(int j=0; j <= arr[i].length-1; j++){
                if(arr[i][j] == 1){
                    count++;
                }
            }
            if(count > max){
                max = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int rowWithMax1sOptimal(int arr[][]) {
        int maxIndex = -1;
        int max = 0;
        int count = 0;
        int m = arr[0].length;
        for(int i=0; i <= arr.length-1; i++){
            count = m - firstOccurance(arr[i], m, 1);
            if(count > max){
                max = count;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int firstOccurance(int arr[], int size, int num){
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] >= num){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}

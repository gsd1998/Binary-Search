package interviewQA.BinarySearchQA;

public class SquareRoot {

    public static void main(String[] args){
        int n = 4;
        System.out.println(floorSqrt(n));//2
    }

    static int floorSqrt(int n) {
        int low = 1;
        int high = n/2;
        int ans = 0;
        if(n==1){
            return 1;
        }
        while(low <= high){
            int mid = low + (high-low)/2;
            if((long)mid*mid <= n){
                ans = mid;
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }
}

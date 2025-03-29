package interviewQA.BinarySearchQA;

public class NthRootOfANumber {

    public static void main(String[] args){
        int n = 2;
        int m = 9;
        System.out.println(nthRoot(n,m));//3
    }

    public static int nthRoot(int n, int m) {
        int low = 1;
        int high = m/n;
        while(low <= high){
            int mid = low + (high-low)/2;
            double result = Math.pow(mid,n);
            if(result == m){
                return mid;
            }else if(result <= m) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}

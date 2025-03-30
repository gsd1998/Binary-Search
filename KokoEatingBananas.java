package interviewQA.BinarySearchQA;

public class KokoEatingBananas {

    public static void main(String[] args){
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println(minEatingSpeed(piles,h));//30
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);
        int output = 0;

        while(low <= high){
            int mid = low + (high-low)/2;
            int totalHours = func(mid, piles);

            if(totalHours <= h){
                output = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return output;
    }

    private static int func(int noOfbananas, int[] piles){
        double ans = 0;
        for(int i = 0; i <= piles.length - 1; i++){
            ans = ans + Math.ceil((double)piles[i]/(double)noOfbananas);
        }
        return (int)ans;
    }

    private static int max(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= piles.length - 1; i++){
            max = Math.max(piles[i], max);
        }
        return max;
    }
}

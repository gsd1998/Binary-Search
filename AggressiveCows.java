package interviewQA.BinarySearchQA;

import java.util.Arrays;

public class AggressiveCows {

    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCowsOptimised(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);//3
    }

    //This is the brute force approach
    public static int aggressiveCows(int []stalls, int k) {
        Arrays.sort(stalls);
        int limit = stalls[stalls.length-1] - stalls[0];
        for(int distance = 1; distance <= limit; distance++){
            if(canWePlaceCows(stalls, distance, k) == false){
                return distance-1;
            }
        }
        return limit;
    }

    private static boolean canWePlaceCows(int []stalls, int distance, int k){
        int cowCount = 1;
        int lastCowPos = stalls[0];
        for(int i = 1; i <= stalls.length-1; i++){
            if(stalls[i] - lastCowPos >= distance){
                cowCount++;
                lastCowPos = stalls[i];
            }
            if(cowCount >= k){
                return true;
            }
        }
        return false;
    }

    //This is the optimal approach
    public static int aggressiveCowsOptimised(int []stalls, int k) {
        Arrays.sort(stalls);
        int low  = 1;
        int high = stalls[stalls.length-1] - stalls[0];
        while(low <= high){
            int mid = (low + high) / 2;
            if(!canWePlaceCows(stalls, mid, k)){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return high;
    }
}

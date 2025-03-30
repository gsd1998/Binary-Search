package interviewQA.BinarySearchQA;

public class MinimumDaysToMakeMBouquets {

    public static void main(String[] args){
        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;
        System.out.println(minDays(bloomDay, m, k));//3
    }

    public static int minDays(int[] bloomDay, int m, int k) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= bloomDay.length - 1; i++){
            max = Math.max(bloomDay[i], max);
            min = Math.min(bloomDay[i], min);
        }
        int low = min;
        int high = max;
        int countOfBouq = 0;
        long totalFlowersForBouq = (long)m * (long)k;
        if(totalFlowersForBouq > bloomDay.length){
            return -1;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            countOfBouq = BouqCount(bloomDay, mid, k);

            if(countOfBouq >= m){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    //Within that day how many adjavent flowers bloomed
    private static int BouqCount(int[] bloomDay, int mid, int k){
        int count = 0;
        int noOfBouq = 0;

        for(int i = 0; i <= bloomDay.length-1; i++){
            if(bloomDay[i] <= mid){
                count++;
            }else{
                noOfBouq = noOfBouq + (count/k);
                count = 0;
            }
        }
        noOfBouq = noOfBouq + (count/k);
        return noOfBouq;
    }
}

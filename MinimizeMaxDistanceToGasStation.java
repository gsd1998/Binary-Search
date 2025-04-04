package interviewQA.BinarySearchQA;

public class MinimizeMaxDistanceToGasStation {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        System.out.println(minimiseMaxDistanceOptimised(arr,k));//0.5
    }

    //This solution is only partially accepted due to TLE
    public static double minimiseMaxDistance(int []arr, int k){
        int[] howManyGSArr = new int[arr.length-1];
        for(int gasStation = 1; gasStation <= k; gasStation++){
            double maxDiff = -1;
            int maxIndex = -1;
            for(int i = 0; i <= arr.length-2; i++){
                double diff = arr[i+1]-arr[i];
                double sectionLength = diff/(double)(howManyGSArr[i]+1);
                if(sectionLength > maxDiff){
                    maxDiff = sectionLength;
                    maxIndex = i;
                }
            }
            howManyGSArr[maxIndex]++;
        }
        double maxSectionLengthPossible = -1;
        for(int i = 0; i <= arr.length-2; i++){
            double diff = arr[i+1]-arr[i];
            double sectionLength = diff/(double)(howManyGSArr[i]+1);
            maxSectionLengthPossible = Math.max(maxSectionLengthPossible, sectionLength);
        }
        return maxSectionLengthPossible;
    }

    //This uses binary search
    public static double minimiseMaxDistanceOptimised(int []arr, int k){
        double low = 0;
        double high = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            high = Math.max(high, (double)(arr[i + 1] - arr[i]));
        }
        double diff = 1e-6;
        while (high - low > diff) {
            double mid = (low + high) / (2.0);
            int cnt = noOfGasStations(arr, mid);
            if (cnt > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }
    public static int noOfGasStations(int[] arr, double dist) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
            if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }
            cnt += numberInBetween;
        }
        return cnt;
    }

}

package interviewQA.BinarySearchQA;

public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(shipWithinDays(weights,days));//3
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = max(weights);
        int high = sumOfWeights(weights);
        int totalDays = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            totalDays = totalDays(weights, mid);
            if(totalDays <= days){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    private static int sumOfWeights(int[] weights){
        int totalWeight = 0;
        for(int i = 0; i <= weights.length-1; i++){
            totalWeight += weights[i];
        }
        return totalWeight;
    }

    private static int totalDays(int[] weights, int mid){
        int days = 0;
        int weightCapacity = 0;
        for(int i = 0; i <= weights.length-1; i++){
            weightCapacity = weightCapacity + weights[i];
            if(weightCapacity > mid){
                days++;
                weightCapacity = 0;
                i--;
            }
        }
        if(weightCapacity > 0){
            days++;
        }
        return days;
    }

    private static int max(int[] weights){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= weights.length - 1; i++){
            max = Math.max(weights[i], max);
        }
        return max;
    }
}

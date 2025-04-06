package interviewQA.BinarySearchQA;

public class KthElementOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(nums1, nums2, k));//6
        System.out.println(kthElementOptimal(nums1, nums2, k));//6
    }

    public static int kthElement(int nums1[], int nums2[], int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int element = -1;
        int left = 0;
        int right = 0;
        int count = 0;
        while(left < n1 && right < n2){
            if(nums1[left] <= nums2[right]){
                if(count == k-1)
                    element = nums1[left];
                left++;
                count++;
            }else{
                if(count == k-1)
                    element = nums2[right];
                count++;
                right++;
            }
        }
        while(left < n1){
            if(count == k-1)
                element = nums1[left];
            left++;
            count++;
        }
        while(right < n2){
            if(count == k-1)
                element = nums2[right];
            count++;
            right++;
        }
        return element;
    }

    public static int kthElementOptimal(int nums1[], int nums2[], int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if(n1 > n2)
            return kthElement(nums2,nums1,k);
        int low = Math.max(k-n2,0);
        int high = Math.min(k,n1);
        int howManyOnleft = k;
        while(low <= high){
            int mid1 = (low + high)/2;
            int mid2 = howManyOnleft - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1 < n1)
                r1=nums1[mid1];
            if(mid2 < n2)
                r2=nums2[mid2];
            if(mid1-1 >=0)
                l1=nums1[mid1-1];
            if(mid2-1 >=0)
                l2=nums2[mid2-1];

            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
    }
}

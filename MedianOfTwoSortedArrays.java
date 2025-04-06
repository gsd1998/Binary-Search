package interviewQA.BinarySearchQA;

import java.util.ArrayList;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int k = 4;
        System.out.println(findMedianSortedArrays(nums1,nums2));//2.5
        System.out.println(findMedianSortedArraysWithoutSpace(nums1,nums2));//2.5
        System.out.println(findMedianSortedArraysOptimal(nums1,nums2));//2.5
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        double ans = 0;
        ArrayList<Integer> temp = new ArrayList<>();
        int left = 0;
        int right = 0;
        while(left < n1 && right < n2){
            if(nums1[left] <= nums2[right]){
                temp.add(nums1[left]);
                left++;
            }else{
                temp.add(nums2[right]);
                right++;
            }
        }
        while(left < n1){
            temp.add(nums1[left]);
            left++;
        }
        while(right < n2){
            temp.add(nums2[right]);
            right++;
        }
        int size = temp.size();
        if(size % 2 == 1){
            ans = temp.get(size/2);
        }else{
            double median1 = temp.get((size-1)/2);
            double median2 = temp.get((size)/2);
            ans = (median1+median2)/2.0;
        }
        return ans;
    }

    public static double findMedianSortedArraysWithoutSpace(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int index1 = n/2;
        int index2 = n/2 - 1;
        int element1 = -1;
        int element2 = -1;
        int left = 0;
        int right = 0;
        int count = 0;
        while(left < n1 && right < n2){
            if(nums1[left] <= nums2[right]){
                if(count == index1)
                    element1 = nums1[left];
                if(count == index2)
                    element2 = nums1[left];
                left++;
                count++;
            }else{
                if(count == index1)
                    element1 = nums2[right];
                if(count == index2)
                    element2 = nums2[right];
                count++;
                right++;
            }
        }
        while(left < n1){
            if(count == index1)
                element1 = nums1[left];
            if(count == index2)
                element2 = nums1[left];
            left++;
            count++;
        }

        while(right < n2){
            if(count == index1)
                element1 = nums2[right];
            if(count == index2)
                element2 = nums2[right];
            count++;
            right++;
        }

        if(n % 2 == 1){
            return element1;
        }else{
            return (element1+ element2)/2.0;
        }

    }

    public static double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        if(n1 > n2)
            return findMedianSortedArrays(nums2,nums1);
        int low = 0;
        int high = n1;
        int howManyOnleft = (n1 + n2 + 1)/2;
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
                if(n % 2 == 0){
                    return ((double) (Math.max(l1,l2) + Math.min(r1,r2)))/2.0;
                }else{
                    return Math.max(l1,l2);
                }
            }else if(l1 > r2){
                high = mid1-1;
            }else{
                low = mid1+1;
            }
        }
        return 0;
    }
}

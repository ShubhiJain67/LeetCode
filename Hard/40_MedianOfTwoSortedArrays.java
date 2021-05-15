class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int pointer1 = len1 / 2;
        int pointer2 = len2 / 2;
        if(len1 == 0){
            if(len2 % 2 == 0){
                return (nums2[pointer2] + nums2[pointer2 - 1]) / 2.0;
            }
            return nums2[pointer2];
        }
        if(len2 == 0){
            if(len1 % 2 == 0){
                return (nums1[pointer1] + nums1[pointer1 - 1]) / 2.0;
            }
            return nums1[pointer1];
        }
        
        // Setting up the pointers
        if(len1 % 2 == 1 && len2 % 2 == 1){
            if(pointer1 + 1 < len1){
                pointer1++;
            }
            else{
                pointer2++;
            }
        }
        
        // Dividing the 2 arrays into 2 halves
        double median = 0.0;
        int size1 = pointer1 + pointer2;
        int size2 = len1 - pointer1 + len2 - pointer2;
        
        int n11 = 0, n12 = 0, n21 = 0, n22 = 0;
        n11 = setValue(nums1, pointer1 - 1);
        n12 = setValue(nums1, pointer1);
        n21 = setValue(nums2, pointer2 - 1);
        n22 = setValue(nums2, pointer2);
        while(n11 > n22 || n21 > n12){
            if(n11 >= n22){
                pointer1--;
                pointer2++;
            }
            else{
                pointer1++;
                pointer2--;
            }
            n11 = setValue(nums1, pointer1 - 1);
            n12 = setValue(nums1, pointer1);
            n21 = setValue(nums2, pointer2 - 1);
            n22 = setValue(nums2, pointer2);
        }
        
        // Finding the Median
        if(size1 == size2){
            median = (Math.max(n11, n21) + Math.min(n12, n22))/2.0;
        }
        else{
            median = size1 > size2 ? Math.max(n11, n21) : Math.min(n12, n22);
        }
        return median;
    }
    private int setValue(int arr[], int index){
        if(index < 0){
            return Integer.MIN_VALUE;
        }
        if(index >= arr.length){
            return Integer.MAX_VALUE;
        }
        return arr[index];
    }
}
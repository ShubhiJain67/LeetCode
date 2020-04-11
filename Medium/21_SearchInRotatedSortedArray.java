// class Solution {
//     public int[] Reverse(int[] nums,int i,int j){
//         // System.out.println("Reverse enter");
//         while(i<j){
//             int t=nums[i];
//             nums[i++]=nums[j];
//             nums[j--]=t;
//         }
//         // System.out.println("Reverse exit");
//         return nums;
        
//     }
//     public int find(int[] nums){
//         // System.out.println("Find enter");
//         int i=0;
//         while(i!=nums.length-1){
//             if(nums[i]<nums[i+1]) return i;
//             i++;
//         }
//         // System.out.println("Find exit");
//         return i;
//     }
//     public int binarySearch(int[] nums,int val){
//         int i=0,j=nums.length-1,mid=0;
//         while(i<=j){
//             // System.out.println(mid+" "+i+" "+j+" "+nums[mid]+" "+val);
//             mid=(i+j)/2;
//             if(nums[mid]==val) {
//                 // System.out.println("Found");
//                 return mid;
//             }            
//             else if(nums[mid]>val) j=mid-1;
//             else i=mid+1;
//         }
//         return -1;
//     }
//     public int search(int[] nums, int target) {
//         if(nums.length==0)return -1;
//         nums=Reverse(nums,0,nums.length-1);
//         int k=find(nums);
//         // System.out.println(k);
//         nums=Reverse(nums,0,k);
//         nums=Reverse(nums,k+1,nums.length-1);
//         int b=binarySearch(nums,target);
//         if(b==-1) return -1;
//         if(b<=k)return b+nums.length-k-1;
//         else return b-k-1;
//     }
// }
class Solution {
     public int search(int[] A, int target){
         int n=A.length;
int lo=0,hi=n-1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo<hi){
            int mid=(lo+hi)/2;
            if(A[mid]>A[hi]) lo=mid+1;
            else hi=mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot=lo;
        lo=0;hi=n-1;
        // The usual binary search and accounting for rotation.
        while(lo<=hi){
            int mid=(lo+hi)/2;
            int realmid=(mid+rot)%n;
            if(A[realmid]==target)return realmid;
            if(A[realmid]<target)lo=mid+1;
            else hi=mid-1;
        }
        return -1;
    }
}
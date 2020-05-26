class Solution {
    public boolean isPerfectSquare(int Num) {
        long num = (long)Num;
        if(num==0 || num ==1)return true;
        long start = 0;long end = num/2;
        while(start<=end){
            long mid = (start+end)/2;
            long result = mid*mid;
            if(result==num)return true;
            else if(result>num)end = mid-1;
            else start=mid+1;
        }
        return false;
    }
}
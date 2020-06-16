class Solution {
    public int[] shuffle(int[] nums, int n) {
        n=(n<<1);
        int [] arr=new int[n];
        int i=0;
        for(int num:nums){
            arr[i]=num;
            i=i+2;
            if(i==n)
                i=1;
        }
        return arr;
    }
}
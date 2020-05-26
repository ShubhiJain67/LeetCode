class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int [] ans=new int[n];
        int index=arr.length-1;
        ans[index]=-1;
        int max=arr[index];
        index--;
        while(index>=0){
            ans[index]=max;
            if(arr[index]>max)
                max=arr[index];
            index--;
        }
        return ans;
    }
}
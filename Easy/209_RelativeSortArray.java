class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int count[]=new int[1001];
        for(int a:arr1)
            count[a]++;
        int ans[]=new int[arr1.length];
        int index=0;
        for(int i:arr2)
            while(count[i]-->0)
                ans[index++]=i;
        for(int i=0;i<1001 && index<arr1.length;i++)
            while(count[i]-->0)
                ans[index++]=i;
        return ans;
    }
}
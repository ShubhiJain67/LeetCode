class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(minDiff>arr[i]-arr[i-1])
                minDiff=arr[i]-arr[i-1];
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==minDiff){
                ans.add(new ArrayList<>(Arrays.asList(arr[i-1],arr[i])));
            }
        }
        return ans;
    }
}
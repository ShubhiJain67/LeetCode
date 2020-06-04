class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int cityA=0;
        int cityB=0;
        int len=costs.length;
        int arr[][]=new int [len][2];
        for(int i=0;i<len;i++){
            arr[i][0]=costs[i][0]-costs[i][1];
            arr[i][1]=i;
        }
        Arrays.sort(arr,(int []a,int []b)->{
            return a[0]-b[0];
        });
        
        int mid=len/2;
        for(int i=0;i<len;i++){
            if(i<mid)   cityA+=costs[arr[i][1]][0];
            else   cityB+=costs[arr[i][1]][1];
        } 
        return cityA+cityB;
    }
}
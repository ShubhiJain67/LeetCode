class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count=arr1.length;
        for(int x:arr1){
            for(int y:arr2){
                if(Math.abs(x-y)<=d){
                    count--;
                    break;
                }  
            }
        }
        return count;
    }
}
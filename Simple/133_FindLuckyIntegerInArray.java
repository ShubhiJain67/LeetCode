class Solution {
    public int findLucky(int[] arr) {
        int[] arr2 = new int[501];
        for(int x : arr){
            arr2[x]++;
        }
        for(int i = 500; i > 0; i--){
            if(arr2[i] == i){
                return i;
            }
        }
        return -1;
    }
}
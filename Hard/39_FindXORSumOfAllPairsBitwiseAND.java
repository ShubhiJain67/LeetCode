class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        return Approach3(arr1, arr2);
    }
    public int Approach1(int [] arr1, int[] arr2){
        int ans = 0;
        if(arr1 != null && arr2 != null){
            for(int a : arr1){
                for(int b : arr2){
                    ans = (ans ^ (a & b));
                }
            }
        }
        return ans;
    }
    public int Approach2(int [] arr1, int[] arr2){
        if(arr1 != null && arr2 != null){
            if(arr1.length > arr2.length){
                return GetAndOfXor(arr1, GetXor(arr2));
            }
            return GetAndOfXor(arr2, GetXor(arr1));
        }
        return 0;
    }
    public int Approach3(int [] arr1, int[] arr2){
        if(arr1 != null && arr2 != null){
            return GetXor(arr1) & GetXor(arr2);
        }
        return 0;
    }
    public int GetXor(int arr[]){
        int ans = 0;
        for(int a : arr){
            ans = ans ^ a;
        }
        return ans;
    }
    public int GetAndOfXor(int arr[], int xor){
        int ans = 0;
        for(int a : arr){
            ans = (ans ^ (a & xor));
        }
        return ans;
    }
}
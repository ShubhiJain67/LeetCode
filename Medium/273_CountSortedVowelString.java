class Solution {
    public int countVowelStrings(int n) {
        return Approach2(n);
    }
    
    public int Approach1(int n){
        return GetArraySum(DP(n));
    }
    
    public int Approach2(int n){
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }  
    
    public int[] DP(int n){
        if(n == 0){
            return new int[5];
        }
        if(n == 1){
            return new int[]{1, 1, 1, 1, 1};
        }
        int arr[] = DP(n - 1);
        int result[] = new int[5];
        result[4] = 1;
        for(int i = 3; i >= 0; i--){
            result[i] = result[i + 1] + arr[i];
        }
        return result;
    }
    
    public int GetArraySum(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int sum = 0;
        for(int a : arr){
            sum += a;
        }
        return sum;
    }
}
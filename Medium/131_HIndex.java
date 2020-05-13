class Solution {
      public int hIndex(int[] citations) {
           int result = 0;
           if(citations == null || citations.length == 0){
             return result;
           }
           Arrays.sort(citations);
           int n = citations.length;
           for(int i = 0; i < n; i++){
             if(citations[i] >= (n - i)){
                 return (n-i);       
               }
            }
          return result;
     }
}
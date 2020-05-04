class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //-----------------If No more flowers are to be placed--------------------
        if(n==0)return true;
        if(flowerbed.length==1){
            if(flowerbed[0]==0 && n==1)
                return true;
            else
                return false;
        }
        int count=0, i=0, len=flowerbed.length,j=len-1;
        
        //-------------------For any zeros int the begining------------------------
        while(i<len && flowerbed[i]==0){i++;   count++;}
        
        //--------------------If the array only has zeros-------------------------
        if(i==len){
            if(count%2==0) n=n-(count/2);
            else n=n-((count)/2)-1;
            System.out.println(n);
            if(n<=0) return true;
            return false;
        }
        else n=n-count/2;
        if(n<=0) return true;
        
        //------------------------For any zeros at the end------------------------
        count=0;
        while(j>=0 && flowerbed[j]==0){j--; count++;}
        n=n-count/2;
        if(n<=0) return true;
        
        //------------------------For zeros in the middle------------------------
        count=0;
        for(int l=i;l<=j;l++){
            if(flowerbed[l]==0) count++;
            else{
                if(count>2){
                    if(count%2==0)  n=n-((count-2)/2);
                    else n=n-((count-1)/2);
                }
                count=0;
                if(n<=0) return true;
            }
        }
        return false;
    }
}
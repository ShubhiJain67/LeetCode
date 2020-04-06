class FiniteCoinPnC{
    public static void main(String[] args) {
        int coins[]={2,3,5,7};
        int coinCheck[]= new int[coins.length];
        int target=10;
        System.out.println("Total Number of Calls are --> "+CoinsSinglePermutation(coins, target,"",coinCheck));
        System.out.println("Total Number of Calls are --> "+CoinsSingleCombination(coins, target, 0,""));
    }
    public static int CoinsSingleCombination(int coins[],int target,int curi,String ans){
        
        if(target==0){
            System.out.println(ans);
            return 1;
        }
        if(curi>=coins.length) return 0;
        int count=0;
        // Consider current coin
        count+=CoinsSingleCombination(coins, target-coins[curi], curi+1, ans+coins[curi]+" ");
        // Don't Consider current coin
        count+=CoinsSingleCombination(coins, target, curi+1, ans);
        return count;
    }

    public static int CoinsSinglePermutation(int coins[],int target,String ans,int [] coinCheck){
        if(target==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=0;i<coins.length;i++){
            if(coinCheck[i]!=1 && target-coins[i]>=0){
                coinCheck[i]=1;
                count+=CoinsSinglePermutation(coins, target-coins[i], ans+coins[i]+" ", coinCheck);
                coinCheck[i]=0;
            }
            
        }
        
        return count;
    }
}
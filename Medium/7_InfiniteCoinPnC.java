class InfiniteCoinPnC{
    public static void main(String[] args) {
        int coins[]={2,3,5,7};
        int target=10;
        System.out.println("Total Number of Calls are --> "+CoinsInfinitePermutation(coins, target,""));
        System.out.println("Total Number of Calls are --> "+CoinsInfiniteCombination(coins, target, 0,""));
        
    }
    public static int CoinsInfinitePermutation(int coins[],int target,String ans){
        if(target==0){
            System.out.println(ans);
            return 1;
        }
            int count=0;
            for(int i=0;i<coins.length;i++){
                if(target-coins[i]>=0)
                    count+=CoinsInfinitePermutation(coins,target-coins[i],ans+coins[i]+" ");
            }
        return count;
    }

    public static int CoinsInfiniteCombination(int coins[],int target,int index,String ans){
        if(target==0){
            System.out.println(ans);
            return 1;
        }
            int count=0;
            for(int i=index;i<coins.length;i++){
                if(target-coins[i]>=0)
                    count+=CoinsInfiniteCombination(coins,target-coins[i],i,ans+coins[i]+" ");
            }
        return count;
    }
}

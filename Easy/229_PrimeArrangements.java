class Solution {
    int mod = (int)1e9 + 7;
    public int numPrimeArrangements(int n) {
       boolean[] sieve= new boolean[n+1];
       Arrays.fill(sieve,true);
        int prime=0;
        for(int i=2;i<=n;i++){
            if(sieve[i]){
                prime++;
                for(int j=i*i;j<=n;j+=i){
                    sieve[j] = false;
                }
            }
        }
        long ans=1;
        for(int i=1;i<=prime;i++)
            ans=(ans*i)%mod;
        for(int i=1;i<=n-prime;i++)
            ans=(ans*i)%mod;
        if(ans>=Integer.MAX_VALUE){
            return (int)ans%mod;
        }
        return (int)ans;
    }
}
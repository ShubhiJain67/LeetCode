class Solution {
//     public int numTrees(int n) {    
//         int ans=1;
//         long c1=1,c2=1;
//         c1=Factorial(n,1,1);
//         c2=Factorial(2*n,n+1,1);
//         // System.out.println(c1+"  "+c2);
//         ans=(int)(c2/(c1*(n+1)));
//         return ans;
        
//     }
//     public long Factorial(int n,int start,int ans){
//         for(int i=start;i<=n;i++){
//             ans=ans*i;
//         }
//         return ans;
//     }
    public int numTrees(int n) {
    int [] G = new int[n+1];
    G[0] = G[1] = 1;
    
    for(int i=2; i<=n; ++i) {
    	for(int j=1; j<=i; ++j) {
    		G[i] += G[j-1] * G[i-j];
    	}
    }

    return G[n];
}
}
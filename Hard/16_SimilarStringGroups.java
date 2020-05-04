class Solution {
    public int numSimilarGroups(String[] A) {
        int n=A.length;
        int ans=n;
        ArrayList<String> [] map=new ArrayList[n];
        int parent[]=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isSimilar(A[i],A[j])){
                    int parenti=getParent(parent,i);
                    int parentj=getParent(parent,j);
                    if(parenti!=parentj){
                        parent[parentj]=parenti;
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
    public int getParent(int[]parent,int in){
        int child=in;
        int par=parent[child];
        while(par!=child){
            child=par;
            par=parent[child];
        }
        return child;
    }
    public boolean isSimilar(String a,String b){
        int alen=a.length();
        int blen=b.length();
        if(alen!=blen) return false;
        int i=0;
        int j=alen-1;
        while(i<alen && a.charAt(i)==b.charAt(i)) i++;
        if(i==alen)return true;
        while(j>=0 && a.charAt(j)==b.charAt(j)) j--;
        if(a.charAt(i)==b.charAt(j) && a.charAt(j)==b.charAt(i)){
            i++;
            while(i<j && a.charAt(i)==b.charAt(i)){i++;}
            return i==j;
        }
        return false;
    }
}
class Solution {
    public int findCircleNum(int[][] M) {
        ArrayList<Integer> [] ans=new ArrayList[M.length];
        for(int i=0;i<M.length;i++){
            ans[i]=new ArrayList<>();
        }
       for(int i=0;i<M.length;i++){
            for(int j=0;j<M.length;j++){
                if(M[i][j]==1){
                    ans[i].add(j);
                }
            }
       }
        for(int i=0;i<M.length;i++){
            for(Integer aaa:ans[i]){
                System.out.print(aaa+" ");
            }
            System.out.println("**");
        }
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M.length;j++){
                if(i!=j && AnyCommon(ans[i],ans[j])==true){
                    ans[i].addAll(ans[j]);
                    ans[j]=new ArrayList<>();
                }
            }
        }
        int a=0;
        for(int i=0;i<M.length;i++){
            for(Integer aaa:ans[i]){
                System.out.print(aaa+" ");
            }
            System.out.println();
        }
        for(int i=0;i<M.length;i++){
            if(ans[i].size()!=0){
                a++;
            }
        }
        return a;
    }
    public boolean AnyCommon(ArrayList<Integer> a,ArrayList<Integer> b){
        for(Integer aa:a){
            for(Integer bb:b){
                if(aa==bb){
                    System.out.println(aa+"Hello");
                    return true;
                }
            }
        }
        return false;
    }
}
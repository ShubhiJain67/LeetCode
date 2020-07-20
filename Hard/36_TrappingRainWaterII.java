class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int trapRainWater(int[][] hmap) {
        if(hmap.length==0 || hmap[0].length==0)
            return 0;
        int n=hmap.length,m=hmap[0].length;        
        int dir[][]={{-1,0},{0,-1},{0,1},{1,0}};
        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->{
            return hmap[a.i][a.j]-hmap[b.i][b.j];
        });
        boolean seen[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            queue.add(new Pair(i,0));
            queue.add(new Pair(i,m-1));
            seen[i][0]=true;
            seen[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            queue.add(new Pair(0,i));
            queue.add(new Pair(n-1,i));
            seen[0][i]=true;
            seen[n-1][i]=true;
        }
        int maxSoFar=0,waterAdded=0;
        while(queue.size()!=0){
            Pair p=queue.poll();
            if(maxSoFar<hmap[p.i][p.j]){
                maxSoFar=hmap[p.i][p.j];
            }
            for(int d[]:dir){
                int i=p.i+d[0];
                int j=p.j+d[1];
                if(i<n && j<m && i>=0 && j>=0 && seen[i][j]==false){
                    waterAdded+=(maxSoFar-hmap[i][j]>=0)?maxSoFar-hmap[i][j]:0;
                    queue.add(new Pair(i,j));
                    seen[i][j]=true;
                }
            }
            
        }
        return waterAdded;
    }
}
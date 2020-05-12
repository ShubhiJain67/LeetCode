class Solution {
    
    class Pair{
        int v;
        int w;
        Pair(int v,int w){
            this.v=v;
            this.w=w;
        }
    }
    class Quad{
        int v;
        int p;
        int w;
        int wsf;
        Quad(int v,int p,int w,int wsf){
            this.v=v;
            this.p=p;
            this.w=w;
            this.wsf=wsf;
        }
    }
    
    ArrayList<Pair> graph[];
    public int networkDelayTime(int[][] times, int N, int K) {
        graph=new ArrayList[N+1];
        //construction a graph
        for(int [] t:times){
            int u=t[0];
            int v=t[1];
            int w=t[2];
            if(graph[u]==null)
                graph[u]=new ArrayList<>();
            graph[u].add(new Pair(v,w));
        }
        int retArr[]= Dijkstra(K,N);
        int ans=-1;
        for(int i=0;i<=N;i++){
            if(i!=0 && i!=K){
                if(retArr[i]==-1)
                    return -1;
                else{
                    if(retArr[i]>ans)
                        ans=retArr[i];
                }
                    
            }
        }
        return ans;
    }
    public int[] Dijkstra(int src,int N){
        int []mark=new int[N+1];
        for(int i=0;i<=N;i++)
            mark[i]=-1;
        PriorityQueue<Quad> queue=new PriorityQueue<>((Quad a,Quad b)->{
            return a.wsf-b.wsf; 
        });
        Quad q=new Quad(src,-1,0,0);
        queue.add(q);
        while(queue.size()!=0){
            Quad h=queue.remove();
            if(mark[h.v]!=-1)
                continue;
            mark[h.v]=h.wsf;
            if(graph[h.v]!=null){
                for(Pair n:graph[h.v]){
                    if(n.v!=src && mark[n.v]==-1)
                        queue.add(new Quad(n.v,h.v,n.w,h.wsf+n.w));
                }
            }
        }
        return mark;
    }
}
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
        int w;
        int stops;
        Quad(int v,int w,int s){
            this.v=v;
            this.w=w;
            this.stops=s;
        }
    }
    ArrayList<Pair> graph[];
    
    public int findCheapestPrice(int N, int[][] flights, int src, int dst, int K) {
        graph=new ArrayList[N+1];
        for(int [] t:flights){
            int u=t[0];
            int v=t[1];
            int w=t[2];
            if(graph[u]==null)
                graph[u]=new ArrayList<>();
            graph[u].add(new Pair(v,w));
        }
        return Dijkstra(src,dst,K);
    }
     public int Dijkstra(int src,int des,int K){
        PriorityQueue<Quad> queue=new PriorityQueue<>((Quad a,Quad b)->{
            return a.w-b.w; 
        });
        Quad q=new Quad(src,0,K+1);
         queue.add(q);
         while(queue.size()!=0){
            Quad h=queue.remove();
             if(h.v==des)
                 return h.w;
             if(h.stops==0)
                 continue;
            if(graph[h.v]!=null){
                for(Pair n:graph[h.v]){
                    if(n.v!=src)
                        queue.add(new Quad(n.v,n.w+h.w,h.stops-1));
                }
            }
        }
         return -1;
    }
}
class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans=new ArrayList<>();
        all(graph,0,new boolean[graph.length],new ArrayList<>());
        return ans;
    }
    private void all(int [][]graph,int v,boolean [] visited,List<Integer> temp){
        if(v==visited.length-1){
           List<Integer> a=new ArrayList<>();
            a.addAll(temp);
            a.add(v);
            ans.add(a);
            return;
        }
        temp.add(v);
        visited[v]=true;
        for(int vertex:graph[v]){
            all(graph,vertex,visited,temp);
        }
        visited[v]=false;
        temp.remove(new Integer(v));
    }
}
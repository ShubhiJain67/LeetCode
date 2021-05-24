class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> ans = new ArrayList<>();
        int indegree[] = new int[n];
        for(List<Integer> edge : edges){
            indegree[edge.get(1)]++;
        }
        for(int node = 0; node < n; node++){
            if(indegree[node] == 0){
                ans.add(node);
            }
        }
        return ans;
    }
}
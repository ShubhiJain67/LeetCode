class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] preCount = new int[numCourses];
        int [] ans=new int[numCourses];
        int an=0;
        for(int i = 0; i<graph.length;i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            preCount[p[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i = 0;i<preCount.length;i++){
            if(preCount[i]==0)
                q.offer(i);
        }
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans[an]=node;
            an++;
            for(int n : graph[node]){
               preCount[n]--; 
               if(preCount[n]==0)
                   q.offer(n);
            }
        }
        for(int num : preCount)
            if(num>0)
                return new int[0];
        return ans;
    }
}
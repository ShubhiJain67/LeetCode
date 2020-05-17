class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedList<Integer> queue=new LinkedList<>();
        boolean visited[]=new boolean[rooms.size()];
        visited[0]=true;
        queue.add(0);
        while(queue.size()!=0){
            int node=queue.removeFirst();
            for(int n:rooms.get(node)){
                if(!visited[n]){
                    visited[n]=true;
                    queue.addLast(n);
                }
            }
        }
        for(int i=0;i<rooms.size();i++)
            if(!visited[i])
                return false;
        return true;
    }
}
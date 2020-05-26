class Solution {
    public int findJudge(int N, int[][] trust) {
        if(trust.length==0 && N==1) return N;
        if(trust.length==0 && N>1) return -1;
        boolean visited[]=new boolean [N];
        int [] array= new int[N];
        ArrayList<Integer> list= new ArrayList<>();
     
        for(int i=0;i<trust.length;i++){
            array[trust[i][1]-1]++;
            visited[trust[i][0]-1]=true;
            if(array[trust[i][1]-1]==N-1){
                list.add(trust[i][1]-1);
            }
        }
        for(int i:list){
            if(visited[i]==false)
                return i+1;
        }
        return -1;
    }
}
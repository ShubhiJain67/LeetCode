class Solution {
    // HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
    public boolean isPathCrossing(String path) {
        int add[][]=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        ArrayList<String> list=new ArrayList<>();
        int x=0,y=0;
        for(int i=0;i<path.length();i++){
            char ch=path.charAt(i);
            String s=x+","+y;
            if(list.contains(s))
                return true;
            if(ch=='N')
                x--;
            else if(ch=='E')
                y++;
            else if(ch=='S')
                x++;
            else
                y--;
            list.add(s);
        }
        if(list.contains(x+","+y))
            return true;
        return false;
    }
}
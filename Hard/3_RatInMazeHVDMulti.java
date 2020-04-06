class RatInMazeHVDMulti{
    public static void main(String[] args) {
        MazePath(0, 1, 3, 4, "");
        System.out.println();
        System.out.println(CountMazePath(0, 1, 3, 4, ""));
    }
    public static void MazePath(int i,int j,int r,int c,String ans){
        if(i==r && j==c){
            System.out.print(ans+" ");
        } 
        else{
            for(int jump=1;i+jump<=r && j+jump<=c;jump++){
                MazePath(i+jump , j+jump, r, c, "D"+ans);
            }
            for(int jump=1;i+jump<=r;jump++){
              MazePath(i+jump , j, r, c, "H"+ans);
            }
            for(int jump=1;j+jump<=c;jump++){
                MazePath(i , j+jump, r, c, "V"+ans);
            } 
        }
    }
    public static int CountMazePath(int i,int j,int r,int c,String ans){
        int count=0;
        if(i==r && j==c){
            count++;
        } 
        else{
            for(int jump=1;i+jump<=r && j+jump<=c;jump++){
                count+=CountMazePath(i+jump,j+jump, r, c, "D"+ans);
            }
            for(int jump=1;i+jump<=r;jump++){
                count+=CountMazePath(i+jump , j, r, c, "H"+ans);
            }
            for(int jump=1;j+jump<=c;jump++){
                count+=CountMazePath(i , j+jump, r, c, "V"+ans);
            } 
        }
        return count;
        
    }
}
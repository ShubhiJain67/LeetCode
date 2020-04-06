class RatInMazeHVDSingle{
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
            if(i+1<=r && j+1<=c){
                MazePath(i+1 , j+1, r, c, "D"+ans);
            }
            if(i+1<=r){
              MazePath(i+1 , j, r, c, "H"+ans);
            }
            if(j+1<=c){
                MazePath(i , j+1, r, c, "V"+ans);
            } 
        }
    }
    public static int CountMazePath(int i,int j,int r,int c,String ans){
        int count=0;
        if(i==r && j==c){
            count++;
        } 
        else{
            if(i+1<=r && j+1<=c){
                count+=CountMazePath(i+1 , j+1, r, c, "D"+ans);
            }
            if(i+1<=r){
                count+=CountMazePath(i+1 , j, r, c, "H"+ans);
            }
            if(j+1<=c){
                count+=CountMazePath(i , j+1, r, c, "V"+ans);
            } 
        }
        return count;
        
    }
}
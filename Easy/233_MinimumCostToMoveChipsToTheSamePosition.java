class Solution {
    public int minCostToMoveChips(int[] position) {
        int Pos1=0,Pos2=0,len=position.length;
        for(int i=0;i<len;i++){
            if((position[i]&1)==0)
                Pos1++;
            else
                Pos2++;
        }
        return Math.min(Pos1,Pos2);
    }
}
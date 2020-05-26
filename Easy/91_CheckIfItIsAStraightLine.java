class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if( coordinates.length < 2) return true;  
        
        double yCoordinate =  coordinates[1][1] - coordinates[0][1];
        double xCoordinate =  coordinates[1][0] -  coordinates[0][0];
        double slope = yCoordinate/xCoordinate;
        
        for(int i=0; i<coordinates.length - 1 ;i++){
                yCoordinate = coordinates[i+1][1] -  coordinates[i][1];
                xCoordinate =  coordinates[i+1][0] -  coordinates[i][0];
                if((yCoordinate/xCoordinate) != slope){
                    return false;
                }
        }
        return true; 
    }
}
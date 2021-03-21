class Solution {
    public int largestAltitude(int[] gain) {
        int heightestGain = 0;
        if(gain != null){
            if(gain.length > 0){
                int currentAltitude = 0;
                for(int altitudeRise : gain){
                    currentAltitude += altitudeRise;
                    heightestGain = heightestGain > currentAltitude ? heightestGain : currentAltitude;
                }
            }           
        }
        return heightestGain;
    }
}
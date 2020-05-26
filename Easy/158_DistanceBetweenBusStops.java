class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int min1=0,min2=0;
        int i=0,j=0;
        if(start<destination){
            i=start;
            while(i<destination)
                min1+=distance[i++];
            j=destination;
            while(j<distance.length)
                min2+=distance[j++];
            j=0;
            while(j<start)
                min2+=distance[j++];
        }
        else{
            i=destination;
            while(i<start)
                min1+=distance[i++];
            j=start;
            while(j<distance.length)
                min2+=distance[j++];
            j=0;
            while(j<destination)
                min2+=distance[j++]; 
        }
        return min1>min2?min2:min1;
    }
}
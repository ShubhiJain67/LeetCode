class Solution {
    public int minOperations(String[] logs) {
        int distanceFromMain = 0;
        for(String log : logs){
            if(log.equals("../")){
                if(distanceFromMain != 0){
                    //System.out.println("Going back to the Parent folder");
                    distanceFromMain--;
                }
            }
            else if(log.equals("./")){
                //Do nothing
                //System.out.println("Staying in te current folder");
            }
            else{
                //System.out.println("Shifting to a new folder : " + log);
                distanceFromMain++;
            }
        }
        return distanceFromMain;
    }
}
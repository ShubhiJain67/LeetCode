class Solution {
    public int balancedStringSplit(String s) {
        int sum=0;
        int count=0;
        for(int i=0;i<s.length();i++){
		//Subtract 1 when L is discovered
            if(s.charAt(i)=='L')sum=sum-1;
			//Add 1 when R is discovered
            else  sum=sum+1;
			//The Sum becomes 0 whenever equal number of L and R are detected
            if(sum==0) count++;
        }
        return count;
    }
}
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len=people.length;
        if(len<2) return len;
        int ans=0;
        int i=0,j=len-1;
        while(i<=j){
            if(people[i]+people[j]<=limit )
               i++;
            j--;
            ans++;
        }
        return ans;
    }
}
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(cheeseSlices<0 || tomatoSlices<0 || cheeseSlices>tomatoSlices) return new ArrayList<Integer>();
        double a=1.*(tomatoSlices-2*cheeseSlices)/2;
        double b=1.0*(4*cheeseSlices-tomatoSlices)/2;
        List<Integer> ans=new ArrayList<>();
        if(a>=0 && b>=0 && a-(int)a==0.0 && b-(int)b==0.0){
            ans.add((int)a);
            ans.add((int)b);
        }
        return ans;
    }
}
class Solution {
    private int[] w;
    public Solution(int[] w1) {
        w=new int[w1.length];
        w[0]=w1[0];
        for(int i=1;i<w.length;i++) {
            w[i]=w[i-1]+w1[i];
        }
    }
    
    public int pickIndex() {
        int i = new Random().nextInt(w[w.length-1])+1;
        int start = 0;
        int end = w.length-1;
        while(start<=end) {
            int mid = end+(start-end)/2;
            if(w[mid]==i) {
                return mid;
            } else if(w[mid]<i){
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return  start;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
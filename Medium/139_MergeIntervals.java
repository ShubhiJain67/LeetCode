class Solution {
    public int[][] merge(int[][] intervals) {
        int len=intervals.length;
        if(len==0 || len==1) return intervals;
        Arrays.sort(intervals,(int [] a,int [] b)->{
            return a[0]-b[0];
        });
        int first=intervals[0][0];
        int last=intervals[0][1];
        List<int []> ans=new ArrayList<>();
        for(int i=1;i<len;i++){
            int curFirst=intervals[i][0];
            int curLast=intervals[i][1];
            if(last>=curFirst){
                if(curLast>last)
                    last=curLast;
            }
            else{
                int add[]={first,last};
                ans.add(add);
                first=curFirst;
                last=curLast;
            }
        }
        int add[]={first,last};
        ans.add(add);
        int [][] retArr=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            retArr[i]=ans.get(i);
        }
        return retArr;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len=intervals.length;
        int [][] interval=new int [len+1][2];
        interval[0]=newInterval;
        for(int i=1;i<=len;i++)
            interval[i]=intervals[i-1];
        len++;
        if(len==0 || len==1) return interval;
        Arrays.sort(interval,(int [] a,int [] b)->{
            return a[0]-b[0];
        });
        int first=interval[0][0];
        int last=interval[0][1];
        List<int []> ans=new ArrayList<>();
        for(int i=1;i<len;i++){
            int curFirst=interval[i][0];
            int curLast=interval[i][1];
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
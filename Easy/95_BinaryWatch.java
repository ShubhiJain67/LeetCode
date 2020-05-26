class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans=new ArrayList<>();
        if(num>8) return ans;
        ArrayList<String> [] hour=new ArrayList[12];
        ArrayList<String> [] minute=new ArrayList[60];
        for(int i=0;i<12;i++){
            int bit=Integer.bitCount(i);
            if(hour[bit]==null)
                hour[bit]=new ArrayList<>();
            hour[bit].add(i+"");
        }
        for(int i=0;i<60;i++){
            int bit=Integer.bitCount(i);
            if(minute[bit]==null)
                minute[bit]=new ArrayList<>();
            if(i<10)
                minute[bit].add("0"+i+"");
            else
                minute[bit].add(i+"");
        }
        for(int i=0;i<=num;i++){
            int h=i;
            int m=num-i;
            if(h<4 && m<6){
                for(String hs: hour[h]){
                    for(String ms: minute[m]){
                        ans.add(hs+":"+ms);
                    }
                }
            }
        }
        return ans;
    }
}
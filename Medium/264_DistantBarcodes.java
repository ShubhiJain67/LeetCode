class Solution {
    class Pair{
        int num;
        int count;
        Pair(int n,int c){
            this.num=n;
            this.count=c;
        }
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len=barcodes.length;
        if(len==0 || len==1 || len==2)
            return barcodes;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int b:barcodes)
            map.put(b,map.getOrDefault(b,0)+1);
        PriorityQueue<Pair> queue=new PriorityQueue<>((Pair a,Pair b)->{
            return b.count-a.count;
        });
        for(Integer key:map.keySet())
            queue.add(new Pair(key,map.get(key)));
        int index=0,count=0;
        Pair a=queue.poll();
        while(count<len){
            count++;
            if(a.count !=0){
                barcodes[index]=a.num;
                a.count--;
                index=index+2;
                if(index>=len)
                    index=1;
            }
            if(queue.size()!=0 && a.count==0)
                a=queue.poll();
        }
        return barcodes;
    }
}
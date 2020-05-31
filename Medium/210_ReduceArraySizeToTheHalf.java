class Solution {
    class Pair{
        int num;
        int count;
        Pair(int num,int count){
            this.num=num;
            this.count=count;
        }
    }
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr)
            map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Pair> queue=new PriorityQueue<>((Pair a,Pair b)->{
            return b.count-a.count;
        });
        int ans=arr.length;
        int count=0;
        for(int k:map.keySet()){
            queue.add(new Pair(k,map.get(k)));
        }
        while(ans>arr.length/2){
            ans-=queue.poll().count;
            count++;
        }
        return count;
    }
}
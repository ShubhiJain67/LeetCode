class Solution {
    class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue=new PriorityQueue<>((Pair p1,Pair p2)->{
            return (p2.a+p2.b) - (p1.a+p1.b);
        });
        int count=0;
        for(int i:nums1){
            for(int j:nums2){
                queue.add(new Pair(i,j));
                count++;
                if(count>k){
                    count--;
                    queue.poll();
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        while(count--!=0){
            List<Integer> l=new ArrayList<>();
            Pair p=queue.poll();
            l.add(p.a);
            l.add(p.b);
            ans.add(l);
        }
        return ans;
    }
}
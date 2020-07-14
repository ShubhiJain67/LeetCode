class Solution {
    public int findKthLargest(int[] nums, int k) {
        return usingMaxHeap(nums,k);
    }
    private int usingMinHeap(int[] nums, int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
            if(i>=k){
                queue.poll();
            }
        }
        return queue.poll();
    }
    private int usingMaxHeap(int[] nums, int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>((Integer a, Integer b)->{
            return b-a;
        });
        for(int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        while(k-->1)
            queue.poll();
        return queue.poll();
    }
}

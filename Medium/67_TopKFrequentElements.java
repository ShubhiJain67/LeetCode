class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        
        for(int ind = 0; ind < nums.length; ind++){
            map.put(nums[ind], map.getOrDefault(nums[ind], 0) + 1);
        }
        
        int count = 0;
        for(int num : map.keySet()){
            
            if(count < k){
                count++;
                minHeap.add(num);
            }else if(map.get(minHeap.peek()) < map.get(num)){
                minHeap.poll();
                minHeap.add(num);
            }
        }
        int arr[] = new int[k];
        for(int num : minHeap){
            arr[k - 1] =num;
            k--;
        }
        return arr;
    }
}
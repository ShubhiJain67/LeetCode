class Solution {
    public int[] twoSum(int[] nums, int target) {
        return Approach4(nums, target);
    }
    
    // TC : O(n^2)
    // SC : O(1)
    private int[] Approach1(int[] nums, int target){
        //Get all possible pairs
        int result[] = new int[2];
        
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        
        return result;
    }
    
    // TC : O(nlogn)
    // SC : O(n)
    class Pair{
        int index;
        int value;
        Pair(int i, int v){
            this.index = i;
            this.value = v;
        }
    }
    
    class valueComparator implements Comparator<Pair>{
        public int compare(Pair p1, Pair p2){
            return p1.value - p2.value;
        }
    }
    
    private int[] Approach2(int[] nums, int target){
        
        //Sort the array with their indexes
        //Use 2 pointer Approach
        int result[] = new int[2];
        Pair[] pairNums = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            pairNums[i] = new Pair(
                i,
                nums[i]
            );
        }
        
        Arrays.sort(pairNums, new valueComparator());
        int i = 0;
        int j = nums.length - 1;
        
        while(i < j){
            if(pairNums[i].value + pairNums[j].value == target){
                result[0] = pairNums[i].index;
                result[1] = pairNums[j].index;
                break;
            }
            else if(pairNums[i].value + pairNums[j].value < target){
                i++;
            }
            else{
                j--;
            }
        }
        
        return result;
    }
    
    // TC : O(2n)
    // SC : O(n)
    private int[] Approach3(int[] nums, int target){
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //Use HashMap to add all numbers with their indexes
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        //Find if the pair
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
        }
        return result;
    }
    
    // TC : O(n)
    // SC : O(n)
    private int[] Approach4(int[] nums, int target){
        //Use HashMap to find target - num
        int result[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
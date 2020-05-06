class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return calculatePermutation(nums, nums.length-1);                           
    }
    
    private List<List<Integer>> calculatePermutation(int[] nums, int currIndex){
        List<List<Integer>> distListCurr = new ArrayList<>();
        if(currIndex == 0){                                                         
            distListCurr.add(new ArrayList<Integer>(List.of(nums[0])));
            return distListCurr;                                        
        }
        
        List<List<Integer>> distListPrev = calculatePermutation(nums, currIndex-1); 
        
        int currItem = nums[currIndex];
        
        for(List<Integer> innerListPrev : distListPrev){                            
            for(int i=0;i<=currIndex;i++){                                          
                List<Integer> innerListNew = new ArrayList<>(innerListPrev);        
                innerListNew.add(i,currItem);
                distListCurr.add(innerListNew);
            }
        }
        
        return distListCurr;
    }
}

    
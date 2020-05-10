class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(CanForm(nums[i],nums[j],nums[k])==true){
                        count++;
                    }else{
                        break;
                    }
                }
            }
        }
        return count;
    }
    public boolean CanForm(int a,int b,int c){
        return (a+b)>c && (b+c)>a && (a+c)>b;
    }
}
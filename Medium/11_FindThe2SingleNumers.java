import java.util.*;
class FindThe2SingleNumers {
    public static void main(String args[]){
        int []nums={1,2,3,4,5,1,2,3,4,5,6,7};
        int ans[]=singleNumber(nums);
        System.out.print("[");
        for(int num:ans){
            System.out.print(num+",");
        }

        System.out.println("]");
    }
    public static  int[] singleNumber(int[] nums) {
        int [] ans=new int[2];
        int AllXor=nums[0]^nums[0];
        for(int num:nums){
            AllXor=AllXor^num;
        }
        ArrayList<Integer> set1=new ArrayList<>();
        ArrayList<Integer> set2=new ArrayList<>();
        int firstSetBit=AllXor&(-AllXor);
        for(int num:nums){
            if((num&firstSetBit)==0){
                set1.add(num);
            }
            else{
                set2.add(num);
            }
        }
        AllXor=(AllXor^AllXor);
        for(int num:set1){
            AllXor=AllXor^num;
        }
        // for(int num:set1){
        //     System.out.print(num+" ");
        // }
        // System.out.println();
        // for(int num:set2){
        //     System.out.print(num+" ");
        // }
        ans[0]=AllXor;
        AllXor=AllXor^AllXor;
        for(int num:set2){
            AllXor=AllXor^num;
        }
        ans[1]=AllXor;
        return ans;
        
    }
}
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans=new ArrayList<>();
        int index=A.length-1;
        int carry=0;
        int num=0;
        while(K!=0 || index>=0){
            // System.out.println(K+" "+carry);
            num=0;
            if(index>=0)
                num+=A[index];
            if(K!=0)
                num+=K%10;
            num+=carry;
            carry=num/10;
            ans.add(0,num%10);
            index--;
            K=K/10;
        }
        // System.out.println(carry);
        if(carry!=0)
            ans.add(0,carry);
        return ans;
    }
}
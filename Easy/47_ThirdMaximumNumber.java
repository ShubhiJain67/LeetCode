class Solution {
    public int thirdMax(int[] num) {
        if(num.length==1) return num[0];
        if(num.length==2) return num[0]>num[1]?num[0]:num[1];
        ArrayList<Integer> n=new ArrayList<>();
        for(int nums:num){
            if(n.indexOf(nums)==-1){
                n.add(nums);
            }
        }
        if(n.size()==1) return n.get(0);
        if(n.size()==2) return n.get(0)>n.get(1)?n.get(0):n.get(1);
        num=new int[n.size()];
        for(int i=0;i<n.size();i++){
            num[i]=n.get(i);
        }
        for(int i=0;i<3;i++){
            for(int j=i+1;j<num.length;j++){
                if(num[i]<num[j]){
                    int nn=num[i];
                    num[i]=num[j];
                    num[j]=nn;
                }
            }
        }
        System.out.println(num[0]+" "+num[1]+" "+num[2]);
        if(num[0]>num[1] && num[1]>num[2]){
            return num[2];
        }
        return num[0];
    }
}
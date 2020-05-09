class Solution {
    public int countLargestGroup(int n) {
        int[] arr=new int[37];
        int max=0;
        int count=0;
        for(int i=1;i<=n;i++){
            int sum=Sum(i);
            arr[sum]++;
            if(max<arr[sum]){
                max=arr[sum];
                count=1;
            }else if(max==arr[sum])
                count++;
            // System.out.println(sum+" "+max+" "+count);
        }
        return count;
    }
    public int Sum(int i){
        int sum=0;
        while(i!=0){
            sum=sum+i%10;
            i=i/10;
        }
        return sum;
    }
}
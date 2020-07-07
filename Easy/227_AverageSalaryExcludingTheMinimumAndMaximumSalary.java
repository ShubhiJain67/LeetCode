class Solution {
    public double average(int[] salary) {
        int mini = Integer.MAX_VALUE,maxi = Integer.MIN_VALUE;
        double sum = 0;
        for(int i=0; i<salary.length; i++){
            if(salary[i] < mini)
                mini = salary[i];
            if(salary[i] > maxi)
                maxi = salary[i];
            sum += salary[i];
        }
        double total = salary.length;
        for(int i=0; i<salary.length; i++){
            if(mini == salary[i]){
                sum -= salary[i];
                total -= 1;
            }
            if(maxi == salary[i]){
                sum -= salary[i];
                total -= 1;
            }
        }
        return sum / total;
    }
}
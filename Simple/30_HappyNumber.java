class Solution {
    public boolean isHappy(int num) { 
        int result = num;  
          
        while(result != 1 && result != 4){  
            result = isHappyNumber(result);  
        } 
        if(result == 1)  
            return true;
        return false;
    }
    public int isHappyNumber(int num){  
        int rem = 0, sum = 0;  
        while(num > 0){  
            rem = num%10;  
            sum = sum + (rem*rem);  
            num = num/10;  
        }  
        return sum;  
    } 
} 
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);
        int sum=sc.nextInt();
        allPermutations(arr,sum,"",0);
    }
    public static void allPermutations(int []arr,int sum,String ans,int i){
        if(sum==0){
            System.out.println(ans);
            return ;
        }
        if(i>=arr.length) return;
        if(sum-arr[i]>=0){
            allPermutations(arr,sum-arr[i],ans+arr[i]+" ",i);
            allPermutations(arr,sum,ans,i+1);
        }
            
    }
    
}
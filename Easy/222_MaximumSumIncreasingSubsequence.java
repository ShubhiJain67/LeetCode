/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int arr[]=new int[n];
		    for(int i=0;i<n;i++){
		        arr[i]=sc.nextInt();
		    }
		    System.out.println(maxSumBitonic(arr,n-1));
		}
	}
	private static int maxSumBitonic(int arr[],int n){
	    int inc=0,dpInc[]=new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i])
                    dpInc[i]=Math.max(dpInc[j],dpInc[i]);
            }
            dpInc[i]+=arr[i];
            inc=Math.max(inc,dpInc[i]);
        }
        return inc;
	}
}
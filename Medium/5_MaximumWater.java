/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int inp=sc.nextInt();
		for(int i=1;i<=inp;i++){
		    int len=sc.nextInt();
		    int arr[]=new int[len];
		    for(int j=0;j<len;j++){
		        arr[j]=sc.nextInt();
		    }
		    System.out.println(MaximumWater(arr,len));
		}
	}
	public static int MaximumWater(int []arr,int len){
	    int max=0;
	    int temp=0;
	    for(int i=0;i<len;i++){
	        for(int j=i+1;j<len;j++){
	            temp=(j-i)*(arr[j]<arr[i]?arr[j]:arr[i]);
	            if(temp>max){
	                max=temp;
	            }
	        }
	    }
	    return max;
	}
}
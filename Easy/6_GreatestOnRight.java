/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		//code
    	Scanner sc=new Scanner(System.in);
    	int Inp=sc.nextInt();
    	int len=0;
    	int ar[];
    	for(int i=1;i<=Inp;i++){
    	    len=sc.nextInt();
    	    ar=new int[len];
    	    for(int j=0;j<len;j++){
    	        ar[j]=sc.nextInt();
    	    }
    	    GreatestOnRight(ar);
    	}
	}
	public static void GreatestOnRight(int []ar){
	   int size=ar.length;
	   int ans[]=new int[size]; 
	   ans[size-1]=-1;
	   int largest=ar[size-1];
	   for(int i=size-2;i>=0;i--){
	       if(largest<ar[i+1]){
	           largest=ar[i+1];
	       }
	       ans[i]=largest;
	   }
	   
	   display(ans);
	}
	public static void display(int []ar){
	    for(int i=0;i<ar.length;i++){
	        System.out.print(ar[i]+" ");
	    }
	    System.out.println();
	}
}
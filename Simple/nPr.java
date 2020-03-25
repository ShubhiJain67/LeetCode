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
		    int n=sc.nextInt();
		    int r=sc.nextInt();
		    System.out.println(npr(n-r,n));
		}
	}
	public static long npr(int a,int b){
	    long ans=1;
	    for(int i=a+1;i<=b;i++){
	        ans=ans*i;
	    }
	    return ans;
	}
}
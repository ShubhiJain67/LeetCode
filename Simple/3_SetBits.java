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
		    int num=sc.nextInt();
		    System.out.println(SetBits(num));
		}
	}
	private static int SetBits(int num){
	    int count=0;
	    while(num!=0){
	        int r=num%2;
	        if(r==1)count++;
	        num=num/2;
	    }
	    return count;
	}
}

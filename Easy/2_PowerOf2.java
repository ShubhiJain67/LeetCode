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
		    long ii=sc.nextLong();
		    if(check(ii))
		    System.out.println("YES");
		    else
		    System.out.println("NO");
		}
	}
	public static boolean check(long num){
	    long a=1;
	    if(num==0) return false;
	    if(num==1) return true;
	    while(a<num){
	        a=a*2;
	    }
	    if(a==num) return true;
	    return false;
	}
}
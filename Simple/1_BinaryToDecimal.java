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
		    long bin=sc.nextLong();
		    System.out.println(Decimal(bin));
		}
		
	}
	public static long Decimal(long binary){
	    long deci=0;
	    long mul=1;
	    while(binary!=0){
	        long r=binary%10;
	        deci=deci+r*mul;
	        mul=mul*2;
	        binary=binary/10;
	    }
	    return deci;
	}
}

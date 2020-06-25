/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-->0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    int grid[][]=new int[n][m];
		    dp=new int[n][m];
		    for(int i=0;i<n;i++){
		        for(int j=0;j<m;j++){
		            grid[i][j]=sc.nextInt();
		        }
		    }
		    System.out.println(Iter(grid));
		}
	}
	static int dp[][];
	private static int EveryRow(int [][] grid){
	    int max=0;
	    for(int i=0;i<grid.length;i++){
	        dp[i][0]=Rec(grid,i,0,grid.length-1,grid[0].length-1);
	        if(max<dp[i][0])
	            max=dp[i][0];
	   }
	   return max;
	}
	private static int Rec(int [][] grid,int si,int sj,int ei,int ej){
	    if(si<0 || si>ei || sj>ej)
	        return 0;
	   if(dp[si][sj]!=0)
	        return dp[si][sj];
	    int TopRight=Rec(grid,si-1,sj+1,ei,ej);
	    int Right=Rec(grid,si,sj+1,ei,ej);
	    int BottomRight=Rec(grid,si+1,sj+1,ei,ej);
	    dp[si][sj]=grid[si][sj]+Math.max(TopRight,Math.max(BottomRight,Right));
	    return dp[si][sj];
	}
	private static int Iter(int grid[][]){
	    int ei=grid.length-1;
	    int ej=grid[0].length-1;
	    for(int j=ej;j>=0;j--){
	        for(int i=ei;i>=0;i--){
	            if(j==ej){
	                dp[i][j]=grid[i][j];
	                continue;
	            }
	           else{
	               int dir[][]={{-1,1},{0,1},{1,1}};
	               int currMax=0;
	               for(int d[]:dir){
	                   int x=i+d[0];
	                   int y=j+d[1];
	                   if(x>=0 && y>=0 && x<=ei && y<=ej)
	                        currMax=Math.max(currMax,dp[x][y]);
	               }
	               dp[i][j]=grid[i][j]+currMax;	 
	           }
	        }
	   }
	   int max=0;
	   for(int i=ei;i>=0;i--){
	       max=Math.max(max,dp[i][0]);
	   }
	   return max;
	}
}
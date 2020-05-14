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
        int matrix[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int moves=sc.nextInt();
        if(moves<n || matrix[n-1][n-1]==0){ 
            System.out.println(false);
            return;
        }
        System.out.println(helper(matrix,0,0,n-1,n-1,moves,0));
    }
    public static int dir[][]={{1,0},{0,1},{0,-1},{-1,0}};
    public static boolean helper(int matrix[][],int i,int j,int ti,int tj,int moves,int movesTillNow){
        if(movesTillNow==moves && (i!=ti || j!=tj)) return false;
        if(i==ti && j==tj) return true;
        
        for(int d=0;d<dir.length;d++){
            int r=i+dir[d][0];
            int c=j+dir[d][1];
            if(r>=0 && c>=0 && r<matrix.length && c<matrix[0].length && matrix[r][c]==1 ){
                matrix[r][c]=0;
                boolean retAns=helper(matrix,r,c,ti,tj,moves,movesTillNow+1);
                if(retAns==true)
                    return true;
                matrix[r][c]=1;
            }
        }
        return false;
    }
}
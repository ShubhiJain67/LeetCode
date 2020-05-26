class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr<image.length && sc<image[0].length && image[sr][sc]!=newColor){
            floodfill_(image,sr,sc,image[sr][sc],newColor);
        }
        return image;
    }
    int dir[][]={{1,0},{0,1},{-1,0},{0,-1}};
    public void floodfill_(int [][] image,int i,int j,int color,int newColor){
        image[i][j]=newColor;
        for(int d=0;d<dir.length;d++){
            int ii=i+dir[d][0];
            int jj=j+dir[d][1];
            if(ii>=0 && jj>=0 && ii<image.length && jj<image[0].length && image[ii][jj]==color)
                floodfill_(image,ii,jj,color,newColor);
        }
    }
}
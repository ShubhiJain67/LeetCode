/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Tree
{
    int height(Node node) 
    {
         // Your code here
           if(node==null) return 0;
           int lh=height(node.left)+1;
           int rh=height(node.right)+1;
           return lh>rh?lh:rh;
    }   
}

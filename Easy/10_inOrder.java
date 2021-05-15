

//User function Template for Java


// class Node{
//     int data;
//     Node left,right;
//     Node(int d){
//         data=d;
//         left=right=null;
//     }
// }

class BinaryTree
{
    /* Computes the number of nodes in a tree. */
    static void inOrder(Node root)
    {
        // Code here
         if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
}
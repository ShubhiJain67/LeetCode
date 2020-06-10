/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
            return null;
        if(head.child!=null){
            Node temp=head.next;
            Node n=flatten(head.child);
            head.next=n;
            head.child=null;
            if(n!=null)
                n.prev=head;
            Node t=head;
            while(t.next!=null){
                t=t.next;
            }
            t.next=temp;
            if(temp!=null)
                temp.prev=t;
        }
        else
            head.next= flatten(head.next);
        return head;
            
    }
}
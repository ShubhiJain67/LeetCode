class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
         // code here
        int len1=0;
        int len2=0;
        Node helpA=headA;
        while(helpA!=null){
            helpA=helpA.next;
            len1++;
        }
        Node helpB=headB;
        while(helpB!=null){
            helpB=helpB.next;
            len2++;
        }
        int diff=len1-len2;
        if(diff>0){
            while(diff!=0){
                headA=headA.next;
                diff--;
            }
        }
        else{
            while(diff!=0){
                headB=headB.next;
                diff++;
            }
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA.data;
	}
}
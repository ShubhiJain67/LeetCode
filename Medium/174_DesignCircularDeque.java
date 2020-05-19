class MyCircularDeque {
    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
            this.next=null;
        }
    }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    Node list;
    Node head;
    Node tail;
    int size;
    int maxSize;
    
    public MyCircularDeque(int k) {
        this.list=null;
        this.head=null;
        this.tail=null;
        this.size=0;
        this.maxSize=k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.size==this.maxSize)
            return false;
        Node n=new Node(value);
        n.next=this.head;
        this.head=n;
        if(this.size==0)
            this.tail=n;
        this.size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.size==0)
            return insertFront(value);
        if(this.size==this.maxSize)
            return false;
        Node n=new Node(value);
        this.tail.next=n;
        this.tail=n;
        this.size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.size==0)
            return false;
        if(this.size==1){
            this.head=null;
            this.tail=null;
        }
        else{
            this.head=this.head.next;
        }
        this.size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.size==0)
            return false;
        if(this.size==1){
            this.head=null;
            this.tail=null;
        }else{
            Node n=this.head;
            while(n.next!=this.tail)
                n=n.next;
            n.next=null;
            this.tail=n;
        }
        this.size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(this.size==0)
            return -1;
        return this.head.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(this.size==0)
            return -1;
        return this.tail.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size==this.maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
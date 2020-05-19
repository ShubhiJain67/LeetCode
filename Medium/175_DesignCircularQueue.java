class MyCircularQueue {
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
    public MyCircularQueue(int k) {
        this.list=null;
        this.head=null;
        this.tail=null;
        this.size=0;
        this.maxSize=k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.size==this.maxSize)
            return false;
        Node n=new Node(value);
        if(this.size==0){
            this.head=n;
            this.tail=n;
        }else{
            this.tail.next=n;
            this.tail=n;
        }
        this.size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
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
    
    /** Get the front item from the queue. */
    public int Front() {
        if(this.size==0)
            return -1;
        return this.head.val;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(this.size==0)
            return -1;
        return this.tail.val;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.size==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.size==this.maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
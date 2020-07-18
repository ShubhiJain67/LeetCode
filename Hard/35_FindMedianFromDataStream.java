class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> left,right;
    public MedianFinder() {
        left=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size()==0 || left.peek()>num)
            left.add(num);
        else
            right.add(num);
        if(left.size()>right.size()+1){
            right.add(left.poll());
        }
        if(right.size()>left.size()){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return ((double)(left.peek()+right.peek()))/2;
        }
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
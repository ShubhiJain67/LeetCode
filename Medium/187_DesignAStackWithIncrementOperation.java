class CustomStack {
    private int stack[];
    private int top;
    private int maxSize;
    public CustomStack(int maxSize) {
        this.stack=new int[maxSize];
        this.top=0;
        this.maxSize=maxSize;
    }
    
    public void push(int x) {
        if(this.top!=maxSize){
            stack[top++]=x;
        }
    }
    
    public int pop() {
        if(this.top==0)
            return -1;
        return stack[--top];
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<k && i<top;i++)
            stack[i]+=val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
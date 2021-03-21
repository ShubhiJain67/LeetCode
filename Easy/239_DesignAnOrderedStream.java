class OrderedStream {
    String stream[];
    int pointer = -1;
    int streamSize = 0;
    
    public OrderedStream(int n) {
        this.stream = new String[n];
        this.streamSize = n;
    }
    
    public List<String> insert(int idKey, String value) {
        idKey = idKey - 1;
        List<String> ans = new ArrayList<String>();
        if (idKey > -1 && idKey < this.streamSize){
            this.stream[idKey]=value;
            if (this.pointer + 1 == idKey){
                while (this.pointer + 1 < this.streamSize && this.stream[this.pointer + 1] != null){
                    ans.add(this.stream[this.pointer + 1]);
                    this.pointer ++;
                }
            }
        }
        
        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
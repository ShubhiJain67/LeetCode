class ProductOfNumbers {
ArrayList<Integer> products = new ArrayList();
    
    public ProductOfNumbers() {
        products.add(1);
    }
    
    public void add(int num) {   
        if (num == 0){
            products.clear();
            products.add(1);
        }            
        else {
            products.add(products.get(products.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int n = products.size();
        if (n > k)
            return products.get(n - 1) / products.get(n - k - 1);
        else
            return 0;
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
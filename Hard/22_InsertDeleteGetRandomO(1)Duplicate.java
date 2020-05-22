class RandomizedCollection {
    static class Node {
        int index, value;
        public Node(int i, int v) {
            index = i;
            value = v;
        }
    }

    HashMap<Integer, LinkedList<Node>> valueToNodes = new HashMap<Integer, LinkedList<Node>>();
    ArrayList<Node> arr = new ArrayList<Node>();
    Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        LinkedList<Node> nodes = valueToNodes.get(val);
        boolean res = false;
        if (nodes == null) {
            nodes = new LinkedList<Node>();
            valueToNodes.put(val, nodes);
            res = true;
        }
        Node node = new Node(arr.size(), val);
        arr.add(node);
        nodes.add(node);
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        LinkedList<Node> nodes = valueToNodes.get(val);
        if (nodes == null) {
            return false;
        }
        Node nodeToRemove = nodes.removeFirst();
        if (nodes.isEmpty()) {
            valueToNodes.remove(val);
        }
        int lastIndexInArr = arr.size() - 1;
        if (nodeToRemove.index == lastIndexInArr) {
            arr.remove(lastIndexInArr);
        } else {
            Node lastNode = arr.get(lastIndexInArr);
            lastNode.index = nodeToRemove.index;
            arr.set(lastNode.index, lastNode);
            arr.remove(lastIndexInArr);                
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size())).value;
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
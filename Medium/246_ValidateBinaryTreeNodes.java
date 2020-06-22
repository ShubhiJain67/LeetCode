class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if (n < 2) return true;
        int[] indegree = new int[n];
        for (int i : leftChild)
            if (i != -1)
                if (++indegree[i] > 1) return false;
        for (int i : rightChild)
            if (i != -1)
                if (++indegree[i] > 1) return false;
        int rootNodeCount = 0, rootNodeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] < 1){
                rootNodeIndex = i;
                if (++rootNodeCount > 1) return false;
            }
        }
        return rootNodeCount == 1 && (leftChild[rootNodeIndex] != -1 || rightChild[rootNodeIndex] != -1);
    }
}
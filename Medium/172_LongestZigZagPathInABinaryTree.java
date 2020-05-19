class Solution {
    public int longestZigZag(TreeNode root) {
        dfs(root, -1);
        return ans - 1;
    }
    int ans = 1;
    private int dfs(TreeNode root, int direction){
        if(root == null)
            return 0;
        int left = dfs(root.left, 1) + 1;
        int right = dfs(root.right, -1) + 1;
        ans = Math.max(ans, Math.max(left, right));
        return (direction == -1)? left : right;
    }
    
}
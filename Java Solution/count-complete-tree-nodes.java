class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int height = getHeight(root);
        int left = (1 << (height - 1));
        int right = (1 << height) - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (isExist(root, mid)){
                left = mid;
            } else {
                right = mid;
            }
        }
        if (isExist(root, right)){
            return right;
        }
        return left;
    }

    private int getHeight(TreeNode root){
        int height = 0;
        while (root != null){
            height++;
            root = root.left;
        }
        return height;
    }

    private boolean isExist(TreeNode root, int target){
        if (root == null || target <= 0){
            return false;
        }
        int size = 32 - Integer.numberOfLeadingZeros(target);
        for (int i = size - 2; i >= 0; i--){
            int cur = (target >> i) & 1;
            if (cur == 0){
                root = root.left;
            } else {
                root = root.right;
            }

            if (root == null){
                return false;
            }
        }
        return true;
    }
}
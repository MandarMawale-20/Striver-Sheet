/*
 * Problem: Sum of Root To Leaf Binary Numbers
 * 
 * You are given the root of a binary tree where each node has a value 0 or 1. 
 * Each root-to-leaf path represents a binary number starting with the most significant bit.
 * 
 * For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 
 * 01101 in binary, which is 13.
 * 
 * For all leaves in the tree, consider the numbers represented by the path from 
 * the root to that leaf. Return the sum of these numbers.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) { 
        this.val = val; 
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    
    // Not a Optimal (Opttimal is Bit Manipulation) ###Do Later
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, new StringBuilder());
    }

    public int helper(TreeNode root, StringBuilder str) {
        if (root == null) {
            return 0;
        }
        
        str.append(root.val);

        int sum = 0;

        if (root.left == null && root.right == null) {
            sum = Integer.parseInt(str.toString(), 2);
        } else {
            sum += helper(root.left, str);
            sum += helper(root.right, str);
        }
        
        str.deleteCharAt(str.length() - 1);

        return sum;
    }
}

public class sumOfRootOfBinaryTree {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        
        int result = sol.sumRootToLeaf(root);
        
        System.out.println("\nSum: " + result);
    }
}

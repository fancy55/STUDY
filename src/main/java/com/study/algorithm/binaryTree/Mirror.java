package com.study.algorithm.binaryTree;

public class Mirror {
    public static void Mirror(TreeNode root) {
        if(root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            if (root.left != null) Mirror(root.left);
            if (root.right != null) Mirror(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t2.right = t5;
        t4.left = t8;
        t3.left = t6;
        t3.right = t7;
        System.out.println(root.toString());
        Mirror(root);
        System.out.println(root.toString());
    }
}

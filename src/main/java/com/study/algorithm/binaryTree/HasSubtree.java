package com.study.algorithm.binaryTree;

public class HasSubtree {
    public static boolean HasSubtree1(TreeNode r1,TreeNode r2) {
        if(r2==null || r1==null)return false;
        return findSubTree(r1,r2);
    }

    public static boolean findSubTree(TreeNode r1,TreeNode r2){
        if(r2 == null)return true;
        if(r1 == null)return false;
        boolean flag = false;
        if(r1.val == r2.val){
            flag = findSubTree(r1.left, r2.left)&&findSubTree(r1.right, r2.right);
        }
        if(!flag)flag =  findSubTree(r1.left, r2) || findSubTree(r1.right, r2);
        return flag;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
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

        TreeNode root1 = new TreeNode(3);
        root1.left = t6;
        root1.right = t7;
        System.out.println(HasSubtree1(root, root1));
    }
}

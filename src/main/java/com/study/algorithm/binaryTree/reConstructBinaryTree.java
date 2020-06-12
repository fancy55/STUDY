package com.study.algorithm.binaryTree;

/**
 * 根据前序和中序重建二叉树
 */
public class reConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,8,5,3,6,7};
        int[] in  = {8,4,2,5,1,6,3,7};
        TreeNode treeNode = reConstructBinaryTree1(pre,in);
        print(treeNode);
    }

    public static TreeNode reConstructBinaryTree1(int [] pre,int [] in) {
        return reConstructBinaryTreeCore(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    public static TreeNode reConstructBinaryTreeCore(int [] pre, int sp, int ep, int in[], int si, int ei) {
        if(sp > ep ||si > ei)return null;
        TreeNode root = new TreeNode(pre[sp]);
        for(int i = si;i <= ei; i++){
            if(root.val == in[i]){
//                System.out.println(root.val+"===");
                root.left =reConstructBinaryTreeCore(pre, sp+1, i+(sp-si), in, si, i-1);//左
                root.right=reConstructBinaryTreeCore(pre, i+1+(sp-si), ep, in,i+1, ei);//右
            }
        }
        return root;
    }

    public static void print(TreeNode treeNode){
        if(treeNode == null)return;
        print(treeNode.left);
        print(treeNode.right);
        System.out.println(treeNode.val);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                "}";
    }
}
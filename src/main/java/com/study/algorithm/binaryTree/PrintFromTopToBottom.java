package com.study.algorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null)return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            queue.remove(node);
            System.out.println(queue);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
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
        System.out.println(PrintFromTopToBottom(root));
    }
}

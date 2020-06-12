package com.study.algorithm.binaryTree;

import java.util.ArrayList;

/*打印出二叉树中结点值的和为输入整数的所有路径*/
public class FindPath {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if(root == null)return list;
        path.add(root.val);
        if(root.left == null && root.right == null && target == root.val)list.add(new ArrayList<>(path));
        findPath(root.left, target-root.val);
        findPath(root.right, target-root.val);
        path.remove(path.size()-1);
        return list;
    }

    public static void main(String[] args) {

    }
}

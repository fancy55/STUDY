package com.study.algorithm.binaryTree;

/*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。*/
public class VerifySequenceOfBST {
    public static boolean VerifySquenceOfBST(int [] a) {
        if(a.length == 0)return false;
        return bst(a, 0, a.length-1);
    }

    public static boolean bst(int[] a, int l, int r){
        if(l == r || r < 0) return true;
        TreeNode root = new TreeNode(a[r]); //根
        int flag = r;
        for(int i = l;i <= r; i++){
            if(a[i] > root.val){ //此node左边都是左子树
                flag = i;
                for(int j = i; j <=r; j++){
                    if(a[j] < root.val)return false;
                }
                break;
            }
        }
        System.out.println(a[flag]);
        return bst(a,l,flag-1) && bst(a, flag, r-1);
    }

    public static void main(String[] args) {
        int[] a= {};
        int[] b= {1,5,3,9,12,10,7};
        System.out.println(a.length);
        System.out.println(VerifySquenceOfBST(a));
//        System.out.println(bst(b, 0, b.length-1));
    }
}

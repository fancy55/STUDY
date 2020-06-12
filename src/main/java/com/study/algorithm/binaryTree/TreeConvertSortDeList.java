package com.study.algorithm.binaryTree;

/*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。*/
//中序遍历，利用中间变量将彼此指针互相连接
public class TreeConvertSortDeList {
    TreeNode tmp;
    TreeNode head;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    public void inOrder(TreeNode pRootOfTree){
        if(pRootOfTree == null)return;
        inOrder(pRootOfTree.left);
        pRootOfTree.left = tmp;
        if(tmp != null)tmp.right=pRootOfTree; //利用tmp将彼此互相指向
        tmp=pRootOfTree;
        if(head == null)head=pRootOfTree;//递归到最深处才将头赋值，也就是双向链表的头
        inOrder(pRootOfTree.right);
    }
}

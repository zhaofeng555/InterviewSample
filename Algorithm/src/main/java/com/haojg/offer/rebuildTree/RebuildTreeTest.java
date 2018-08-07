package com.haojg.offer.rebuildTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 146477
 * @Date: 2018/8/1 11:23
 */
public class RebuildTreeTest {
    private Map<Integer, Integer> inOrderNumsIndexs = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++)
            inOrderNumsIndexs.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL, int inR) {
        if (preL > preR)
            return null;
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = inOrderNumsIndexs.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL, inL + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1, inR);
        return root;
    }

    public static void main(String[] args) {
        int []preorder = {3,9,20,15,7};
        int []inorder =  {9,3,15,20,7};

        TreeNode treeNode = new RebuildTreeTest().reConstructBinaryTree(preorder, inorder);
        System.out.println(treeNode.val);
    }
}
class  TreeNode{
    TreeNode left;
    TreeNode right;
    Integer val;
    public TreeNode(Integer val){
        this.val=val;
    }
}

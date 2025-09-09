package acmmode.input.tree;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1022
// 题目描述：
//  现给定一棵二叉树的先序遍历序列和中序遍历序列，要求你计算该二叉树的高度。
// 输入描述：
//  输入包含多组测试数据，每组输入首先给出正整数N（<=50），为树中结点总数。
//  下面2行先后给出先序和中序遍历序列，均是长度为N的不包含重复英文字母（区别大小写）的字符串。
// 输出描述：
//  对于每组输入，输出一个整数，即该二叉树的高度。

class TreeNode {
    public char val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(char val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeHeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionBTH solution = new SolutionBTH();

        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());

            String preOrder = in.nextLine();
            String inOrder = in.nextLine();

            TreeNode root = solution.buildTree(preOrder, inOrder);
            int height = solution.getHeight(root);
            System.out.println(height);
        }
    }
}

class SolutionBTH {

    public TreeNode buildTree(String preOrder, String inOrder) {
        Map<Character, Integer> inOrderMap = new HashMap<>();
        int n = inOrder.length();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inOrder.charAt(i), i);
        }
        return buildTree(preOrder.toCharArray(), inOrder.toCharArray(), inOrderMap, 0, n, 0, n);
    }

    public TreeNode buildTree(char[] preOrder, char[] inOrder, Map<Character, Integer> inOrderMap,
                              int preOrderLeft, int preOrderRight,
                              int inOrderLeft, int inOrderRight) {

        if (preOrderLeft == preOrderRight) {
            return null;
        }

        char rootVal = preOrder[preOrderLeft];
        TreeNode node = new TreeNode(rootVal);

        int rootIndex = inOrderMap.get(rootVal);
        int leftTreeSize = rootIndex - inOrderLeft;
        TreeNode leftTree = buildTree(preOrder, inOrder, inOrderMap,
                preOrderLeft+1, preOrderLeft+1+leftTreeSize,
                inOrderLeft, rootIndex);

        TreeNode rightTree = buildTree(preOrder, inOrder, inOrderMap,
                preOrderLeft+1+leftTreeSize, preOrderRight,
                rootIndex+1, inOrderRight);

        node.left = leftTree;
        node.right = rightTree;

        return node;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;

    }

}
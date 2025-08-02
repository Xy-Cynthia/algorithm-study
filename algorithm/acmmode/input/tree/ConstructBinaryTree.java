import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1020
// 题目描述：
//  给你一棵二叉树的前序遍历和中序遍历结果，要求你写出这棵二叉树的后序遍历结果。
// 输入描述：
//  输入包含多组测试数据。每组输入包含两个字符串，分别表示二叉树的前序遍历和中序遍历结果。每个字符串由不重复的大写字母组成。
// 输出描述：
//  对于每组输入，输出对应的二叉树的后续遍历结果。

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        while (in.hasNextLine()) {
            String[] input = in.nextLine().split("\\s+");
            char[] preorder = input[0].toCharArray();
            char[] inorder = input[1].toCharArray();

            TreeNode root = solution.buildTree(preorder, inorder);
            solution.dfsPostOrder(root);
            System.out.println();
        }

        in.close();
    }
}

class Solution {

    public void dfsPostOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsPostOrder(root.left);
        dfsPostOrder(root.right);
        System.out.print(root.val);
    }

    public TreeNode buildTree(char[] preorder, char[] inorder) {
        int n = inorder.length;
        Map<Character, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, inOrderMap, 0, n, 0, n);
    }

    // divided to inorder [left, right)
    private TreeNode buildTree(char[] preorder, char[] inorder, Map<Character, Integer> inOrderMap,
                               int preOrderLeft, int preOrderRight,
                               int inOrderLeft, int inOrderRight) {
        if (preOrderLeft == preOrderRight) {
            return null;
        }

        // preorder [root.val, <leftSubTree>, <rightSubTree>]
        // inorder [<leftSubTree>, root.val, <rightSubTree>]
        char rootVal = preorder[preOrderLeft];
        int rootIndex = inOrderMap.get(rootVal);
        int leftTreeSize = rootIndex - inOrderLeft;

        TreeNode leftNode = buildTree(preorder, inorder, inOrderMap,
                preOrderLeft+1, preOrderLeft+1+leftTreeSize,
                inOrderLeft, rootIndex);
        TreeNode rightNode = buildTree(preorder, inorder, inOrderMap,
                preOrderLeft+1+leftTreeSize, preOrderRight,
                rootIndex+1, inOrderRight);

        return new TreeNode(rootVal, leftNode, rightNode);

    }
}

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
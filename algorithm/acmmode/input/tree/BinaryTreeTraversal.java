package acmmode.input.tree;

import acmmode.input.tree.TreeNode;
import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1021
// 题目描述：
//  给出一个n个节点的二叉树，请求出二叉树的前序遍历，中序遍历和后序遍历。
// 输入描述：
//  题目包含多行输入，第一行为一个整数 N，表示二叉树的节点总数，后面将有 N 行对应于二叉树的 N 个节点的信息。
//  每行的数据格式遵循如下规则：
//      每行开始是该节点的标识符，代表二叉树中具体的一个节点。节点标识符之后是两个数字，分别表示该节点的左孩子和右孩子的序号。
//      序号根据输入顺序从 1 开始自动分配，即第一个输入的节点序号为 1，第二个为 2，以此类推。
//      若某个节点的左孩子或右孩子序号为 0，则表示该节点不存在相应的左孩子或右孩子。
// 输出描述：
//  共三行，第一行为二叉树的前序遍历，第二行为中序遍历，第三行为后序遍历

public class BinaryTreeTraversal {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SolutionBTT solution = new SolutionBTT();

        while (in.hasNextLine()) {
            int n = in.nextInt();
            in.nextLine();

            TreeNode[] nodes = new TreeNode[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new TreeNode('0');
            }

            for (int i = 0; i < n; i++) {
                String[] input = in.nextLine().split("\\s+");
                nodes[i].val = input[0].charAt(0);

                int leftIndex = Integer.parseInt(input[1]);
                int rightIndex = Integer.parseInt(input[2]);
                nodes[i].left = leftIndex == 0? null: nodes[leftIndex - 1];
                nodes[i].right = rightIndex == 0? null: nodes[rightIndex - 1];
            }

            TreeNode root = nodes[0];

            solution.preOrderTraversal(root);
            System.out.println();

            solution.inOrderTraversal(root);
            System.out.println();

            solution.postOrderTraversal(root);
            System.out.println();
        }

        in.close();

    }
}

class SolutionBTT {

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val);
    }



}
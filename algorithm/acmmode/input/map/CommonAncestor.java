import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1010
// 题目描述：
//  小明发现和小宇有共同祖先！现在小明想知道小宇是他的长辈，晚辈，还是兄弟
// 输入描述：
//  输入包含多组测试数据。每组首先输入一个整数N（N<=10），接下来N行，每行输入两个整数a和b，表示a的父亲是b（1<=a,b<=30）。
//  小明的编号为1，小宇的编号为2。输入数据保证每个人只有一个父亲。
// 输出描述：
//  对于每组输入，如果小宇是小明的晚辈，则输出“You are my younger”，
//  如果小宇是小明的长辈，则输出“You are my elder”，
//  如果是同辈则输出“You are my brother”。

public class CommonAncestor {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        while (in.hasNext()) {
            int n = in.nextInt();

            Map<Integer, Integer> parentMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int child = in.nextInt();
                int parent = in.nextInt();
                parentMap.put(child, parent);
            }

            int depth1 = solution.getDepth(1, parentMap);
            int depth2 = solution.getDepth(2, parentMap);

            if (depth1 == depth2) {
                System.out.println("You are my brother");
            } else if (depth1 > depth2) {
                System.out.println("You are my elder");
            } else {
                System.out.println("You are my younger");
            }

        }

    }
}

class Solution {

    public int getDepth(int child, Map<Integer, Integer> parentMap) {
        int depth = 0;
        while (parentMap.containsKey(child)) {
            depth++;
            child = parentMap.get(child);
        }
        return depth;
    }


}
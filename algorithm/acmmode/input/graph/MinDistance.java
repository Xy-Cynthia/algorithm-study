import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1024
// 题目描述：
//  一天小明捧着一本世界地图在看，突然小明拿起笔，将他最爱的那些城市标记出来，并且随机的将这些城市中的某些用线段两两连接起来。
//  小明量出了每条线段的长度，现在小明想知道在这些线段组成的图中任意两个城市之间的最短距离是多少。
// 输入描述：
//  输入包含多组测试数据。
//  每组输入第一行为两个正整数n（n<=10）和m（m<=n*(n-1)/2），n表示城市个数，m表示线段个数。
//  接下来m行，每行输入三个整数a，b和l，表示a市与b市之间存在一条线段，线段长度为l。（a与b不同）
//  每组最后一行输入两个整数x和y，表示问题：x市与y市之间的最短距离是多少。（x与y不同）
//  城市标号为1~n，l<=20。
// 输出描述：
//  对于每组输入，输出x市与y市之间的最短距离，如果x市与y市之间非连通，则输出“No path”。

public class MinDistance {

    public static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] graph = new int[n+1][n+1];

            // 初始化邻接矩阵
            for (int i = 1; i <= n; i++) {
                Arrays.fill(graph[i], INF);
                graph[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                int l = in.nextInt();
                graph[a][b] = Math.min(graph[a][b], l);
                graph[b][a] = Math.min(graph[b][a], l);
            }

            solution.floyd(graph);

            int x = in.nextInt();
            int y = in.nextInt();

            if (graph[x][y] == INF) {
                System.out.println("No path");
            } else {
                System.out.println(graph[x][y]);
            }

        }

        in.close();

    }
}

class Solution {

    // Floyd-Warshall算法的实现
    public void floyd(int[][] graph) {
        int n = graph.length;

        for (int k = 1; k < n; k++) { // 对于每一个顶点
            for (int i = 1; i < n; i++) { // 对于每一个起点
                for (int j = 1; j < n; j++) { // 对于每一个终点
                    // 如果通过顶点k的路径比原来的路径短，就更新
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

}
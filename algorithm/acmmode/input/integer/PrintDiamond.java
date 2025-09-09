package acmmode.input.integer;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1011
// 题目描述：
//  先要求你从键盘输入一个整数n（1<=n<=9），打印出指定的数字图形。
// 输入描述：
//  输入包含多组测试数据。每组输入一个整数n（1<=n<=9）。
// 输出描述：
//  对于每组输入，输出指定的数字图形。注意：每行最后一个数字后没有任何字符。

public class PrintDiamond {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionPD solution = new SolutionPD();

        while (in.hasNextInt()) {
            int n = in.nextInt();
            solution.printDiamond(n);
        }


    }
}


class SolutionPD {
    public void printDiamond(int n) {
        // 2 * n - 1 line
        // for line i < n: has (n - 1 - i) space, number = 1...i...1
        for (int i = 1; i < 2*n; i++) {
            int level = i <= n? i: 2*n - i;

            for (int j = 0; j < n-level; j++) {
                System.out.print(" ");
            }

            for (int k = 1; k <= level; k++) {
                System.out.print(k);
            }

            for (int k = level-1; k > 0; k--) {
                System.out.print(k);
            }

            System.out.print("\n");
        }
    }
}
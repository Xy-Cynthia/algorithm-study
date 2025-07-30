import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1005
// 题目描述：你的任务是计算若干整数的和
// 输入描述：输入的第一行为一个整数N，接下来N行每行先输入一个整数M，然后在同一行内输入M个整数。
// 输出描述：对于每组输入，输出M个数的和，每组输出之间输出一个空行。


public class PlusProblem4 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        while (in.hasNextInt()) {
            int lineCount = in.nextInt();

            for (int i = 0; i < lineCount; i++) {

                int numCount = in.nextInt();
                int sum = 0;
                for (int j = 0; j < numCount; j++) {
                    sum = solution.sumInt(sum, in.nextInt());
                }
                System.out.println(sum);

                if (i < lineCount - 1) {
                    System.out.println("");
                }
            }
        }
    }
}
}

class Solution {
    public int sumInt(int a, int b) {
        return a + b;
    }
}
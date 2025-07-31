import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1003
// 题目描述：你的任务是计算若干整数的和
// 输入描述：每行的第一个数N，表示本行后面有N个数。如果N=0时，表示输入结束，且这一行不要计算。
// 输出描述：对于每一行数据需要在相应的行输出和。


public class AddProblem4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        while (in.hasNextLine()) {

            int count = in.nextInt();
            if (count == 0) break;

            int sum = 0;
            for (int i = 0; i < count; i++) {
                sum = solution.sumInt(result, in.nextInt());
            }
            System.out.println(result);
        }

    }
}

class Solution {
    public int sumInt(int a, int b) {
        return a + b;
    }
}
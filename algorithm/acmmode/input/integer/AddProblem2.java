package acmmode.input.integer;

import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1001
// 题目描述：计算a+b，但输入方式有所改变。
// 输入描述：第一行是一个整数N，表示后面会有N行a和b，通过空格隔开。
// 输出描述：
//      对于输入的每对a和b，你需要依次输出a、b的和。
//      如对于输入中的第二对a和b，在输出中它们的和应该也在第二行。
// 提示信息：注意，测试数据不仅仅一组。也就是说，会持续输入N以及后面的a和b


public class AddProblem2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()) {
            int numlen = in.nextInt();

            for (int i = 0; i < numlen; i++) {
                int a = in.nextInt();
                int b = in.nextInt();

                int result = solution.sumInt(a, b);
                System.out.println(result);
            }
        }

    }
}

class Solution2 {
    public int sumInt(int a, int b) {
        return a + b;
    }
}
package acmmode.input.integer;

import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1004
// 题目描述：你的任务是计算若干整数的和
// 输入描述：输入包含若干行，每行输入两个整数a和b，由空格分隔。
// 输出描述：对于每组输入，输出a和b的和，每行输出后接一个空行。


public class AddProblem5 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Solution5 solution = new Solution5();

        while (in.hasNextLine()) {
            int a = in.nextInt();
            int b = in.nextInt();
            int sum = solution.sumInt(a, b);
            System.out.println(sum + "\n");
        }
    }
}

class Solution5 {
    public int sumInt(int a, int b) {
        return a + b;
    }
}
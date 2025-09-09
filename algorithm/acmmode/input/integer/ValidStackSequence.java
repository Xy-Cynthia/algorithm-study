package acmmode.input.integer;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1016
// 题目描述：
//  已知自然数1，2，...，N（1<=N<=100）依次入栈，请问序列C1，C2，...，CN是否为合法的出栈序列。
// 输入描述：
//  输入包含多组测试数据。每组测试数据的第一行为整数N（1<=N<=100），当N=0时，输入结束。
//  第二行为N个正整数，以空格隔开，为出栈序列。
// 输出描述：
//  对于每组输入，输出结果为一行字符串。如给出的序列是合法的出栈序列，则输出Yes，否则输出No。

public class ValidStackSequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionVSS solution = new SolutionVSS();

        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n == 0) break;

            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            String isValid = solution.isValidSequence(nums)? "Yes": "No";
            System.out.println(isValid);
        }
        in.close();
    }
}


class SolutionVSS {

    public boolean isValidSequence(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int candidate = 1;

        for (int i = 0; i < nums.length; i++) {

            // push
            while (stack.isEmpty() || stack.peek() < nums[i]) {
                stack.push(candidate++);
            }

            if (stack.peek() != nums[i]) {
                return false;
            } else {
                stack.pop();
            }

        }
        return true;
    }
}
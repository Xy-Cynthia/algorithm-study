package acmmode.input.integer;

import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1008
// 题目描述：
//  有一天, 小明收到一张奇怪的信, 信上要小明计算出给定数各个位上数字为偶数的和。
// 输入描述：
//  输入数据有多组。每组占一行，只有一个整整数，保证数字在32位整型范围内。
// 输出描述：
//  对于每组输入数据，输出一行，每组数据下方有一个空行。

public class WeirdLetter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionWL solution = new SolutionWL();

        while (in.hasNextInt()) {
            int num = in.nextInt();

            int evenSum = solution.sumEvenNumber(num);
            System.out.println(evenSum + "\n");
        }

    }
}

class SolutionWL {

    public int sumEvenNumber(int num) {
        int res = 0;

        while (num > 0) {
            int curr = num % 10;
            if (curr % 2 == 0) {
                res += curr;
            }
            num /= 10;
        }
        return res;

    }
}
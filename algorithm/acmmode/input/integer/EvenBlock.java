package acmmode.input.integer;

import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1007
// 题目描述：
//  小明很喜欢玩积木。一天，他把许多积木块组成了好多高度不同的堆，每一堆都是一个摞一个的形式。
//  然而此时，他又想把这些积木堆变成高度相同的。但是他很懒，他想移动最少的积木块来实现这一目标.
// 输入描述：
//  输入包含多组测试样例。每组测试样例包含一个正整数n，表示小明已经堆好的积木堆的个数。
//  接着下一行是n个正整数，表示每一个积木堆的高度h，每块积木高度为1。其中1<=n<=50,1<=h<=100。
//  测试数据保证积木总数能被积木堆数整除。
//  当n=0时，输入结束。
// 输出描述：
//  对于每一组数据，输出将积木堆变成相同高度需要移动的最少积木块的数量。
//  在每组输出结果的下面都输出一个空行


public class EvenBlock {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            int n = in.nextInt();
            if (n == 0) {
                break;
            }

            int[] nums = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
                sum += nums[i];
            }
            int avg = sum / n;

            int movingCount = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > avg) {
                    movingCount += nums[i] - avg;
                }
            }
            System.out.println(movingCount + "\n");
        }

    }
}
package acmmode.input.integer;

import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1009
// 题目描述：
//  小明每天的话费是1元，运营商做活动，手机每充值K元就可以获赠1元话费，一开始小明充值M元，问最多可以用多少天？
//  注意赠送的话费也可以参与到奖励规则中
// 输入描述：
//  输入包括多个测试实例。每个测试实例包括2个整数M，K（2<=k<=M<=1000)。M=0，K=0代表输入结束。
// 输出描述：
//  对于每个测试实例输出一个整数，表示M元可以用的天数。

public class TelecomPromotion {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SolutionTP solution = new SolutionTP();

        while (in.hasNextLine()) {
            int m = in.nextInt();
            int k = in.nextInt();

            if (m == 0 && k == 0) break;

            int usage = solution.getUsage(m, k);
            System.out.println(usage);
        }

    }
}

class SolutionTP {
    public int getUsage(int money, int k) {
        int sum = money;
        while (money >= k) {
            int extra = money / k;
            sum += extra;
            money = extra + money % k;
        }
        return sum;
    }
}
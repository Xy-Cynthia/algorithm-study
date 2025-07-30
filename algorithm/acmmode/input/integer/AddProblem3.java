import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1002
// 题目描述：计算a+b，但输入方式有所改变。
// 输入描述：输入中每行是一对a和b。其中会有一对是0和0标志着输入结束，且这一对不要计算。
// 输出描述：
//      对于输入的每对a和b，你需要依次输出a、b的和。
//      如对于输入中的第二对a和b，在输出中它们的和应该也在第二行。


public class PlusProblem3 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner in = new Scanner(Sytem.in);

        while (in.hasNextLine()) {
            int a = in.nextInt();
            int b = in.nextInt();

            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(solution.sumInt(a, b));
        }

    }
}

class Solution {
    public int sumInt(int a, int b) {
        return a + b;
    }
}
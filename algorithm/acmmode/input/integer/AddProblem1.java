import java.util.Scanner;

// problem: https://kamacoder.com/problempage.php?pid=1000
// 题目描述：你的任务是计算a+b。
// 输入描述：输入包含一系列的a和b对，通过空格隔开。一对a和b占一行。
// 输出描述：
//      对于输入的每对a和b，你需要依次输出a、b的和。
//      如对于输入中的第二对a和b，在输出中它们的和应该也在第二行。


public class PlusProblem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
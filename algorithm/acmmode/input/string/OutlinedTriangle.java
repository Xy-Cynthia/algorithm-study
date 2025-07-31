import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1012
// 题目描述：
//  把一个字符三角形掏空，就能节省材料成本，减轻重量，但关键是为了追求另一种视觉效果。
//  在设计的过程中，需要给出各种花纹的材料和大小尺寸的三角形样板，通过电脑临时做出来，以便看看效果。
// 输入描述：
//  每行包含一个字符和一个整数n(0<n<41)，不同的字符表示不同的花纹，整数n表示等腰三角形的高。显然其底边长为2n-1。
//  如果遇到@字符，则表示所做出来的样板三角形已经够了。
// 输出描述：
//  每个样板三角形之间应空上一行，三角形的中间为空。行末没有多余的空格。每条结果后需要再多输出一个空行。

public class OutlinedTriangle {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        while (in.hasNextLine()) {
            String s = in.next();
            if (s.equals("@")) break;

            int n = in.nextInt();
            solution.printTriangle(s, n);

        }


    }
}

class Solution {

    public void printTriangle(String s, int n) {
        // n - i spaces, X, 2*(i-1) - 1 Spaces, X

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.print(s);

            if (i > 1) {
                for (int k = 0; k < 2 * (i-1) - 1; k++) {
                    System.out.print(" ");
                }
                System.out.print(s);
            }
            System.out.print("\n");
        }

        for (int i = 1; i < 2*n; i++) {
            System.out.print(s);
        }
        System.out.print("\n\n");


    }
}
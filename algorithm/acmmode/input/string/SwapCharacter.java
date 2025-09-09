package acmmode.input.string;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1015
// 题目描述：
//  给定一个长度为偶数位的字符串，请编程实现字符串的奇偶位互换。
// 输入描述：
//  输入包含多组测试数据。
//  输入的第一行是一个整数n，表示有测试数据。（整个输入中，只有一个n）
//  接下来是n组测试数据，保证串长为偶数位(串长<=50)。
// 输出描述：
//  请为每组测试数据输出奇偶位互换后的结果，每组输出占一行。

public class SwapCharacter {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionSC solution = new SolutionSC();

        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            while (n > 0) {
                String s = in.nextLine();
                System.out.println(solution.swap(s));
                n--;
            }
        }
    }
}

class SolutionSC {

    public String swap(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        for (int i = 0; i < n/2; i++) {
            char tmp = chars[i*2];
            chars[i*2] = chars[i*2+1];
            chars[i*2+1] = tmp;
        }
        return new String(chars);
    }
}
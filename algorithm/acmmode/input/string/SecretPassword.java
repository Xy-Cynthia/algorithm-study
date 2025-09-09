package acmmode.input.string;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1014
// 题目描述：
//  考古学家发现墓碑上有神秘的字符。经过仔细研究，发现原来这是开启古墓入口的方法。
//  墓碑上有2行字符串，其中第一个串的长度为偶数，现在要求把第2个串插入到第一个串的正中央，如此便能开启墓碑进入墓中。
// 输入描述：
//  输入数据首先给出一个整数n，表示测试数据的组数。（整个输入中，只有一个n）
//  然后是n组数据，每组数据2行，每行一个字符串，长度大于0，小于50，并且第一个串的长度必为偶数。
// 输出描述：
//  请为每组数据输出一个能开启古墓的字符串，每组输出占一行。


public class SecretPassword {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionSP solution = new SolutionSP();

        while (in.hasNext()) {
            int n = Integer.parseInt(in.nextLine());

            while (n > 0) {
                String s1 = in.nextLine();
                String s2 = in.nextLine();

                System.out.println(solution.buildPassword(s1, s2));
                n--;
            }
        }
        in.close();
    }
}

class SolutionSP {

    public String buildPassword(String s1, String s2) {
        int n = s1.length();

        return s1.substring(0, n/2) + s2 + s1.substring(n/2, n);
    }
}
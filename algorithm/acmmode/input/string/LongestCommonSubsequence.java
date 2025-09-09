package acmmode.input.string;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1023
// 题目描述：
//  给你一个序列X和另一个序列Z，当Z中的所有元素都在X中存在，并且在X中的下标顺序是严格递增的，那么就把Z叫做X的子序列。
//  例如：Z=是序列X=的一个子序列，Z中的元素在X中的下标序列为<1,2,4,6>。
//  现给你两个序列X和Y，请问它们的最长公共子序列的长度是多少？
// 输入描述：
//  输入包含多组测试数据。每组输入占一行，为两个字符串，由若干个空格分隔。每个字符串的长度不超过100。
// 输出描述：
//  对于每组输入，输出两个字符串的最长公共子序列的长度。

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionLCS solution = new SolutionLCS();

        while (in.hasNextLine()) {
            String[] input = in.nextLine().split("\\s+");
            System.out.println(solution.longestCommonSubsequence(input[0], input[1]));
        }
    }
}

class SolutionLCS {

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];

        // if s1[i-1] == s2[j-1]:
        //  dp[i][j] = dp[i-1][j-1] + 1
        // else
        //  dp[i][j] = max(dp[i][j-1], dp[i-1][j])

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = 0;
            for (int j = 1; j < m+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        return dp[n][m];

    }
}
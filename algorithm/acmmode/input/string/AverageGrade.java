package acmmode.input.string;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1006
// 题目描述：每门课的成绩分为A、B、C、D、F五个等级，为了计算平均绩点，规定A、B、C、D、F分别代表4分、3分、2分、1分、0分。
// 输入描述：有多组测试样例。每组输入数据占一行，由一个或多个大写字母组成，字母之间由空格分隔。
// 输出描述：每组输出结果占一行。如果输入的大写字母都在集合｛A,B,C,D,F｝中，则输出对应的平均绩点，结果保留两位小数。否则，输出“Unknown”。


public class AverageGrade {

    public static void main(String[] args) {
        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A", 4.0);
        gradeMap.put("B", 3.0);
        gradeMap.put("C", 2.0);
        gradeMap.put("D", 1.0);
        gradeMap.put("F", 0.0);

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] s = in.nextLine().split(" ");
            double score = 0.0;
            boolean isValid = true;

            for (int i = 0; i < s.length; i++) {
                if (!gradeMap.containsKey(s[i])) {
                    isValid = false;
                    break;
                }
                score += gradeMap.get(s[i]);
            }

            if (isValid) {
                System.out.println(String.format("%.2f", score / s.length));
            } else {
                System.out.println("Unknown");
            }

        }
    }
}
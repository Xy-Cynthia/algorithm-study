import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1013
// 题目描述：
//  输出一个词组中每个单词的首字母的大写组合。
// 输入描述：
//  输入的第一行是一个整数n，表示一共有n组测试数据。（输入只有一个n，没有多组n的输入）
//  接下来有n行，每组测试数据占一行，每行有一个词组，每个词组由一个或多个单词组成；
//  每组的单词个数不超过10个，每个单词有一个或多个大写或小写字母组成；
//  单词长度不超过10，由一个或多个空格分隔这些单词。
// 输出描述：
//  请为每组测试数据输出规定的缩写，每组输出占一行。

public class SentenceAbbreviation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();
            //Scanner类的nextInt()方法会读取输入中的一个整数，但它只会读取整数值，而不会读取换行符。
            //当你调用nextInt()后，输入缓冲区中的整数被读取，但换行符仍然留在缓冲区中。
            in.nextLine();

            for (int i = 0; i < n; i++) {
                String abbr = "";
                String line = in.nextLine();
                String[] words = line.split("\\s+");
                for (String word: words) {
                    if (!word.isEmpty()) {
                        abbr += String.valueOf(word.charAt(0)).toUpperCase();
                    }
                }
                System.out.println(abbr);
            }

        }
        in.close();
    }
}

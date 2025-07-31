## Get Input from Scanner utils

```java
import com.sun.org.apache.xpath.internal.NodeSet;
import com.sun.org.apache.xpath.internal.patterns.NodeTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) { // handle the next line

            boolean hasNext = in.hasNextInt(); // check the next int
            int a = in.nextInt(); // get the next int
        }
        
        while (in.hasNextLine()) {
            String s = in.nextLine();
        }

    }
}

```


### Notes
- 使用 `nextInt()` 和 `hasNextLine()` 的组合可能导致错误： 
  - `hasNextLine()` 检查是否有新的输入行可用，但它并不消费行结尾的换行符。
  - 如果在读取了一个整数后，行上还有其他内容（如空白或其他数字），那么 nextInt() 不会读取换行符，导致下一次循环的 hasNextLine() 立即返回 true，
  - 然后 nextInt() 可能因为读取空行而引发 InputMismatchException 或 NoSuchElementException。

## Testing Command

```shell
javac AddProblem1.java
java AddProblem
# then input the testing data in the next line
```
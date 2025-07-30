## Get Input from Scanner utils

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner in = new Scanner(System.in);
        
        while (in.hasNextLine()) { // handle the next line
            boolean hasNext = in.hasNextInt(); // check the next int
            int a = in.nextInt(); // get the next int
        }

    }
}


```

## Testing Command

```shell
javac AddProblem1.java
java PlusProblem
# then input the testing data in the next line
```
package acmmode.input.list;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1017
// 题目描述：
//  本题考察链表的基本操作
// 输入描述：
//  输入数据只有一组，第一行有n+1个整数，第一个整数是这行余下的整数数目n，后面是n个整数。
//  这一行整数是用来初始化列表的，并且输入的顺序与列表中的顺序相反，也就是说如果列表中是1、2、3那么输入的顺序是3、2、1。
//  第二行有一个整数m，代表下面还有m行。每行有一个字符串，字符串是“get”，“insert”，“delete”，“show”中的一种。
//
//  如果是“get”，代表获得第a个元素。（a从1开始计数）
//  如果是“delete”，代表删除第a个元素。（a从1开始计数）
//  如果是“insert”，则其后跟着两个整数a和e，代表在第a个位置前面插入e。（a从1开始计数）
//  “show”之后没有正数，直接打印链表全部内容。
// 输出描述：
//  如果获取成功，则输出该元素；
//  如果删除成功，则输出“delete OK”；
//  如果获取失败，则输出“get fail”
//  如果删除失败，则输出“delete fail”
//  如果插入成功，则输出“insert OK”，否则输出“insert fail”。
//  如果是“show”，则输出列表中的所有元素，如果列表是空的，则输出“Link list is empty”
//  注：所有的双引号均不输出。

public class LinkedListOperation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();

        if (in.hasNextLine()) {
            int n = in.nextInt();
            ListNode dummy = new ListNode(0);

            while (n > 0) {
                int num = in.nextInt();
                ListNode curr = new ListNode(num);
                curr.next = dummy.next;
                dummy.next = curr;
                n--;
            }
            in.nextLine();

            int m = in.nextInt();
            in.nextLine();
            while (m > 0) {
                String line = in.nextLine();
                String[] command = line.split("\\s+");

                String op = command[0];
                switch (op) {
                    case "show":
                        solution.show(dummy);
                        break;
                    case "delete":
                        solution.delete(dummy, Integer.parseInt(command[1]));
                        break;
                    case "insert":
                        solution.insert(dummy, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                        break;
                    case "get":
                        solution.get(dummy, Integer.parseInt(command[1]));
                        break;
                }
                m--;
            }
        }

        in.close();
    }
}

class Solution {

    public void show(ListNode dummy) {
        ListNode curr = dummy.next;
        if (curr == null) {
            System.out.println("Link list is empty");
            return;
        }

        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;
            if (curr != null) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public void delete(ListNode dummy, int location) {
        boolean isSuccess = false;
        ListNode prev = getLocation(dummy, location-1);

        if (prev != null && prev.next != null) {
            prev.next = prev.next.next;
            isSuccess = true;
        }

        if (isSuccess) {
            System.out.println("delete OK");
        } else {
            System.out.println("delete fail");
        }
    }

    public void insert(ListNode dummy, int location, int value) {
        boolean isSuccess = false;
        ListNode prev = getLocation(dummy, location-1);

        if (prev != null) {
            ListNode curr = new ListNode(value);
            curr.next = prev.next;
            prev.next = curr;
            isSuccess = true;
        }

        if (isSuccess) {
            System.out.println("insert OK");
        } else {
            System.out.println("insert fail");
        }

    }

    public void get(ListNode dummy, int location) {
        ListNode curr = getLocation(dummy, location);

        if (curr != null) {
            System.out.println(curr.val);
        } else {
            System.out.println("get fail");
        }

    }

    private ListNode getLocation(ListNode dummy, int location) {
        ListNode curr = dummy;

        while (curr != null && location > 0) {
            curr = curr.next;
            location--;
        }

        return curr;
    }

}


class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
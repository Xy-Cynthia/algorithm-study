package acmmode.input.list;

import acmmode.input.list.ListNode;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1018
// 题目描述：
//  根据一个整数序列构造一个单链表，然后将其反转。例如：原单链表为 2 3 4 5 ，反转之后为5 4 3 2.
// 输入描述：
//  输入包括多组测试数据，每组测试数据占一行，第一个为大于等于0的整数n，表示该单链表的长度，
//  后面跟着n个整数，表示链表的每一个元素。整数之间用空格隔开
// 输出描述：
//  针对每组测试数据，输出包括两行，分别是反转前和反转后的链表元素，用空格隔开
//  如果链表为空，则只输出一行，list is empty

public class RevertLinkedList {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        SolutionRLL solution = new SolutionRLL();

        while (in.hasNextInt()) {
            int n = in.nextInt();

            if (n == 0) {
                System.out.println("list is empty");
                continue;
            }

            ListNode head = null, tail = null;
            while (n > 0) {
                int num = in.nextInt();
                ListNode curr = new ListNode(num);
                if (head == null) {
                    head = curr;
                    tail = curr;
                } else {
                    tail.next = curr;
                    tail = curr;
                }
                n--;
            }

            solution.show(head);
            head = solution.revertList(head);
            solution.show(head);
        }

        in.close();

    }
}

class SolutionRLL {

    public ListNode revertList(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void show(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val);
            curr = curr.next;

            if (curr != null) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}

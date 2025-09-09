package acmmode.input.list;

import acmmode.input.list.ListNode;

import java.util.*;

// problem: https://kamacoder.com/problempage.php?pid=1019
// 题目描述：
//  根据一个递增的整数序列构造有序单链表，删除其中的重复元素
// 输入描述：
//  输入包括多组测试数据，每组测试数据占一行，第一个为大于等于0的整数n，表示该单链表的长度，
//  后面跟着n个整数，表示链表的每一个元素。整数之间用空格隔开
// 输出描述：
//  针对每组测试数据，输出包括两行，分别是反转前和反转后的链表元素，用空格隔开
//  如果链表为空，则只输出一行，list is empty

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SolutionRD solution = new SolutionRD();

        while (in.hasNextInt()) {
            int n = in.nextInt();

            if (n == 0) {
                System.out.println("list is empty");
                continue;
            }

            ListNode head = null, tail = null;
            while (n > 0) {
                ListNode curr = new ListNode(in.nextInt());
                if (head == null) {
                    head = curr;
                    tail = curr;
                } else {
                    tail.next = curr;
                    tail = curr;
                }
                n--;
            }

            solution.print(head);
            solution.removeDuplicate(head);
            solution.print(head);

        }

        in.close();


    }
}

class SolutionRD {

    public void print(ListNode head) {
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

    public void removeDuplicate(ListNode head) {
        ListNode curr = head, next = null;

        while (curr.next != null) {
            next = curr.next;
            if (curr.val == next.val) {
                curr.next = next.next;
            } else {
                curr = curr.next;
            }
        }
    }

}
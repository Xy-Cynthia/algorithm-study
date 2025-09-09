package sort;

import java.util.*;

public class QuickSort {

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("排序前: " + Arrays.toString(data));
        quickSort(data, 0, data.length - 1);
        System.out.println("排序后: " + Arrays.toString(data));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 快速排序
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return; // 递归结束条件

        // pivot 选择中间元素
        int mid = left + (right - left) / 2;
        int pivot = arr[mid];

        // partition
        int i = left, j = right;
        while (i <= j) {
            // 找到左边第一个 >= pivot 的
            while (arr[i] < pivot) i++;
            // 找到右边第一个 <= pivot 的
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        } // 退出时 j < i


        // 递归左右两边
        if (left < j) quickSort(arr, left, j);
        if (i < right) quickSort(arr, i, right);
    }
}
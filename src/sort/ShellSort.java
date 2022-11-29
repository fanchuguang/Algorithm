package sort;

import static sort.utils.ArrayUtils.swap;

/**
 * 希尔排序
 * 实质就是分组进行插入排序【因为分组排序了，导致不稳定】
 * 空间复杂度 O(1)
 * 时间复杂度最坏 O(N^2)
 * 时间复杂度最好 O(N^1.3)
 *
 * @Created by chuguang.fan
 * @Description
 * @Date 2022/11/28 15:40
 */
public class ShellSort {

    public static void main(String[] args) {
        sort(new int[]{169, 112, 162, 81});
    }

    public static void sort(int[] arr) {
        int gap = arr.length / 2;

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > arr[preIndex + gap]) {
                    swap(arr, preIndex, preIndex + gap);
                    preIndex -= gap;
                }
            }

            gap /= 2;
        }
    }
}

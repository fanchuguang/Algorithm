package sort;

import static sort.utils.ArrayUtils.swap;

/**
 * @Created by chuguang.fan
 * @Description 选择排序 不稳定 时间复杂度O(n^2)
 * @Date 2022/11/28 15:25
 */
public class SelectSort {

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                swap(arr,i,minIndex);
            }
        }
    }

}

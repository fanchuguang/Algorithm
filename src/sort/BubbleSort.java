package sort;

import sort.utils.ArrayUtils;

/**
 * @Created by chuguang.fan
 * @Description 冒泡排序
 * @Date 2022/11/25 12:15
 */
public class BubbleSort {

    public static void sort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    ArrayUtils.swap(arr,j,j+1);
                }
            }
        }
    }
}

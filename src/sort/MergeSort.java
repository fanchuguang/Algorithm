package sort;

import java.util.Arrays;

/**
 * @Created by chuguang.fan
 * @Description 合并排序
 * @Date 2022/11/29 15:20
 */
public class MergeSort {

    public static int[] sort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr,0,arr.length/2);
        int[] right = Arrays.copyOfRange(arr,arr.length/2,arr.length);
        return merge(sort(left),sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        for (int i = 0,leftIndex = 0, rightIndex = 0; i < result.length; i++) {
            if (leftIndex >= left.length){
                result[i] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                result[i] = left[leftIndex++];
            }else if (left[leftIndex] > right[rightIndex]){
                result[i] = right[rightIndex++];
            }else{
                result[i] = left[leftIndex++];
            }
        }

        return result;
    }

}

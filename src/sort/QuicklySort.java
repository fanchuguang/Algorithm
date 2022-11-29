package sort;

import java.util.Arrays;

import static sort.utils.ArrayUtils.swap;

/**
 * 快速排序
 * 不稳定
 * 时间复杂度 O(log2n)
 * 空间复杂度 O(log2n)
 *
 * @Created by chuguang.fan
 * @Description 快速排序
 * @Date 2022/11/28 17:07
 */
public class QuicklySort {

    public static void main(String[] args) {
        sort(new int[]{111, 42, 192, 64});
    }
    public static void sort(int[] arr){
        quicklySort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicklySort(int[] arr, int start, int end) {
        //TODO start = end 进行过滤
        if (start >= end || start < 0 || end >= arr.length){
            return;
        }
        int pivot = pivotMid(arr,start,end);

        quicklySort(arr,start,pivot-1);
        quicklySort(arr,pivot+1,end);
    }

    private static int pivotMid(int[] arr, int start, int end) {
        //TODO 注意这里需要把start作为基数
        int randomIndex = start + (int)(Math.random()* (end - start + 1));
        swap(arr,randomIndex,end);

        //TODO 注意这里游标的理解
        int pivotMid = start;

        for (int i = start; i < end; i++) {
            if (arr[i] <= arr[end]){
                if (pivotMid < i){
                    swap(arr,pivotMid,i);
                }
                pivotMid++;
            }
        }

        swap(arr,pivotMid,end);
        return pivotMid;
    }
}

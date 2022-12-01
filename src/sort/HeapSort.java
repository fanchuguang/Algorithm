package sort;

import java.util.Arrays;

import static sort.utils.ArrayUtils.swap;

/**
 * @Created by chuguang.fan
 * @Description 堆排序
 * @Date 2022/11/30 16:23
 */
public class HeapSort {

    public static void main(String[] args) {
        sort(new int[]{2,3,5651,1,34,45,6567,87,84,324,56,43});
    }

    public static void sort(int[] arr){
        buildMaxHeap(arr);

        int len = arr.length;
        while(len > 0){
            swap(arr,0,len-1);

            adjustHeap(arr,0,len-1);

            len--;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
    }

    /**
     * 向下调整堆顶
     * @param arr
     * @param head
     * @param len
     */
    private static void adjustHeap(int[] arr, int head, int len) {
        //没有左右孩子
        if ((head * 2) + 1 >= len && (head * 2) + 2 >= len){
            return;
        }
        //定义最大的maxValueIndex
        int maxValueIndex = head;

        //判断 end与左右孩子谁最大
        if((head * 2) + 1 < len && arr[(head * 2) + 1] > arr[maxValueIndex]){
            //左孩子
            maxValueIndex = (head * 2) + 1;
        }
        if((head * 2) + 2 < len && arr[(head * 2) + 2] > arr[maxValueIndex]){
            //右孩子
            maxValueIndex = (head * 2) + 2;
        }
        //如果maxValueIndex != head
            //继续调整
        if (maxValueIndex != head){
            swap(arr,maxValueIndex,head);
            adjustHeap(arr,maxValueIndex,len);
        }
    }

}

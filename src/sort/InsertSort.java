package sort;

/**
 * @Created by chuguang.fan
 * @Description 插入排序
 * @Date 2022/11/28 15:11
 */
public class InsertSort {

    public static void sort(int[] arr){


        for (int i = 1; i < arr.length; i++) {
            int swapVar = arr[i];
            int preIndex = i-1;
            while (preIndex >= 0 && arr[preIndex] > swapVar){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = swapVar;
        }
    }
}

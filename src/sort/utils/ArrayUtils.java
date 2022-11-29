package sort.utils;

/**
 * @Created by chuguang.fan
 * @Description 数组工具类
 * @Date 2022/11/25 11:56
 */
public class ArrayUtils {

    public static void swap(int[] arr, int a, int b){
        if( a== b || arr[a] == arr[b]){
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}

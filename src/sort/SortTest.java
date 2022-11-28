package sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Created by chuguang.fan
 * @Description 排序测试执行
 * @Date 2022/11/25 11:56
 */
public class SortTest {

    public static void main(String[] args) {
        int[] positiveArr = randomArr(true, 100);
        int[] negativeArr = randomArr(false, 100);

        int[] resultArr = Arrays.copyOfRange(negativeArr,0,100);

        BubbleSort.sort(resultArr);

        Arrays.sort(negativeArr);
        checkSort(resultArr,negativeArr);
    }


    //对数器
    public static void checkSort(int[] arr,int[] targetArr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != targetArr[i]){
                System.out.println("------------------------------------------------");
                System.out.println("-----------------排序失败！！！！------------------");
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(targetArr));

        System.out.println("------------------------------------------------");
    }


    public static int[] randomArr(boolean negative,int len){
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            if (negative) {
                //负数
                arr[i] = new Random().nextInt(200) - 100;
            }else {
                arr[i] = new Random().nextInt(200);
            }
        }
        
        return arr;
    }
}

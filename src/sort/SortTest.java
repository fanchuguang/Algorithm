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
        for (int i = 0; i < 200; i++) {
            doFetchTest();
        }
    }

    private static void doFetchTest() {
        int[] positiveArr = randomArr(true, 100);
        int[] negativeArr = randomArr(false, 4);

        int[] resultArr1 = Arrays.copyOfRange(negativeArr,0,4);
        int[] resultArr = Arrays.copyOfRange(negativeArr,0,4);

//        BubbleSort.sort(resultArr);
//        InsertSort.sort(resultArr);
//        SelectSort.sort(resultArr);
        QuicklySort.sort(resultArr);

        Arrays.sort(negativeArr);
        try {
            checkSort(resultArr,negativeArr);
        } catch (Exception e) {
            System.out.println("排序源:"+Arrays.toString(resultArr1));
            System.out.println("排序结果:"+Arrays.toString(resultArr));
        }
    }


    //对数器
    public static void checkSort(int[] arr,int[] targetArr) throws Exception{
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != targetArr[i]){
                throw new Exception("排序失败");
            }
        }
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

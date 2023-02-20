package algorithm.kmp;

import java.util.Arrays;

/**
 * @Created by chuguang.fan
 * @Description KMP 算法，给出A、B字符串，判断B是否为A的字串
 * @Date 2022/11/30 10:20
 */
public class KmpMatch {


    public static void main(String[] args) {
        String str = "abababaaab";
        System.out.println(" "+Arrays.toString(str.toCharArray()));
        System.out.println(Arrays.toString(getNextArray(str.toCharArray())));
        System.out.println(Arrays.toString(getnext(str)));
        System.out.println(Arrays.toString(getNext2(str.toCharArray())));
        System.out.println(KMP( str,"baa"));
        System.out.println(kmp("baa", str));
        System.out.println(KMP2( str,"baa"));
    }

    public static int[] getNextArray(char[] str2){
        if(str2.length == 1){
            return new int[] {-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        //i代表数组开始的位置
        int i = 2;
        //cn代表匹配长度
        int cn = 0;
        while(i<next.length){
            //如果相等，则下一个字符的匹配长度加一
            if(str2[i-1] == str2[cn]){
                next[i++] = ++cn;
                //如果不相等，则此时使得匹配长度变成cn处的匹配长度值，
                //然后重复整个while循环，再进行判断，此时i的值不会改变，
                //会一直进行判断，直到最后cn=0的时候让匹配长度为0，进行下一个判断。
            }else if(cn>0){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }
        return next;
    }


    public static int[] getnext(String ts)
    {
        int[] next = new int[ts.length()];
        char[] t = ts.toCharArray();
        int j=0,k=-1;
        next[0]=-1;
        while(j<t.length-1)
        {
            if(k == -1 || t[j] == t[k])
            {
                j++;k++;
                next[j] = k;
            }
            else k = next[k];//此语句是这段代码最反人类的地方，如果你一下子就能看懂，那么请允许我称呼你一声大神！
        }
        return next;
    }


    public static int KMP(String bigStr,String matchStr)
    {
        char[] t = matchStr.toCharArray();
        char[] s = bigStr.toCharArray();
        int[] next = getnext(matchStr);
        int bigStrIndex=0, matchStrIndex=0;

        while(bigStrIndex<s.length&&matchStrIndex<t.length)
        {
            if(matchStrIndex==-1 || s[bigStrIndex]==t[matchStrIndex])
            {
                bigStrIndex++;
                matchStrIndex++;
            }
            else matchStrIndex=next[matchStrIndex];               //j回退。。。
        }
        if(matchStrIndex>=t.length)
            return (bigStrIndex-t.length);         //匹配成功，返回子串的位置
        else
            return (-1);                  //没找到
    }

    /**
     * 手写第一版
     * @param arr
     * @return
     */
    public static int[] getNext1(char[] arr){
        int[] res = new int[arr.length];
        res[0] = -1;
        int index = 1;

        while (index < arr.length) {
            if (res[index - 1] <= 0){
                if (arr[index - 1] == arr[0]) {
                    res[index] = res[index - 1] + 1;
                }else {
                    res[index] = 0;
                }
            }else {
                if (arr[index - 1] == arr[res[index - 1]]){
                    res[index] = res[index - 1] + 1;
                } else if (arr[index - 1] == arr[0]) {
                    res[index] = 1;
                }
            }
            index++;
        }

        return res;
    }

    public static int[] getNext2(char[] arr){
        int[] res = new int[arr.length];
        //len有两个含义:
        //1.此元素之前的长度
        //2.子串下一个字符匹配的元素下标
        int len = -1;
        int index = 0;
        res[0] = -1;

        while (index < arr.length - 1){
            if (len == -1 || arr[index] == arr[len]){
                res[++index] = ++len;
            }else{
                len = res[len];
            }
        }
        return res;
    }

    public static int kmp(String subStr,String mainStr){
        char[] subArr = subStr.toCharArray();
        char[] mainArr = mainStr.toCharArray();
        int[] subNextArr = getNext2(subArr);
        int i = 0, j = 0;
        while ( i < mainArr.length && j < subArr.length) {
            if (j == -1 || mainArr[i] == subArr[j]){
                j++;
                i++;
            }else {
                j = subNextArr[j];
            }
        }

        if (j >= subArr.length){
            return i - subArr.length;
        }else {
            return -1;
        }
    }

    public static int[] getNext3(char[] arr){
        int[] next = new int[arr.length];

        int len = -1;
        next[0] = len;
        int index = 0;

        while (index < arr.length - 1){

            //当前的字符 和 前字符串的 是否相等
            //相等 = +1
            //不相等 = 直接等于前字符串的下一个位置的值

            if (len == -1 || arr[len] == arr[index]){
                next[++index] = ++len;
            }else {
                len = next[len];
            }

            index ++;
        }

        return next;
    }


    public static int[] next4(char[] arr){
        int[] res = new int[arr.length];
        int len = -1;
        res[0] = len;
        int index = 0;

        while (index < arr.length - 1){
            if (len == -1 || arr[index] == arr[len]){
                res[++index] = ++len;
            }else {
                len = res[len];
            }
        }

        return res;
    }


    public static int KMP2(String longStr,String keyward){
        char[] longStrChars = longStr.toCharArray();
        char[] keywardChars = keyward.toCharArray();
        int[] keywardNexts = next4(keywardChars);
        int keywardIndex = 0, longStrIndex = 0;

        while (keywardIndex < keyward.length() && longStrIndex < longStr.length()){
            if (keywardIndex == -1 || longStrChars[longStrIndex] == keywardChars[keywardIndex]){
                longStrIndex++;
                keywardIndex++;
            }else {
                keywardIndex = keywardNexts[keywardIndex];
            }
        }

        if (keywardIndex >= keyward.length()){
            return longStrIndex - keyward.length();
        }else {
            return -1;
        }
    }
}

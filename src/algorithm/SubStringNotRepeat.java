package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class SubStringNotRepeat {

    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(Solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(Solution.lengthOfLongestSubstring("sdafasdfjjdssafsafawwf"));
        System.out.println(Solution.lengthOfLongestSubstring(" "));
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int maxLen = 0;
            Map<Character,Integer> uniqueCharMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                if (!uniqueCharMap.containsKey(chars[i])){
                    uniqueCharMap.put(chars[i],i);
                }else {
                    maxLen = Math.max(maxLen,uniqueCharMap.size());
                    i = uniqueCharMap.get(chars[i]);
                    uniqueCharMap.clear();
                }
            }
            return Math.max(maxLen,uniqueCharMap.size());
        }



    }









}

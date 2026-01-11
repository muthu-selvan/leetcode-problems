package org.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> visiterCharSet = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            while (visiterCharSet.contains(s.charAt(right))) {
                visiterCharSet.remove(s.charAt(left));
                left++;
            }

            visiterCharSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));
    }
}

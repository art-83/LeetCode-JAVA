package com.leetcode.solution.difficulty;

public class Medium {
    // 5. LongestSubString
    public String longestPalindromeNotAccepted(String s) {
        int maxStringLength = 0;
        String maxString = null;

        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                str.append(s.charAt(j));
                if(isPalindrome(str.toString())) {
                    if(str.toString().length() > maxStringLength) {
                        maxStringLength = str.length();
                        maxString = str.toString();
                    }
                }
            }
            str.setLength(0);
        }
        return maxString;
    }

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

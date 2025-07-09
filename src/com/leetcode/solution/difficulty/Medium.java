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

    // 167. Two Sum II - Input Array Is Sorted
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            if(numbers[l] + numbers[r] == target) {
                return new int[] {l + 1, r + 1};
            }
            if(target < numbers[l] + numbers[r] ) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    // 79. Word Search
    public boolean exist(char[][] board, String word) {
        StringBuilder str = new StringBuilder();
        int row = board.length - 1;
        int col = board[0].length - 1;

        int wordIndex = word.length() - 1;

        for(int i = row; i >= 0; i--) {
            for(int j = col; j >= 0; j--) {
                if(board[i][j] == word.charAt(wordIndex)) {
                    str.append(board[i][j]);
                    wordIndex--;
                }
                if(str.toString().equals(word)) {
                    return true;
                }
            }
        }
        System.out.printf("%d\n", wordIndex);
        System.out.printf("%s\n",str.toString());
        return false;
    }


}

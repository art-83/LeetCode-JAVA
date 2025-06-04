package com.mysolutions.leetcode;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
    // 1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    // 9. Palindrome Number
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        StringBuilder xStr = new StringBuilder(String.valueOf(x));
        if(xStr.reverse().toString().equals(String.valueOf(x))) {
            return true;
        }
        return false;
    }

    // 20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if(pop == '(' && c != ')') {
                    return false;
                }
                if(pop == '{' && c != '}') {
                    return false;
                }
                if(pop == '[' && c != ']') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // 26. Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int n : nums) {
            if(!arrayList.contains(n)) {
                arrayList.add(n);
            }
        }
        for(int i = 0; i < arrayList.size(); i++) {
            nums[i] = arrayList.get(i);
        }
        return arrayList.size();
    }

    // 28. Find the Index of the First Ocurrence in a String
    public int strStr(String haystack, String needle) {
        int l = 0, r = 0, count = 0, i = 0;
        while(r < haystack.length()) {
            if(haystack.charAt(r) == needle.charAt(i)) {
                count++;
                r++;
                i++;
            } else {
                l++;
                r = l;
                count = 0;
                i = 0;
            }
            if(count == needle.length()) {
                return l;
            }
        }
        return -1;
    }

    // 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            if(target == nums[0]) {
                return 0;
            }
            if(target > nums[0]) {
                return 1;
            }
            if(target < nums[0]) {
                return 0;
            }
        }
        if(target < nums[0]) {
            return 0;
        }
        if(target > nums[nums.length - 1]) {
            return nums.length;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == target) {
                return i;
            }
            if(nums[i + 1] == target) {
                return i + 1;
            }
            if(target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    // 58. Length of Last Word
    public int lengthOfLastWord(String s) {
        int count = 0, aux = 0;
        for(Character c : s.toCharArray()) {
            count++;
            if(c != ' ') {
                aux = count;
            } else {
                count = 0;
            }
        }
        return aux;
    }

    // 27. Remove Element
    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int n : nums) {
            if(n != val) {
                arrayList.add(n);
            }
        }
        for(int i = 0; i < arrayList.size(); i++) {
            nums[i] = arrayList.get(i);
        }
        return arrayList.size();
    }

    /*
    public int[] plusOne(int[] digits) {
        String digitsStr = "";
        for(int n : digits) {
            digitsStr += n;
        }
        BigInteger integer = new BigInteger(digitsStr);
        BigInteger result = integer.add(new BigInteger("1"));

        digitsStr = result.toString();

        int arrayResult[] = new int[digitsStr.length()];

        for(int i = 0; i < digitsStr.length(); i++) {
            arrayResult[i] = Character.getNumericValue(digitsStr.charAt(i));
        }
        return arrayResult;
    }
    */

    // 66. Plus One (Unfinished)
    public int[] plusOne(int[] digits) {
        return new int[] {0};
    }

    // 69. Sqrt(x)
    public int mySqrt(int x) {
        if(x == 1 || x == 2) {
            return 1;
        }
        for(long i = 1; i < x; i++) {
            if(i*i == x) {
                return (int) i;
            }
            if(i*i > x) {
                return (int) i - 1;
            }
        }
        return 0;
    }

    // 70. Climbing Stairs
    public int climbStairs(int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);

        if(n <= 2) {
            return arrayList.get(n);
        }
        for(int i = 0; i < n; i++) {
            arrayList.add(arrayList.get(arrayList.size() - 1) + arrayList.get(arrayList.size() - 2));
        }
        return arrayList.get(n - 1) + arrayList.get(n - 2);
    }

    // 88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums2Index = 0;
        for(int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[nums2Index];
            nums2Index++;
        }
        Arrays.sort(nums1);
    }

    // 125. Valid Palindrome
    public boolean isPalindrome(String s) {
        StringBuilder sFormated = new StringBuilder();
        for(Character c : s.toLowerCase().toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sFormated.append(c);
            }
        }
        System.out.printf("%s\n%s\n", sFormated.toString(), sFormated.reverse().toString());
        if(sFormated.toString().equals(sFormated.reverse().toString())) {
            return true;
        }
        return false;
    }
}

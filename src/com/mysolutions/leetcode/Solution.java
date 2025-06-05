package com.mysolutions.leetcode;

import java.lang.classfile.constantpool.StringEntry;
import java.util.*;


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

    // 136. Single Number
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                int newValue = map.get(n) + 1;
                map.replace(n, newValue);
            }
        }
        for(int k : map.keySet()) {
            if(map.get(k) == 1) {
                return k;
            }
        }
        return -1;
    }

    // 169. Majority Element
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                int newValue = map.get(n) + 1;
                map.replace(n, newValue);
            }
        }
        int maxKey = nums[0];
        for(int k : map.keySet()) {
            if(map.get(k) > map.get(maxKey)) {
                maxKey = k;
            }
        }
        return maxKey;
    }

    // 202. Happy Number
    public boolean isHappy(int n) {
        String nStr = String.valueOf(n);
        ArrayList<Integer> pastResult = new ArrayList<Integer>();

        while (true) {
            int result = 0;
            int count = 0;
            for(Character c : nStr.toCharArray()) {
                result += Character.getNumericValue(c) * Character.getNumericValue(c);
            }
            System.out.printf("%d\n", result);
            pastResult.add(result);
            nStr = String.valueOf(result);
            for(int i : pastResult) {
                if(result == i) {
                    count++;
                }
            }
            if(count > 1) {
                return false;
            }
            if(result == 1) {
                return true;
            }
        }
    }

    // 13. Roman To Integer
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        boolean sum;

        int result = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            Character c = s.charAt(i);

            int current = map.get(c);

            if(current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }
        return result;
    }

    // 217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> map = new HashSet<Integer>();
        for(int n : nums) {
            if(map.contains(n)) {
                return true;
            }
            map.add(n);
        }
        return false;
    }

    // 258. Add Digits
    public int addDigits(int num) {
        int result = 1;
        String numStr = String.valueOf(num);
        while (result != 0) {
            result = 0;
            for(Character c : numStr.toCharArray()) {
                result += Character.getNumericValue(c);
            }
            if(result < 10) {
                return result;
            }
            numStr = String.valueOf(result);
        }
        return 0;
    }

    // 268. Missing Number
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(n > max) {
                max = n;
            }
            set.add(n);
        }
        if(!set.contains(0)) {
            return 0;
        }
        for(int i = 1; i < max; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }

    // 283. Move Zeroes
    public void moveZeroes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n : nums) {
            if(n != 0) {
                list.add(n);
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(i < list.size()) {
                nums[i] = list.get(i);
            } else {
                nums[i] = 0;
            }
        }
        /*
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == 0) {
                    int aux = nums[i];
                    nums[i] = nums[j];
                    nums[j] = aux;
                }
            }
        }
         */
    }

    // 344. Reverse String
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char aux = s[l];
            s[l] = s[r];
            s[r] = aux;
            l++;
            r--;
        }
    }

    // 345. Reverse Vowels of a String
    public String reverseVowels(String s) {

    }

}

package com.leetcode.solution.difficulty;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Iterator;

public class Easy {
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

    // 66. Plus One (Unfinished)
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
        char c[] = s.toCharArray();
        int l = 0, r = s.length() - 1;
        int i = 0;
        while (l < r) {
            while ((c[l] != 'A' && c[l] != 'a' && c[l] != 'E' && c[l] != 'e' && c[l] != 'I' && c[l] != 'i' && c[l] != 'O' && c[l] != 'o' && c[l] != 'U' && c[l] != 'u')
            && l < r) {
                l++;
            }
            while ((c[r] != 'A' && c[r] != 'a' && c[r] != 'E' && c[r] != 'e' && c[r] != 'I' && c[r] != 'i' && c[r] != 'O' && c[r] != 'o' && c[r] != 'U' && c[r] != 'u')
            && l < r) {
                r--;
            }
            char aux = c[l];
            c[l] = c[r];
            c[r] = aux;
            l++;
            r--;
        }
        StringBuilder string = new StringBuilder();
        for(Character ch : c) {
            string.append(ch);
        }
        return string.toString();
    }

    // 349. Intersection of Two Arrays
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j] && !list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
            }
        }
        int array[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // 367. Valid Perfect Square (Bad Run Time)
    public boolean isPerfectSquareBadRuntime(int num) {
        for(int i = 1; i < num; i++) {
            if(i * i == num) {
                return true;
            }
            if(i * i > num) {
                return false;
            }
        }
        return false;
    }

    // 367. Valid Perfect Square
    public boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);
        if(Math.floor(sqrt) * Math.floor(sqrt) == num) {
            return true;
        }
        return false;
    }

    // 387. First Unique Character in String
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(Character c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // 389. Find the Diference
    public char findTheDifference(String s, String t) {
        if(s.length() == 0) {
            return t.charAt(0);
        }
        char sChar[] = s.toCharArray();
        char tChar[] = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        for(int i = 0; i < s.length(); i++) {
            if(sChar[i] != tChar[i]) {
                return tChar[i];
            }
        }

        return tChar[s.length()];
    }

    // 507. Perfect Number
    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                sum += i;
            }
        }
        if(sum == num) {
            return true;
        }
        return false;
    }

    // 412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                list.add("Fizz");
            }
            else if(i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

    // 724. Find Pivot Index
    public int pivotIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int l = 0, r = nums.length - 1;
            int lSum = 0, rSum = 0;
            while (l < i) {
                lSum += nums[l];
                l++;
            }
            while (r > i) {
                rSum += nums[l];
                r--;
            }
            if(lSum == rSum) {
                return i;
            }
        }
        return -1;
    }

    // 3110. Score of a String
    public int scoreOfString(String s) {
        int sum = 0;
        char c[] = s.toCharArray();
        for(int i = 0; i < s.length() - 1; i ++) {
            int result = 0;
            result += Math.abs(c[i] - c[i + 1]);
            sum += result;
        }
        return sum;
    }

    // 2884. Divisible and Non-divisible Sums Difference
    public int differenceOfSums(int n, int m) {
        int nums1 = 0, nums2 = 0;
        for(int i = 1; i <= n; i++) {
            if(i % m == 0) {
                nums2 += i;
            } else {
                nums1 += i;
            }
        }
        return nums1 - nums2;
    }

    // 2942. Find Words Containing Character
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        for(String s : words) {
            if(s.contains(String.valueOf(x))) {
                list.add(i);
            }
            i++;
        }
        return list;
    }

    // 1929. Concatenation of Array
    public int[] getConcatenation(int[] nums) {
        int array[] = new int[nums.length * 2];
        for(int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
            array[i + nums.length] = nums[i];
        }
        return array;
    }

    // 2469. Convert Temperature
    public double[] convertTemperature(double celsius) {
        double k = celsius + (double) 273.15;
        double f = celsius * (double) 1.8 + (double) 32.00;
        return new double[] {k, f};
    }

    // 1108. Defanging an IP Adress
    public String defangIPaddr(String address) {
        String dot = "[.]";
        StringBuilder str = new StringBuilder();

        for(Character c : address.toCharArray()) {
            if(c != '.') {
                str.append(c);
            } else {
                str.append(dot);
            }
        }
        return str.toString();
    }

    // 1512. Number of Good Pairs
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // 3467. Transform Array by Parity
    public int[] transformArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
        Arrays.sort(nums);
        return nums;
    }

    // 771. Jewels and Stones
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(Character c : stones.toCharArray()) {
            for(Character v : jewels.toCharArray()) {
                if(c == v) {
                    count++;
                }
            }
        }
        return count;
    }

    // 3190. Find Minimum Operations to Make All Elements Divisible by Three
    public int[] getSneakyNumbers(int[] nums) {
         Map<Integer, Integer> map = new LinkedHashMap<>();
         for(int n : nums) {
             if(!map.containsKey(n)) {
                 map.put(n, 1);
             } else {
                 map.put(n, map.get(n) + 1);
             }
         }
         int array[] = new int[2];
         int i = 0;
         for(int k : map.keySet()) {
            if(map.get(k) == 2) {
                array[i] = k;
                i++;
            }
         }
         return array;
    }

    // 1470. Suffle the array (Bad Run Time)
    public int[] shuffleBadRunTime(int[] nums, int n) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            if(i < nums.length/2) {
                xQueue.add(nums[i]);
            } else {
                yQueue.add(nums[i]);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) {
                nums[i] = xQueue.remove();
            } else {
                nums[i] = yQueue.remove();
            }
        }

        return nums;
    }

    // 1672. Richest Customer Wealth
    public int maximumWealth(int[][] accounts) {
        int rows = accounts.length;
        int col =  accounts[0].length;

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < rows; i++) {
            int result = 0;
            for(int j = 0; j < col; j++) {
                result += accounts[i][j];
            }
            if(result > max) {
                max = result;
            }
        }
        return max;
    }

    // 2235. Add Two Integers
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for(Character c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for(Character k : map.keySet()) {
            if(map.get(k) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 796. Rotate String
    public boolean rotateString(String s, String goal) {
        Queue<Character> queue = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        for(Character c : s.toCharArray()) {
            queue.add(c);
        }
        while (true) {
            char aux = queue.remove();
            queue.add(aux);
            for(Character c : queue) {
                str.append(c);
            }
            if(str.toString().equals(goal)) {
                return true;
            }
            if(str.toString().equals(s)) {
                return false;
            }
            str.setLength(0);
        }
    }

    // 392. Is Subsequence
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) {
            return true;
        }
        if(t.length() == 0) {
            return false;
        }
        List<Character> list = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            list.add(c);
        }
        int listIndex = 0;
        int count = 0;
        for(Character c : t.toCharArray()) {
            if(c == list.get(listIndex)) {
                listIndex++;
                count++;
            }
            if(listIndex > list.size()) {
                break;
            }
        }
        if(count == s.length()) {
            return true;
        }
        return false;
    }

    // 509. Fibonnaci Number
    public int fibBadRuntime(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        return fibBadRuntime(n - 1) + fibBadRuntime(n - 2);
    }

    public int fib(int n) {
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        if(n == 0) {
            return list.get(0);
        }
        if(n == 1 || n == 2) {
            return list.get(1);
        }

        for(int i = 3; i < n; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }
        return list.get(n - 1);
    }

    // 844. Backspace String Compare
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c == '#') {
                if(!sStack.isEmpty()) {
                    sStack.pop();
                }
            } else {
                sStack.add(c);
            }
        }
        for(Character c : t.toCharArray()) {
            if(c == '#') {
                if(!tStack.isEmpty()) {
                    tStack.pop();
                }
            } else {
                tStack.add(c);
            }
        }
        if(sStack.size() == tStack.size()) {
            for(int i = 0; i < sStack.size(); i++) {
                if(sStack.get(i) != tStack.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // 290. Word Pattern
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new LinkedHashMap<>();
        List<String> list = new LinkedList<>();
        StringBuilder strBuilder = new StringBuilder();
        s += " ";

        for(Character c : s.toCharArray()) {
            if(c != ' ') {
                strBuilder.append(c);
            } else {
                if(!list.contains(strBuilder.toString())) {
                    list.add(strBuilder.toString());
                }
                strBuilder.setLength(0);
            }
        }

        int i = 0;

        for(Character c : pattern.toCharArray()) {
            if(!map.containsKey(c)) {
                if(i < list.size()) {
                    map.put(c, list.get(i));
                    i++;
                }
            }
        }

        System.out.println(map.toString());
        System.out.println(list.toString());

        for(Character c : pattern.toCharArray()) {
            strBuilder.append(map.get(c) + " ");
        }

        System.out.println(strBuilder.toString());

        if(strBuilder.toString().equals(s)) {
            return true;
        }
        return false;
    }

    // 231. Power of Two
    public boolean isPowerOfTwo(int n) {
         for(int i = 0; i < 31; i++) {
             if(Math.pow(2,i) == n) {
                 return true;
             }
         }
         return false;
    }

    // 326. Power of Three
    public boolean isPowerOfThree(int n) {
        for(int i = 0; i < 31; i++) {
            if(Math.pow(3,i) == n) {
                return true;
            }
        }
        return false;
    }

    // 3024. Type of Triangle
    public String triangleType(int[] nums) {
        if(nums[0] + nums[1] <= nums[2] ||
           nums[1] + nums[2] <= nums[0] ||
           nums[2] + nums[0] <= nums[1]) {
            return "none";
        }
        if(nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        }
        if(nums[0] != nums[1] && nums[1] != nums[2]) {
            return "scalene";
        }
        return "isoceles";
    }

    // 1768. Merge Strings Alternately
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (index < word1.length() && index < word2.length()) {
            str.append(word1.charAt(index));
            str.append(word2.charAt(index));
            index++;
        }
        if(word1.length() > word2.length()) {
            for (int i = index; i < word1.length(); i++) {
                str.append(word1.charAt(i));
            }
        } else {
            for (int i = index; i < word2.length(); i++) {
                str.append(word2.charAt(i));
            }
        }
        return str.toString();
    }
    public String mergeAlternatelyBadRunTime(String word1, String word2) {
        Queue<Character> queueWord1 = new LinkedList<>();
        Queue<Character> queueWord2 = new LinkedList<>();
        for(Character c : word1.toCharArray()) {
            queueWord1.add(c);
        }
        for(Character c : word2.toCharArray()) {
            queueWord2.add(c);
        }
        StringBuilder str = new StringBuilder();
        while (!queueWord1.isEmpty() || !queueWord2.isEmpty()) {
            if(!queueWord1.isEmpty()) {
                str.append(queueWord1.remove());
            }
            if(!queueWord2.isEmpty()) {
                str.append(queueWord2.remove());
            }
        }
        return str.toString();
    }

    // 434. Number of Segments in a String
    public int countSegments(String s) {
        s = s.toLowerCase();
        s += " ";

        StringBuilder str = new StringBuilder();
        List<String> list = new LinkedList<>();

        for(Character c : s.toCharArray()) {
            if(c != ' ') {
                str.append(c);
            } else {
                list.add(str.toString());
                str.setLength(0);
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(" ")  || list.get(i).equals("")) {
                list.remove(i);
            }
        }
        System.out.println(list.toString());
        return list.size();
    }

    // 2085. Count Common Words With One Occurrence
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> mapWords1 = new HashMap<>();
        Map<String, Integer> mapWords2 = new HashMap<>();

        for (String s : words1) {
            if(!mapWords1.containsKey(s)) {
                mapWords1.put(s, 1);
            } else {
                mapWords1.put(s, mapWords1.get(s) + 1);
            }
        }

        for (String s : words2) {
            if(!mapWords2.containsKey(s)) {
                mapWords2.put(s, 1);
            } else {
                mapWords2.put(s, mapWords2.get(s) + 1);
            }
        }

        int count = 0;

        for(String s : mapWords1.keySet()) {
            if(mapWords2.containsKey(s)) {
                if(mapWords1.get(s) == 1 && mapWords2.get(s) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    // 3285. Find Indices of Stable Mountains
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < height.length; i++) {
            if(height[i - 1] > threshold) {
                list.add(i);
            }
        }
        return list;
    }

    // 1876. Substrings of Size Three with Distinct Characters
    public int countGoodSubstrings(String s) {
        StringBuilder str = new StringBuilder();
        int count = 0, l = 0, r = 2;

        while (r < s.length()) {
            for (int i = l; i <= r; i++) {
                str.append(s.charAt(i));
            }
            System.out.println(str.toString());
            if(goodSubstring(str.toString())) {
                count++;
            }
            str.setLength(0);
            l++;
            r++;
        }
        return count;
    }
    public static boolean goodSubstring(String s) {
        Set<Character> map = new HashSet<>();
        for(Character c : s.toCharArray()) {
            if(!map.contains(c)) {
                map.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    // 819. Most Common Word
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        String words[] = paragraph.split("[ !?',;.]");
        Map<String, Integer> map = new HashMap<>();
        for(String s : words) {
            boolean isBanned = false;
            if(!s.isEmpty()) {
                for(String b : banned) {
                    if(s.equals(b)) {
                        isBanned = true;
                    }
                }
                if(isBanned == false) {
                    if(!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
        }
        String maxKey = null;
        int maxValue = 0;
        for(String s : map.keySet()) {
            if(map.get(s) > maxValue) {
                maxKey = s;
                maxValue = map.get(s);
            }
        }
        System.out.println(map.toString());
        return maxKey;
    }

    // 824. Goat Latin
    public String toGoatLatin(String sentence) {
        String words[] = sentence.split(" ");
        StringBuilder str = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int aCount = 1;

        for(String s : words) {
            if(String.valueOf(s.charAt(0)).equalsIgnoreCase("a") || String.valueOf(s.charAt(0)).equalsIgnoreCase("e") ||
            String.valueOf(s.charAt(0)).equalsIgnoreCase("i") || String.valueOf(s.charAt(0)).equalsIgnoreCase("o") ||
                String.valueOf(s.charAt(0)).equalsIgnoreCase("u")) {
                str.append(s);
                str.append("ma");
            } else {
                str.append(s.substring(1,s.length()));
                str.append(s.charAt(0));
                str.append("ma");
            }
            for(int i = 0; i < aCount; i++) {
                str.append("a");
            }
            result.append(str.toString() + " ");
            str.setLength(0);
            aCount++;
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    // 463. Island Perimeter
    public int islandPerimeter(int[][] grid) {
        int edges = 0, rows = grid.length, col = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    edges += 4;
                }
            }
        }
        edges -= verifyUpEdge(grid);
        edges -= verifyDownEdge(grid);
        edges -= verifyLeftEdge(grid);
        edges -= verifyRightEdge(grid);
        return edges;
    }

    public static int verifyUpEdge(int[][] grid) {
        int edges = 0, rows = grid.length, col = grid[0].length;
        for(int i = 1; i < rows; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i - 1][j] == 1 && grid[i][j] == 0) {
                    System.out.printf("%d - %d: up--\n", i, j);
                    edges++;
                }
            }
        }
        return edges;
    }

    public static int verifyDownEdge(int[][] grid) {
        int edges = 0, rows = grid.length, col = grid[0].length;
        for(int i = 0; i < rows - 1; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i + 1][j] == 1 && grid[i][j] == 0) {
                    System.out.printf("%d - %d: down--\n", i, j);
                    edges++;
                }
            }
        }
        return edges;
    }

    public static int verifyLeftEdge(int[][] grid) {
        int edges = 0, rows = grid.length, col = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 1; j < col; j++) {
                if(grid[i][j - 1] == 1 && grid[i][j] == 0) {
                    System.out.println(j + "left--");
                    edges++;
                }
            }
        }
        return edges;
    }

    public static int verifyRightEdge(int[][] grid) {
        int edges = 0, rows = grid.length, col = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < col - 1; j++) {
                if(grid[i][j + 1] == 1 && grid[i][j] == 0) {
                    System.out.println(j + "right--");
                    edges++;
                }
            }
        }
        return edges;
    }

    // 1748. Sum of Unique Elements
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        int sum = 0;
        for(int n : map.keySet()) {
            if(map.get(n) == 1) {
                sum += n;
            }
        }
        return sum;
    }

    // 1207. Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int n : arr) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for(int n : map.keySet()) {
            if(set.contains(map.get(n))) {
                return false;
            }
            set.add(map.get(n));
        }
        return true;
    }

    // 1796. Second Largest Digit in a String
    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for(Character c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                set.add(Character.getNumericValue(c));
            }
        }
        if(set.size() <= 1) {
            return -1;
        }
        return set.lower(set.getLast());
    }

    // 1507. Reformat Date
    public String reformatDate(String date) {
        String d[] = date.split(" ");
        StringBuilder str = new StringBuilder();
        Map<String, String> month = new HashMap<>();
        if(d[0].length() == 1) {
            str.append(0);
        }
        for(Character c : d[0].toCharArray()) {
            if(Character.isDigit(c)) {
                str.append(c);
            }
        }
        month.put("Jan", "1");
        month.put("Feb", "2");
        month.put("Mar", "3");
        month.put("Apr", "4");
        month.put("May", "5");
        month.put("Jun", "6");
        month.put("Jul", "7");
        month.put("Aug", "8");
        month.put("Sep", "9");
        month.put("Oct", "10");
        month.put("Nov", "11");
        month.put("Dec", "12");
        d[0] = str.toString();
        d[1] = month.get(d[1]);
        str.setLength(0);
        for(int i = 2; i >= 0; i--) {
            str.append(d[i] + '-');
        }
        return str.toString().substring(0, str.length() - 1);
    }

    // 1598. Crawler Log Folder
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String s : logs) {
            System.out.printf("%s\n", stack.toString());
            if(!s.equals("./")) {
                if(s.equals("../") && !stack.isEmpty()) {
                    stack.pop();
                }
                if(!s.equals("../")){
                    stack.add(s);
                }
            }
        }
        return stack.size();
    }

    // 2824. Count Pairs Whose Sum is Less than Target
    public int countPairs(List<Integer> nums, int target) {
        int count = 0, size = nums.size();
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if(nums.get(i) + nums.get(j) < target) {
                    count++;
                }
            }
        }
        return count;
    }

    // 1021. Generate Tag for Video Caption
    public String generateTag(String caption) {
        String words[] = caption.split(" ");
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder("#");
        for(String s : words) {
            if(!s.isEmpty()) {
                list.add(s.toLowerCase());
            }
        }
        StringBuilder w = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                str.append(list.get(i));
            } else {
                w.append(list.get(i));
                w.setCharAt(0, Character.toUpperCase(w.charAt(0)));
                str.append(w);
                w.setLength(0);
            }
        }
        if(str.length() > 100) {
            str.setLength(100);
        }
        return str.toString();
    }

    // 3591. Check if Any Element Has Prime Frequency
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }

        for(int n : map.keySet()) {
            if(isPrime(map.get(n))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrime(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                count ++;
            }
        }
        if(count == 2) {
            return true;
        }
        return false;
    }

    // 1480. Three Consecutive Odds
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for(int n : arr) {
            if(n % 2 != 0) {
                count++;
            } else {
                count = 0;
            }
            if(count == 3) {
                return true;
            }
        }
        return false;
    }

    // 2206. Divide Array Into Equal Pairs
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            if(!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for(int n : nums) {
            if(map.get(n) % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
package com.mysolutions.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return null;
        }
        if(list1 != null && list2 == null) {
            return sortNode(list1);
        }
        if(list1 == null && list2 != null) {
            return sortNode(list2);
        }

        ListNode list1Aux = list1;
        while (list1Aux.next != null) {
            list1Aux = list1Aux.next;
        }
        list1Aux.next = list2;
        return sortNode(list1);
    }

    public ListNode sortNode(ListNode list) {
        if(list == null) {
            return null;
        }
        ListNode aux = list;
        int count = 0;
        while(aux != null) {
            aux = aux.next;
            count++;
        }
        aux = list;
        int array[] = new int[count];

        for(int i = 0; i < count; i++) {
            array[i] = aux.val;
            aux = aux.next;
        }
        aux = list;
        Arrays.sort(array);
        for(int i = 0; i < count; i++) {
            aux.val = array[i];
            aux = aux.next;
        }
        return list;
    }

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

    //incomplete
    public int lengthOfLastWord(String s) {
        int count = 0, aux = 0;
        for(char c : s.toCharArray()) {
            if(c == ' ' && count != 0) {
                aux = count;
            }
            if(c != ' ') {
                count++;
            } else {
                count = 0;
            }

        }
        return aux;
    }
}

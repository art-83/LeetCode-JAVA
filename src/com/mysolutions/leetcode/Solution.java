package com.mysolutions.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

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

}

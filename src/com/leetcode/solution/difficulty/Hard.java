package com.leetcode.solution.difficulty;

import java.util.Arrays;

public class Hard {

    // 4. Median of Two Sorted Arrays - Big O Notation = O((N+M)Log(N+M))
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums3[] = new int[nums1.length + nums2.length];
        for(int i = 0; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }
        int indexNums2 = 0;
        for(int i = nums1.length; i < nums1.length + nums2.length; i++) {
            nums3[i] = nums2[indexNums2];
            indexNums2++;
        }
        Arrays.sort(nums3);

        if(nums3.length % 2 == 0) {
            return (double) (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2;
        }
        return nums3[nums3.length/2];
    }

    // 3463. Check If Digits Are Equal in String After Operations II
    public boolean hasSameDigits(String s) {
        StringBuilder strBuilder = new StringBuilder();
        while(s.length() > 2) {
            for(int i = 0; i < s.length() - 1; i++) {
                int result = (Character.getNumericValue(s.charAt(i)) + Character.getNumericValue(s.charAt(i + 1))) % 10;
                strBuilder.append(result);
            }
            s = strBuilder.toString();
            strBuilder.setLength(0);
        }
        if(s.length() < 2) {
            return false;
        }
        if(s.charAt(0) == s.charAt(1)) {
            return true;
        }
        return false;
    }
}
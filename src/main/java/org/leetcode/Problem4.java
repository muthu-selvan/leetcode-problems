package org.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Problem4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;

        int[] array = IntStream.concat(
                Arrays.stream(nums1), Arrays.stream(nums2)
        ).toArray();

        Arrays.sort(array);
        int arrayLength = array.length;

        if (arrayLength % 2 == 0) {
            result = (array[arrayLength/2 - 1] + array[arrayLength/2]) / 2.0;
        } else {
            result = array[arrayLength/2];
        }

        return result;
    }
    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        int[] num1 = {1,3};
        int[] num2 = {2};

        System.out.println(problem4.findMedianSortedArrays(num1, num2));
    }
}

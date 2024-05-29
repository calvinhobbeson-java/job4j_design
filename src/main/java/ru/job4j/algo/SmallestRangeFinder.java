package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int counter = 1;
        int left = 0;
        int right = 1;
        int[] result = new int[2];
        result[0] = left;
        while (counter < k && right < nums.length) {
            if (nums[left] < nums[right]) {
                counter++;
                left++;
                right++;
            } else {
                left++;
                right++;
                result[0] = left;
                counter = 1;
            }
        }
        result[1] = left;
        if (counter != k) {
            result = null;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 2;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
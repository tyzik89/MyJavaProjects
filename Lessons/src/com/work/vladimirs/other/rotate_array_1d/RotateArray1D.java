package com.work.vladimirs.other.rotate_array_1d;

import java.util.Arrays;

public class RotateArray1D {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int k = 3;
//        rotateWithAdditionalArray(nums, k);
        rotateInPlace(nums, k);
        System.out.println(Arrays.toString(nums));


        nums = new int[]{-1,-100,3,99};
        k = 2;
//        rotateWithAdditionalArray(nums, k);
        rotateInPlace(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1,2};
        k = 3;
//        rotateWithAdditionalArray(nums, k);
        rotateInPlace(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotateWithAdditionalArray(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    public static void rotateInPlace(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int startIdx, int endIdx) {
        int length = endIdx - startIdx + 1;
        for (int i = 0; i < length/2; i++) {
            int temp = nums[i + startIdx];
            nums[i + startIdx] = nums[length - 1 - i + startIdx];
            nums[length - 1 - i + startIdx] = temp;
        }
    }
}

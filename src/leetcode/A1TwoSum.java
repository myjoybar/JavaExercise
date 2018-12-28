package leetcode;

import java.util.Arrays;

/**
 * Created by joybar on 2018/9/11.
 */
public class A1TwoSum {

    public static void main(String[] args) {

        int[] nums = { 11, 15,7,2};
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }


    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int k = 0; k < length; k++) {
                if (i < k) {
                    int firstNum = nums[i];
                    int secondNum = nums[k];
                    if ((firstNum + secondNum) == target) {
                        result[0] = i;
                        result[1] = k;
                        break;
                    }
                }
            }
        }
        return result;
    }

}

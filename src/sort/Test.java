package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2017/5/16.
 */
public class Test {

    static int[] arr = {-1, 3, -10, 7, 9, 3, -8, 5, 2, -16, -10, -90, 3, 4, 5, 90, -11};

    public static void main(String[] args) {


        System.out.println("Before sort,array = " + Arrays.toString(arr));
        test4(arr, 0, arr.length - 1);

        System.out.println("After sort,array = " + Arrays.toString(arr));

    }


    //  static int[] arr = {-1, 3, -10, 7, 9, 3, -2, 5};
    public static void test4(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        while (left < right) {
            int firstAboveZeroIndex = getFirstAboveZeroIndex(arr, left);
            if (firstAboveZeroIndex != -1) {
                int firstBelowZeroIndex = getFirstBelowZeroIndex(arr, firstAboveZeroIndex);
                if (firstBelowZeroIndex != -1) {
//                    System.out.println("swap value== " + arr[firstAboveZeroIndex] + " and " + arr[firstBelowZeroIndex]);
//                    System.out.println("swap index== " + firstBelowZeroIndex + " and " + firstAboveZeroIndex);
                    if (firstBelowZeroIndex - firstAboveZeroIndex > 1) {
                        for (int i = firstBelowZeroIndex; i > firstAboveZeroIndex; i--) {
                            swap(arr, i, i - 1);
                        }
                    } else {
                        swap(arr, firstBelowZeroIndex, firstAboveZeroIndex);
                        left = firstBelowZeroIndex;
                    }
                } else {
                    right--;
                }

            } else {
                left++;
            }
        }
    }


    public static void adjust(int[] date) {
        //长度为0 1 2不需要调整
        if (date.length <= 2) {
            return;
        }
        int length = date.length;
        int end = length - 1;
        for (int i = 0; i < length / 2 + 1; i++) {
            if (date[i] < 0) {
                //找到右边第一个负数并且需要i<end
                while (date[end] < 0 && i < end) {
                    end--;
                }
                //交换
                int temp = date[i];
                date[i] = date[end];
                date[end] = temp;
            }
        }
    }


    //  static int[] arr = {-1, 3, -10, 7, 9, 3, -2, 5};
    //static int[] arr = {-1, -10, 3, 7, 9, 3, -2, 5};
    public static void test3(int[] arr, int low, int high) {

        int left = low;
        int right = high;

        while (left < right) {

            int firstAboveZeroIndex = getFirstAboveZeroIndex(arr, left);


            if (firstAboveZeroIndex != -1) {

                int firstBelowZeroIndex = getFirstBelowZeroIndex(arr, firstAboveZeroIndex);

                if (firstBelowZeroIndex != -1) {
                    System.out.println("swap value== " + arr[firstAboveZeroIndex] + " and " + arr[firstBelowZeroIndex]);
                    swap(arr, firstBelowZeroIndex, firstAboveZeroIndex);
                    left = firstBelowZeroIndex;
                } else {
                    right--;
                }

            } else {
                left++;
            }

        }

    }


    public static int getFirstBelowZeroIndex(int[] arr, int start) {

        int length = arr.length;
        for (int i = start; i < length; i++) {

            if (arr[i] < 0) {
                return i;
            }
        }
        System.out.println("no Below Zero value ");
        return -1;
    }


    public static int getFirstAboveZeroIndex(int[] arr, int start) {

        int length = arr.length;
        for (int i = start; i < length; i++) {

            if (arr[i] > 0) {
                return i;
            }
        }
        System.out.println("no Above Zero value ");
        return -1;
    }


    //  static int[] arr = {-1, 3, -10, 7, 9, 3, -2, 5};
    public static void test2(int[] arr, int low, int high) {

        int left = low;
        int right = high;

        while (left < right) {
            if (arr[left] > 0) {

                if (arr[right] < 0) {
                    swap(arr, left, right);
                } else {
                    right--;
                }
            } else {
                left++;
            }

        }

    }

    public static void test(int[] arr, int low, int high) {

        int left = low;
        int right = high;
        boolean leftFlag = false;
        boolean rightFlag = false;


        while (low < high) {
            if (arr[left] > 0) {
                left++;
                leftFlag = true;
            }

            if (arr[right] < 0) {
                right--;
                rightFlag = true;
            }

            if (leftFlag && rightFlag) {
                swap(arr, left, right);
                leftFlag = false;
                rightFlag = false;
            }


        }

    }


    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}

package offer;

import java.util.Arrays;

/**
 * Created by joybar on 2019/1/22.
 */
public class Offer1 {

    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9,2,4,6,5,3,1,2};
    // static int[] arr = {4, 2, 6, 7, 8, 9};

    public static void main(String[] args) {
        System.out.println("befroe = "+ Arrays.toString(arr));
        //reorderArray(arr);
        reorderArray2(arr);
        System.out.println("after = "+Arrays.toString(arr));

    }


    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     */
    public static void reorderArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int firstOUshuIndex = findFirstIndexOuShu(array, i);
            if (firstOUshuIndex != -1) {
                int firstJishuIndex = findFirstIndexJiShu(array, i);
                if (firstJishuIndex != -1) {
                    if (firstJishuIndex - firstOUshuIndex == 1) {
                        swap(array, firstOUshuIndex, firstJishuIndex);
                    } else if (firstJishuIndex - firstOUshuIndex > 1) {
                        for (int j = firstJishuIndex; j > firstOUshuIndex; j--) {
                            swap(array, j, j - 1);
                        }
                    }
                }
            }

        }

    }

    public static int findFirstIndexOuShu(int[] array, int startIndex) {
        if (startIndex >= array.length || startIndex < 0) {
            return -1;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                return i;
            }
        }

        return -1;
    }


    public static int findFirstIndexJiShu(int[] array, int startIndex) {
        if (startIndex >= array.length || startIndex < 0) {
            return -1;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                return i;
            }
        }

        return -1;
    }


    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array
     *
     * 类似冒泡算法，前偶后奇数就交换：
     */
    public static void reorderArray2(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]%2==0&&array[j+1]%2==1){
                    swap(array,j,j+1);
                }
            }

        }
    }


    /**
     * 求1+2+3+...+n，
     * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
     * @param n
     * @return
     */
    public static int calculeSum(int n){

        if(n==1){
            return 1;
        }
        return calculeSum(n+1);
    }

}


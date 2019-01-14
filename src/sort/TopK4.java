package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class TopK4 {

    public static int[] testArray = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1, 22, 3, 44, 54, 32, 45, 6, 7, 7, 777878, 44, 1, 2, 34345};
    public static int[] testArray1 = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1, 22, 3, 44, 54, 32, 45, 6, 7, 7, 777878, 44, 1, 2, 34345};


    /**
     * 分治实现
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));
        FastSort2.QSort2(testArray, 0, testArray.length - 1);
        System.out.println("After sort2,array = " + Arrays.toString(testArray));
        System.out.println("=================== " );
        int k = 30;
        fastsort(testArray1, 0, testArray1.length - 1, k);
        System.out.println("After sort2,array  前" + k +"个元素:   "+ Arrays.toString(testArray1));
    }


    public static void fastsort(int[] array, int start, int end, int topK) {
        if (start < end) {
            int index = parttion(array, start, end);

            if (topK < index) {
                fastsort(array, start, index - 1, topK);
            }
            if (topK > index) {
                fastsort(array, index + 1, end, topK);
            }
            if (topK == index) {
                System.out.println("After sort2,array---- = " + Arrays.toString(array));
            }

        }

    }

    public static int parttion(int[] array, int start, int end) {

        int temp = array[end];
        int p = start - 1;

        for (int i = start; i < end; i++) {
            if (array[i] < temp) {
                p++;
                if (i != p) {
                    swap(array, p, i);
                }
            }

        }
        p++;
        swap(array, p, end);
        return p;

    }


    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }


}

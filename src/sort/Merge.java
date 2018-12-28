package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class Merge {
    public static int[] testArray = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1};

    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));
        mergeSort(testArray,0,testArray.length-1);
        System.out.println("After sort2,array = " + Arrays.toString(testArray));
    }


    public static void mergeSort(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(array, low, mid);////左子表递归排列有序
            mergeSort(array, mid + 1, high);////右子表递归排列有序
            merge(array, low, mid, high);
        }

    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] arr = new int[end+1]; // 定义一个临时数组，用来存储排序后的结果
        int low = start; // 临时数组的索引
        int left = start;
        int center = mid + 1;

        // 取出最小值放入临时数组中
        while (start <= mid && center <= end) {
            arr[low++] = array[start] > array[center] ? array[center++] : array[start++];
        }

        // 若还有段序列不为空，则将其加入临时数组末尾
// 把左边剩余的数移入数组
        while (start <= mid) {
            arr[low++] = array[start++];
        }
        // 把右边边剩余的数移入数组
        while (center <= end) {
            arr[low++] = array[center++];
        }

        // 将临时数组中的值copy到原数组中
        for (int i = left; i <= end; i++) {
            array[i] = arr[i];
        }


    }


}

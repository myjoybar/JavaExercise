package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class FastSort3 {
    public static int[] testArray = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1, 22, 3, 44, 54, 32, 45, 6, 7, 7, 777878, 44, 1, 2, 34345};

    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));
        QuickSort(testArray, 0, testArray.length - 1);
//        fastSort1(testArray, 0, testArray.length - 1);
//        fastSort2(testArray, 0, testArray.length - 1);
        System.out.println("After sort2,array = " + Arrays.toString(testArray));
    }
//[0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 12, 21, 54, 67]
//[0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 12, 21, 54, 67]
//[0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 12, 21, 54, 67]

    static  int Partition(int arr[], int left, int right)
    {
        int temp = arr[right];
        int i = left - 1;

        for (int j = left; j <= right-1; j ++) {
            if (arr[j] <= temp) {
                i ++;
                System.out.println("j = " +j+",i = " +i);
                swap(arr,i,j);
            }
        }
        swap(arr,right ,i+1); //!!!note: can't use temp:local variable
        return i+1;
    }

    static void QuickSort(int arr[], int left, int right)
    {
        if (left < right) {
            int mid = Partition(arr, left, right);
            QuickSort(arr, left, mid-1);
            QuickSort(arr, mid+1, right);
        }
    }

    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}

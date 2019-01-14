package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class FastSort {
    public static int[] testArray = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1};

    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));
        quickSort(testArray, 0, testArray.length - 1);
//        fastSort1(testArray, 0, testArray.length - 1);
//        fastSort2(testArray, 0, testArray.length - 1);
        System.out.println("After sort2,array = " + Arrays.toString(testArray));
    }
//[0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 12, 21, 54, 67]
//[0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 12, 21, 54, 67]
//[0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 12, 21, 54, 67]
    public static void fastSort(int[] array, int start, int end) {

        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int signIndex = i;
        int signNumber = array[signIndex];

        while (i < j) {
            while (i < j && array[j] >= signNumber) {
                j--;
            }
            if (i < j) {
                array[signIndex] = array[j];
                signIndex = j;
            }


            while (i < j && array[i] <= signNumber) {
                i++;
            }

            if (i < j) {
                array[signIndex] = array[i];
                signIndex = i;
            }

        }

        array[i] = signNumber;

        fastSort(array, start, i - 1);
        fastSort(array, i + 1, end);


    }

    public static void fastSort1(int[] array, int start, int end) {

        if (start < end) {
            int i = start;
            int j = end;
            int signIndex = i;
            int signNumber = array[signIndex];


            while (i < j) {
                while (i < j && array[j] >= signNumber) {
                    j--;
                }
                if (i < j) {
                    array[signIndex] = array[j];
                    signIndex = j;
                }


                while (i < j && array[i] <= signNumber) {
                    i++;
                }
                if (i < j) {
                    array[signIndex] = array[i];
                    signIndex = i;
                }

            }
            array[i] = signNumber;
            fastSort1(array, start, i - 1);
            fastSort1(array, i + 1, end);


        }

    }


    public static void fastSort2(int[] array, int start, int end) {

        if (start < end) {
            int i = start;
            int j = end;
            int signNumber = array[i];
            while (i < j) {

                while (i < j && array[j] >= signNumber) {
                    j--;
                }

                while (i < j && array[i] <= signNumber) {
                    i++;
                }


                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }

            }

            array[start] = array[i];
            array[i] = signNumber;

            fastSort2(array, start, i - 1);
            fastSort2(array, i + 1, end);

        }

    }


    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
          //  if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
           // }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }


    public static  void fastSort3(int[] arr, int low, int high) {

        int l = low;
        int r = high;

        if (l < r) {

            int signValue = arr[l];
            while (l < r) {
                while (l < r && arr[r] >= signValue) {
                    r--;
                }
                while (l < r && arr[l] <= signValue) {
                    l++;
                }
                if (l < r) {
                    int temp = arr[r];
                    arr[r] = arr[l];
                    arr[l] = temp;
                }


            }
            arr[low] = arr[l];
            arr[l] = signValue;

            fastSort3(arr, low, l - 1);
            fastSort3(arr, l + 1, high);
        }

    }

}

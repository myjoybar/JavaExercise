package datastructure.sort.quicksort;

/**
 * Created by joybar on 2017/10/31.
 */
public class QuickSort1 {
    //http://www.cnblogs.com/hjy9420/p/5032309.html
    private static int num = 0;
    int count = 0;

    static void quickSort(int[] a, int low, int high) {
        num++;
        int start = low;
        int end = high;
        int key = a[low];
        while (start < end) {
            //从后往前比较
            //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
            while (start < end && key <= a[end]) {
                end--;
            }
            if (a[end] <= key) {
                swap(a, start, end);
            }
            //从前往后比较
            //如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
            while (start < end && a[start] <= key) {
                start++;
            }
            if (key <= a[start]) {
                swap(a, start, end);
            }
        }
        //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，
        // 但是两边的顺序还有可能是不一样的，进行下面的递归调用
        //递归
        if (start > low) {
            quickSort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        }

        if (end < high) {
            quickSort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个
        }
    }


    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void main(String[] args) {

        int test[] = {34, 5, 4, 5, 3, 2, 6, 90, 5};

        for (int i : test) {
            System.out.print(i + "_");
        }
        int length = test.length;
        int low = 0;
        int high = length - 1;
        quickSort(test, low, high);
        System.out.println("========" + num);
        for (int i : test) {
            System.out.print(i + "_");
        }
    }


}

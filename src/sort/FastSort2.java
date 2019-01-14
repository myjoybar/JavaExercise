package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class FastSort2 {
  // public static int[] testArray = {8,1,3,9,2,4,7,6,5,0,4,2,12,1,2,67,54,3,21,1,22,3,44,54,32,45,6,7,7,777878,44,1,2,34345};
     public static int[] testArray = {1, 7, 12,11, 8, 13, 5, 10};
    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));
        QSort2(testArray, 0, testArray.length - 1);
        System.out.println("After sort2,array = " + Arrays.toString(testArray));
    }

    //Partition实现方法2,算法导论实现方法                                                  sort/FastSort2.java:14
    static int Partition(int[] a, int low, int high) {
        int pivotkey = a[high];//将最后一个元素当做曲轴
        int p = low - 1;
        System.out.println("j------------ ");
        for (int j = low; j < high; j++) {
            if (a[j] <= pivotkey) {
                p++;
                System.out.println("value-------index j = " + j + ",p = " + p);
                if (p != j) {
                    System.out.println("value-------swap" + a[p] + "---,value=" + a[j]);
                    swap(a, p, j);//在p前面的都是大于pivotkey的元素  //在p位置和其后的都是小于等于pivotkey的元素
                    System.out.println("0000first,array = " + Arrays.toString(testArray));
                }


            }
        }
        p += 1;
        System.out.println("p------------ " + p + ",value=" + a[p] + ",high=" + high + ",value=" + a[high]);

        swap(a, p, high);
        System.out.println("first,array = " + Arrays.toString(testArray));
        return p;
    }

    //交换a与b的值
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public  static void QSort(int[] a, int start, int end) {
        if (start < end) {
            int p = Partition(a, start, end);
            QSort(a, start, p - 1);
            QSort(a, p + 1, end);
        }
    }

 public    static int Partition2(int[] array, int low, int high) {
        int temp = array[high];
        int p = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] < temp) {
                p++;
                if (p != i) {
                    swap(array, p, i);
                }
            }

        }

        p = p + 1;
        swap(array, p, high);
        return p;

    }

    static void QSort2(int[] a, int start, int end) {
        if (start < end) {

            int index =  Partition2(a,start,end);
            QSort2(a,start,index-1);
              QSort2(a,index+1,end);

        }


    }
}

package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class DIK1 {
     public static int[] testArray = {8,1,3,9,2,4,7,6,5,0,4,2,12,1,2,67,54,3,21,1,22,3,44,54,32,45,6,7,7,777878,44,1,2,34345};
    //public static int[] testArray = {2,4,3,6,5,1,7};
    // [1, 5, 7, 8, 10, 11, 12, 13]
    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));

        for(int i = 0;i<testArray.length;i++){
            QSort2(testArray, 0, testArray.length - 1,i+1);
        }


    }


    //交换a与b的值
    static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }



    static int Partition2(int[] array, int low, int high) {
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


    static void QSort2(int[] a, int start, int end,int k) {
        if(start==end){
            System.out.println("第 "+k+"小的value = " + a[start]);
        }
        if (start < end) {

            int index =  Partition2(a,start,end);
            if(k-1==index){
                System.out.println("第 "+k+"小的value = " + a[index]);
            }
            if(k-1<index){
                QSort2(a,start,index-1,k);
            }
            if(k-1>index){
                QSort2(a,index+1,end,k);
            }


        }

    }
}

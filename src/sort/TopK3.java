package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class TopK3 {

    public static int[] testArray = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1, 22, 3, 44, 54, 32, 45, 6, 7, 7, 777878, 44, 1, 2, 34345};
    public static int[] testArray1 = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0, 4, 2, 12, 1, 2, 67, 54, 3, 21, 1, 22, 3, 44, 54, 32, 45, 6, 7, 7, 777878, 44, 1, 2, 34345};


    /**
     * 构建K个元素的最小堆
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println("Before sort,array = " + Arrays.toString(testArray));
        heapSort(testArray);
        System.out.println("After sort2,array = " + Arrays.toString(testArray));
        TopK(testArray1, 10);

    }


    public static void heapSort(int[] array) {

        //1. 构建最大堆

        int lastNonChildIndex = array.length / 2 - 1;
        for (int i = lastNonChildIndex; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap2(array, i, array.length);

        }
        for (int i = array.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            //  System.out.println("top  " + array[0]);
            swap(array, 0, i);
            //重新对堆进行调整
            adjustHeap2(array, 0, i);

        }

        //2. 构建最大堆

    }

    public static void TopK(int[] array, int topK) {
        if (topK >= array.length) {
            return;
        }
        int[] tempKArray = new int[topK];
        for (int i = 0; i < topK; i++) {
            tempKArray[i] = array[i];
        }
        System.out.println("before sort2,tempKArray = " + Arrays.toString(tempKArray));
        for (int i = topK / 2 - 1; i >= 0; i--) {
            adjustHeapMin(tempKArray, i, topK);
        }
        System.out.println("top  " + tempKArray[0]);
        for (int i = topK; i < array.length; i++) {
            if (tempKArray[0] < array[i]) {
                tempKArray[0] = array[i];
                for (int j = tempKArray.length - 1; j > 0; j--) {
                    adjustHeapMin(tempKArray, 0, j);
                }
            }
        }
        System.out.println("--------");
        System.out.println("After sort2,tempKArray = " + Arrays.toString(tempKArray));

    }


    public static void adjustHeap2(int[] arr, int parent, int length) {

        int temp = arr[parent];
        int childIndex = parent * 2 + 1;

        while (childIndex < length) {
            //如果有右子节点，并且右子节点大于左子节点，则childIndex自增1
            if (childIndex + 1 < length && arr[childIndex + 1] > arr[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于子节点，则不处理
            if (temp > arr[childIndex]) {
                break;
            }
            //如果父节点小于孩子节点，那就把孩子节点放到父节点上
            arr[parent] = arr[childIndex];
            //把孩子节点的下标赋值给parent
            //让其继续循环以保证大根堆构造正确
            parent = childIndex;
            childIndex = parent * 2 + 1;

        }
        //将刚刚的父节点中的数据赋值给新位置
        arr[parent] = temp;


    }


    public static void adjustHeapMin(int[] arr, int parent, int length) {

        int temp = arr[parent];
        int childIndex = parent * 2 + 1;

        while (childIndex < length) {
            //如果有右子节点，并且右子节点大于左子节点，则childIndex自增1
            if (childIndex + 1 < length && arr[childIndex + 1] < arr[childIndex]) {
                childIndex++;
            }
            // 如果父节点大于子节点，则不处理
            if (temp <= arr[childIndex]) {
                break;
            }
            //如果父节点小于孩子节点，那就把孩子节点放到父节点上
            arr[parent] = arr[childIndex];
            //把孩子节点的下标赋值给parent
            //让其继续循环以保证大根堆构造正确
            parent = childIndex;
            childIndex = parent * 2 + 1;

        }
        //将刚刚的父节点中的数据赋值给新位置
        arr[parent] = temp;


    }


    public static void swap(int[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }


}

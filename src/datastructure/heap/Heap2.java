package datastructure.heap;

/**
 * Created by joybar on 29/10/17.
 */
public class Heap2 {

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void heapSort(int[] arr) {

        buildMaxHeap(arr); // 构建最大堆

        // 将最大堆堆顶元素与数组末尾元素交换，并将前n-1序列重新构造成最大堆,重复n-1次
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 0, i); // 将堆顶元素和当前未经排序的子序列的最后一个元素进行交换
            adjustHeap(arr, 0, i - 1); // 将arr[0...i-1](前i个元素)重新调整为最大堆
        }
    }

    /**
     * 将指定数组arr构建成最大堆
     */
    private void buildMaxHeap(int[] arr) {
        int len = arr.length;
        // 从最后一个非叶子节点往前遍历，将当前序列构成最大堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, len - 1);
        }
    }


    /**
     * 假定arr[begin]的左子树和右子树均满足最大堆，那么调节节点arr[begin]，将以arr[begin]为根节点的二叉树调整为最大堆。
     */
    private void adjustHeap(int[] arr, int begin, int end) {
        int tmp = arr[begin];
        int j;
        for (j = 2 * begin + 1; j <= end; j = 2 * j + 1) {
            // j=2*begin+1表示j对应二叉树节点的左孩子
            if (j + 1 <= end && arr[j] < arr[j + 1]) {
                // 如果当前节点的右孩子存在且左孩子的值小于右孩子
                j++; // j为左右孩子较大记录的下标
            }
            if (tmp >= arr[j]) // tmp的值已经大于arr[j]，则调整完毕，跳出循环
                break;
            arr[begin] = arr[j]; // 当前根节点并未均大于左右节点(如果有的话)，重新给当前根节点赋值
            begin = j; // begin指向新的可能需要进行最大堆调整的子树的根节点
        }
        arr[begin] = tmp;
    }



}

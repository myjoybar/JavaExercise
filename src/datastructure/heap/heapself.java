package datastructure.heap;

/**
 * Created by joybar on 29/10/17.
 */
public class heapself {

    //交换两个数
    public static void swap(int[] array, int i, int j) {
        int tmp;
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

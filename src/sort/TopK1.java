package sort;


import com.sun.tools.javac.util.Pair;

import java.util.Arrays;

/**
 * Created by joybar on 2019/1/8.
 */
public class TopK1 {
    public static int[] testArray = {8,1,3,9,2,4,7,6,5,0,4,2,12,1,2,67,54,3,21,1,22,3,44,54,32,45,6,7,7,777878,44,1,2,34345};

    /**
     * 基于k个临时数据
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("before sort:"+ Arrays.toString(testArray));
        topK1(testArray,5);
    }

    private static void topK1(int[] array, int k) {
        int length = array.length;
        if (length < k) {
            return;
        }

        int[] arrayTopK = new int[k];
        // copy k个临时数据
        for (int i = 0; i < k; i++) {
            arrayTopK[i] = array[i];
        }


        int index = k + 1;
        Pair<Integer,Integer> pair = findMin(arrayTopK);

        for (int j = index; j < length; j++) {
            int min = pair.snd;
            int minIndex = pair.fst;
            if (array[j] > min) {
                arrayTopK[minIndex] = array[j];
                pair = findMin(arrayTopK);
            }
        }

        System.out.println("After sort:"+ Arrays.toString(arrayTopK));
    }


    private static Pair<Integer,Integer> findMin(int[] array) {

        int length = array.length;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
        }
        Pair<Integer,Integer> pair = new Pair<>(minIndex,min);
        return pair;
    }


    private static int findMax(int[] array) {
        int length = array.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

}

package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class Bucket {

    public static int[] test_array = {8, 1, 3, 9, 2, 4, 7, 6, 5, 0};

    public static void main(String[] args) {
        sort(test_array);
    }

    public static void sort(int[] array) {
        System.out.println("Before sort,array = " + Arrays.toString(array));
        int[] fullArray = new int[11];
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength; i++) {
            int sortIndex =array[i];
            fullArray[sortIndex] = fullArray[sortIndex]+1;
        }
        System.out.print("Before sort,array = ");
        int fullArrayLength = fullArray.length;
        for (int i = 0; i < fullArrayLength; i++) {
            if(fullArray[i]!=0){
                for (int k = 0; k < fullArray[i]; k++) {
                    System.out.print(i+" ");
                }
            }
        }

    }

}

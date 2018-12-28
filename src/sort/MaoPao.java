package sort;

import java.util.Arrays;

/**
 * Created by joybar on 2018/12/28.
 */
public class MaoPao {

    public static int[] testArray = {8,1,3,9,2,4,7,6,5,0,4,2,12,1,2,67,54,3,21,1};
    public static void main(String[] args){
        sort(testArray);
    }


    public static void sort(int[] array){
        System.out.println("Before sort:"+ Arrays.toString(array));
        int length = array.length;
        for(int i = 0;i<length-1;i++){
            for(int k =0;k<length-i-1;k++ ){
                if(array[k]>array[k+1]){
                    int temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                }
            }
        }

        System.out.println("After sort:"+ Arrays.toString(array));
    }
}

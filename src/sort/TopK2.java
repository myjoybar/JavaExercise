package sort;


import java.util.Arrays;

/**
 * Created by joybar on 2019/1/8.
 */
public class TopK2 {
    public static int[] testArray = {8,1,3,9,2,4,7,6,5,0,4,2,12,1,2,67,54,3,21,1,22,3,44,54,32,45,6,7,7,777878,44,1,2,34345};

    /**
     * 每冒一个泡，找出最大值，冒k个泡，就得到TopK。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("before sort:"+ Arrays.toString(testArray));
        topK1(testArray,5);
        System.out.println("after sort:"+ Arrays.toString(testArray));
    }

    private static void topK1(int[] array, int k) {
        sort(testArray,5);
    }

    public static void sort(int[] array,int k){

        int length = array.length;
        for(int i = 0;i<k;i++){
            for(int j =0;j<length-i-1;j++ ){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }


    }

}

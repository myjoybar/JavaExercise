package sort;

import java.util.Arrays;

/**
 * 检查一个数组里是否存在m个数的和等于某个值
 * Created by joybar on 20/01/19.
 */
public class MNNUmbers {
    static int[] arr = {1, 2, 5, 3, 7, 4};

    public static void main(String[] args) {

        System.out.println("Before sort,array = " + Arrays.toString(arr));
        hasSum(arr, 18, 2);

    }


    /**
     * 试求能否从数组中取出n个不复用的数的和为sum
     * @param arr
     * @param n
     * @param sum
     * @return
     * https://blog.csdn.net/MrZZhou/article/details/77860278
     */
    static boolean findGroup(int []arr,int n,int sum){
        if(sum == 0 && n == 0){
            return true;
        }else if(n <= 0){
            return false;
        }
        if(n > 0){

            for(int i = 0; i < arr.length; i++){
                int[] temp = slice(arr,i + 1, arr.length);
                boolean flag = findGroup(temp,n-1,sum-arr[i]) || findGroup(temp,n,sum);
                return flag;
            }
        }

        return false;
    }


    static int[] slice(int []arr,int start,int end){
        int[] temp = new int[end-start];
        for (int i = 0; i < end-start; i++) {
            temp[i] = arr[start+i];
        }
        return temp;
    }


    public static boolean hasSum(int[] arr,int maxSum,int k){
        int[] b = new int[k];
        combine(arr,arr.length,k,b,k,maxSum);
        return false;
    }


    /**
     *
     * @param a 初始数组
     * @param n  a包含的元素个数
     * @param m  选出元素的个数
     * @param b  存放结果的数组
     * @param bn  数组b的元素个数，等于m
     * @param s  和
     *   https://blog.csdn.net/wuxinlonga/article/details/10401725
     */
    static  void combine(int a[], int n, int m, int b[], int bn, int s) {
        for (int i = n; i >= m; i--) {
            b[m - 1] = i - 1;
            if (m > 1) { //一共要选m个数，故m = 1时才结束递归
                combine(a, i - 1, m - 1, b, bn, s);
            } else if (isSum(a, b, bn, s)) {
                for (int j = bn - 1; j >= 0; j--) {
                    System.out.println("a[b[j]] = " + a[b[j]]);
                }
            }
        }
    }

    static  boolean isSum(int a[], int b[], int n, int s) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret += a[b[i]];
        }
        return s == ret;

    }


}

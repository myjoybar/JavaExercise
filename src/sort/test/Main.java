package sort.test;

/**
 * Created by joybar on 2019/1/16.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int maxSum;
    public static int index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int m = 0;
        String[] str = sc.nextLine().trim().split(" ");
        for (int i = 0; i < 2; i++) {
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
        }
        //获取第二行输入的数据
        String[] str1 = sc.nextLine().trim().split(" ");
        List<Integer> beginList = new ArrayList<Integer>();
        for (int i = 0; i < str1.length; i++) {
            beginList.add(Integer.parseInt(str1[i]));
        }
        //数组排序，从最小到最大
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (beginList.get(i) > beginList.get(j)) {
                    temp = beginList.get(j);
                    beginList.set(j, beginList.get(i));
                    beginList.set(i, temp);
                }
            }
        }

        int[] iTemp = new int[m];
        computeNum(beginList, n, m, 0, iTemp, 0);
        //打印结果值
        System.out.println(maxSum);


    }

    //从n个数中选m个数，使其和等于剩余n-m数中的数，输出最大数
    public static void computeNum(List<Integer> originList, int n, int m, int startIndex, int[] iTemp, int arrIndex) {
        int sum = 0;
        if (m == 0) {
            for (int j = index + 1; j < n; j++) {
                for (int i = 0; i < iTemp.length; i++)   //计算m个值的和
                {
                    sum += iTemp[i];
                }
                if (sum == originList.get(j)) {
                    maxSum = originList.get(j);
                    break;
                } else if (sum < originList.get(j))   //如果小于，之后就不要考虑了了，结束循环
                {
                    break;
                }
            }

        } else {
            //递归遍历，从n个数选m个数的组合
            int endIndex = n - m;
            for (int i = startIndex; i <= endIndex; i++) {
                iTemp[arrIndex] = originList.get(i);
                index = i;
                computeNum(originList, n, m - 1, i + 1, iTemp, arrIndex + 1);
                //iTemp.remove(iTemp.size()-1);
            }
        }

    }
}



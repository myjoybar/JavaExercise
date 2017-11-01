package datastructure.sort.quicksort;

/**
 * Created by joybar on 2017/10/31.
 */
public class QuickSort2 {
    //http://developer.51cto.com/art/201403/430986.htm
    private static int num = 0;
    int count = 0;
    static void quicksort(int[] a,int left,int right)
    {
        num++;
        int i,j,t,temp;
        if(left>right){
            return;
        }
        temp=a[left]; //temp中存的就是基准数
        i=left;
        j=right;
        while(i!=j)
        {
            //顺序很重要，要先从右边开始找
            while(a[j]>=temp && i<j)
                j--;
            //再找右边的
            while(a[i]<=temp && i<j)
                i++;
            //交换两个数在数组中的位置
            if(i<j)
            {
                t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        //最终将基准数归位
        a[left]=a[i];
        a[i]=temp;
        quicksort(a,left,i-1);//继续处理左边的，这里是一个递归的过程
        quicksort(a,i+1,right);//继续处理右边的 ，这里是一个递归的过程
    }



    public static void main(String[] args) {

        int test[] = {34, 5, 4, 5, 3, 2, 6, 90, 5};

        for (int i: test) {
            System.out.print(i+"_");
        }
        int length = test.length;
        int low = 0;
        int high = length - 1;
        quicksort(test,low,high);
        System.out.println("========"+num);
        for (int i: test) {
            System.out.print(i+"_");
        }
    }
}

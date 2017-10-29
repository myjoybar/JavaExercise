package datastructure.heap;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        int[] a = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
                62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

       // printArray(a);
        Heap1 heap1 = new Heap1();
        heap1.test(a);
        printArray(a);


        int[] a2 = new int[]{49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4,
                62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

       //printArray(a2);
        Heap2 heap2 = new Heap2();
        heap2.heapSort(a2);
        printArray(a2);
    }




    private static void printArray( int[] a){
        System.out.println("=====");
        long t1 = System.nanoTime();
        for(int i : a) {
            System.out.print(i + " ");
        }

        System.out.println();
        long t2 = System.nanoTime();
        System.out.println("====="+(t2-t1));
    }

}

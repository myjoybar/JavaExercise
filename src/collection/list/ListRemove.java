package collection.list;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by joybar on 2017/7/5.
 */
public class ListRemove {

    public static void main(String[] args) {

        BlockingQueue<Integer> adServiceQueue  = new LinkedBlockingDeque<>();
        adServiceQueue.add(1);
        adServiceQueue.add(2);
        adServiceQueue.add(3);
        adServiceQueue.add(4);

        for (Integer i : adServiceQueue) {
            System.out.println("ia="+i);
        }
        System.out.println("===========");
        for (Integer i : adServiceQueue) {
            System.out.println("ib="+i);
            if (i==2) {
                System.out.println("ib="+i);
                adServiceQueue.remove(i);
            }
        }
        System.out.println("===========");
        for (Integer i : adServiceQueue) {
            System.out.println("ic="+i);
        }

//
//        Iterator it = adServiceQueue.iterator();
//        while(it.hasNext()) {
//            int i = (int) it.next();
//            System.out.println("ia="+i);
//        }
//
//        System.out.println("===========");
//
//        while(it.hasNext()) {
//            int i = (int) it.next();
//            if (i==2) {
//                it.remove();
//            }
//        }
    }


}

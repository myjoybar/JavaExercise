package objectpool;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by joybar on 2017/10/9.
 */
public class ObjectPool {

//    private int numObjects = 10; // 对象池的大小
//    private int maxObjects = 50; // 对象池最大的大小
//    private Vector objects = null; //存放对象池中对象的向量( PooledObject类型)
//
//    public ObjectPool() {
//
//    }
//
//    /*** 创建一个对象池***/
//    public synchronized void createPool() {
//        // 确保对象池没有创建。如果创建了，保存对象的向量 objects 不会为空
//        if (objects != null) {
//            return; // 如果己经创建，则返回
//        }
//
//        // 创建保存对象的向量 , 初始时有 0 个元素
//        objects = new Vector();
//
//        // 根据 numObjects 中设置的值，循环创建指定数目的对象
//        for (int x = 0; x < numObjects; x++) {
//            if ((objects.size() == 0) && this.objects.size() < this.maxObjects) {
//                Object obj = new Object();
//                objects.addElement(new PooledObject(obj));
//            }
//        }
//
//    }
//
//    public synchronized Object getObject() {
//        // 确保对象池己被创建
//        if (objects == null) {
//            return null; // 对象池还没创建，则返回 null
//        }
//
//        Object conn = getFreeObject(); // 获得一个可用的对象
//
//        // 如果目前没有可以使用的对象，即所有的对象都在使用中
//        while (conn == null) {
//            wait(250);
//            conn = getFreeObject(); // 重新再试，直到获得可用的对象，如果
//            // getFreeObject() 返回的为 null，则表明创建一批对象后也不可获得可用对象
//        }
//
//        return conn;// 返回获得的可用的对象
//    }
//
//    /**
//     * 本函数从对象池对象 objects 中返回一个可用的的对象，如果
//     * 当前没有可用的对象，则创建几个对象，并放入对象池中。
//     * 如果创建后，所有的对象都在使用中，则返回 null
//     */
//    private Object getFreeObject() {
//
//        // 从对象池中获得一个可用的对象
//        Object obj = findFreeObject();
//
//        if (obj == null) {
//            createObjects(incrementalObjects);     //如果目前对象池中没有可用的对象，创建一些对象
//
//            // 重新从池中查找是否有可用对象
//            obj = findFreeObject();
//
//            // 如果创建对象后仍获得不到可用的对象，则返回 null
//            if (obj == null) {
//                return null;
//            }
//        }
//
//        return obj;
//    }
//
//
//    /**
//     * 查找对象池中所有的对象，查找一个可用的对象，
//     * 如果没有可用的对象，返回 null
//     */
//    private Object findFreeObject() {
//
//        Object obj = null;
//        PooledObject pObj = null;
//
//        // 获得对象池向量中所有的对象
//        Enumeration enumerate = objects.elements();
//
//        // 遍历所有的对象，看是否有可用的对象
//        while (enumerate.hasMoreElements()) {
//            pObj = (PooledObject) enumerate.nextElement();
//
//            // 如果此对象不忙，则获得它的对象并把它设为忙
//            if (!pObj.isBusy()) {
//                obj = pObj.getObject();
//                pObj.setBusy(true);
//            }
//
//        }
//        return obj;// 返回找到到的可用对象
//
//    }
//
//    /**
//     * 使程序等待给定的毫秒数
//     */
//    private void wait(int mSeconds) {
//        try {
//            Thread.sleep(mSeconds);
//        } catch (InterruptedException e) {
//        }
//    }


}

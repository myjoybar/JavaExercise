package data;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by joybar on 2017/6/27.
 */
public class ManagerData {

    BlockingQueue<User> blockingQueue = new LinkedBlockingDeque<>();
    BlockingQueue<User> blockingQueueCopy = new LinkedBlockingDeque<>();


    public BlockingQueue<User> getBlockingQueue() {
        return blockingQueue;
    }

    public void setBlockingQueue(BlockingQueue<User> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public BlockingQueue<User> getBlockingQueueCopy() {
        return blockingQueueCopy;
    }

    public void setBlockingQueueCopy(BlockingQueue<User> blockingQueueCopy) {
        this.blockingQueueCopy = blockingQueueCopy;
    }

    public void resetData() throws Throwable {
        blockingQueueCopy.clear();
        blockingQueueCopy = null;

        System.out.println("——————————————————————————11111");
        finalize();
       // System.gc();
        System.out.println("——————————————————————————2222");
        blockingQueueCopy = new LinkedBlockingDeque<>();
        blockingQueueCopy.addAll(blockingQueue);

    }

}

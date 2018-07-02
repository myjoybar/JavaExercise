package thread.customThreadPool.ThreadFactory;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by joybar on 01/07/18.
 */
public class CustomThreadFactory {


    public static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);

        public Thread newThread(Runnable r) {
            return new Thread(r, "CustomThreadFactory #" + mCount.getAndIncrement());
        }
    };
}

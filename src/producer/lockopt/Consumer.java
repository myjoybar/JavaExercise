package producer.lockopt;

/**
 * Created by joybar on 2019/1/16.
 */
public interface Consumer {
    void consume() throws InterruptedException;
}
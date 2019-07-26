package producer.lockopt;

/**
 * Created by joybar on 2019/1/16.
 */
public interface Model {
    Runnable newRunnableConsumer();

    Runnable newRunnableProducer();
}
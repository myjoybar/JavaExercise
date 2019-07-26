package producer.lockopt;

/**
 * Created by joybar on 2019/1/16.
 */
abstract class AbstractConsumer implements Consumer, Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}


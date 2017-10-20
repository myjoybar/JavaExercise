package thread.Executors2;

/**
 * Created by joybar on 2017/10/19.
 */
public class LiftOff implements Runnable{
    //http://blog.csdn.net/javazejian/article/details/50890554
    protected int countDown = 10; //Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + ") ";
    }
    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }

    }
}

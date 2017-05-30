package designpattern.singleton;

/**
 * Created by joybar on 29/05/17.
 */
public enum SomeThing6 {
    INSTANCE;
    private Singleton6 instance;
    SomeThing6() {
        instance = new Singleton6();
    }
    public Singleton6 getInstance() {
        return instance;
    }
    // SomeThing6.INSTANCE.getInstance()
}

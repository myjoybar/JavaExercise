package observable;

import java.util.Observable;

/**
 * Created by joybar on 2017/11/27.
 */
public class MyObservable extends Observable {

    public void setData(){
        setChanged();
        /**
         * 这里的参数将作为内部Observer的undata()方法的第二个参数，而且是调用每一个Observer的updata()方法
         * 在方法内部：
         * for (int i = arrLocal.length-1; i>=0; i--)
         * arrLocal[i].update(this, arg);
         */
        notifyObservers("老子发生改变了");
    }
}


package designpattern.Observer.interfaces;

import designpattern.Observer.Subject;

/**
 * Created by joybar on 30/05/17.
 */
public abstract class Observer {

    protected Subject subject;
    public abstract void update();
}

package designpattern.State;

import designpattern.State.interfaces.State;

/**
 * Created by joybar on 30/05/17.
 */
public class Context {

    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}

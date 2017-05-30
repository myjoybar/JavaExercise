package designpattern.State;

import designpattern.State.interfaces.State;

/**
 * Created by joybar on 30/05/17.
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}

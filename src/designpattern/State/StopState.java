package designpattern.State;

import designpattern.State.interfaces.State;

/**
 * Created by joybar on 30/05/17.
 */
public class StopState  implements State {

    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
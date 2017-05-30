package designpattern.Bridge;

import designpattern.Bridge.interfaces.DrawAPI;

/**
 * Created by joybar on 30/05/17.
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}

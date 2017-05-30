package designpattern.Bridge.interfaces;

/**
 * Created by joybar on 30/05/17.
 */
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
package test.base;

/**
 * Created by joybar on 2017/8/25.
 */
public class BaseAction {

    protected void init11(){
        init();
    }

    private void init(){
        doAction();
    }


    protected void  doAction(){
        System.out.println("==============BaseAction");
    }

}

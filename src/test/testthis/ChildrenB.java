package test.testthis;

/**
 * Created by joybar on 13/10/17.
 */
public class ChildrenB extends ParentA {

    public void getIntent(ParentA parentA){}


    public static void main(String[] args) {



    }

    private void test(){
        System.out.println("Hello World!");
        getIntent(ChildrenB.this);
    }

}

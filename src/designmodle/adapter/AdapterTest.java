package designmodle.adapter;

/**
 * Created by joybar on 2017/5/17.
 */
public class AdapterTest {


    public static void main(String[] args) {

        ClassAdapter adapter = new ClassAdapter();

        System.out.println(" adapter.getVolt5()=" + adapter.getVolt5());
        System.out.println(" adapter.getVolt5()=" + adapter.getVolt220());

        ObjectAdapter adapter1 = new ObjectAdapter(new Volt220());
        System.out.println("输出电压 : " + adapter1.getVolt5());

    }


    /**
     * Target角色
     */
    public static interface FiveVolt {
        public int getVolt5();
    }

    /**
     * Adaptee角色,需要被转换的对象
     */
    public static class Volt220 {
        public int getVolt220() {
            return 220;
        }
    }


    // adapter角色  类适配器模式
    public static class ClassAdapter extends Volt220 implements FiveVolt {

        @Override
        public int getVolt5() {
            return 5;
        }

    }


    // 对象适配器模式
    public static class ObjectAdapter implements FiveVolt {

        Volt220 mVolt220;

        public ObjectAdapter(Volt220 adaptee) {
            mVolt220 = adaptee;
        }

        public int getVolt220() {
            return mVolt220.getVolt220();
        }

        @Override
        public int getVolt5() {
            return  getVolt220();
        }

    }
}

package designmodle.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joybar on 2017/5/17.
 */
public class ObserveTest {



    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Observers observers1 = new Observers("王大锤");
        Observers observers2 = new Observers("黄晓明");
        Observers observers3 = new Observers("郑恺");
        Observers observers4 = new Observers("邓超");

        Angelababy angelababy = new Angelababy();

        // 注册添加观察者
        angelababy.addObservers(observers1);
        angelababy.addObservers(observers2);
        angelababy.addObservers(observers3);
        angelababy.addObservers(observers4);

        // 发出通知消息
        angelababy.notifyAllObservers("我不开心");
        //删除观察者
        angelababy.deleteObservers(observers1);
        System.out.println("---------------------");
        angelababy.notifyAllObservers("我不开心");



    }





    /**
     *
     * 抽象观察者
     *
     */
    public interface IObserver {
        public void UpdateMsg(String msg);
    }



    /**
     *
     * 具体观察者
     * 屌丝男一
     */
    public static class Observers implements IObserver {
        private String name;

        public  Observers(String name) {
            this.name = name;
        }

        @Override
        public void UpdateMsg(String msg) {
            // TODO 自动生成的方法存根
            if ("我不开心".equals(msg)) {
                System.out.println(name+"说： 多喝热水");
            }
        }

    }




    public interface IPrettyGirl {
        public void addObservers(IObserver observers);//添加观察者

        public void deleteObservers(IObserver observers);//删除观察者

        public void notifyAllObservers(String msg);//通知所有的观察者
    }


    public static class Angelababy implements IPrettyGirl {

        // 观察者集合
        private List<IObserver> mList = new ArrayList<IObserver>();// 注意这里集合的泛型用的是接口类型

        public void addObservers(IObserver observers) {
            mList.add(observers);
        }

        @Override
        public void deleteObservers(IObserver observers) {
            mList.remove(observers);
        }

        @Override
        public void notifyAllObservers(String msg) {
            for (IObserver list : mList) {
                list.UpdateMsg(msg);
            }
        }

    }
}

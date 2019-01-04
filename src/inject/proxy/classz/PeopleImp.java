package inject.proxy.classz;

/**
 * Created by joybar on 2019/1/4.
 */
public class PeopleImp implements People {
    public String run() {
        System.out.println("run ");
        return "run";
    }

    @Override
    public String say() {
        System.out.println("say ");
        return "say";
    }
}

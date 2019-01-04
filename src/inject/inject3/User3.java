package inject.inject3;

/**
 * Created by joybar on 2019/1/4.
 */
public class User3 {
    private String name;
    public String age;

    private User3() {
    }

    public User3(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

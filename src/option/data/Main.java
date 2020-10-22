package option.data;

import option.OptionalBean;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        School school = new School();
        user.setName("Tom");

        String scName = OptionalBean.ofNullable(user)
                .getBean(User::getSchool)
                .getBean(School::getAddress)
                .get();
        System.out.println(scName);
    }
}

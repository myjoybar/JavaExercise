package json.data;

import java.util.Arrays;
import java.util.List;

/**
 * Created by joybar on 2017/9/14.
 */
public class ClassBean {

    /**
     * className : 9班
     * amount : 30
     * students : [{"name":"rose","age":"25"},{"name":"jack","age":"26"}]
     */

    private String className;
    private int amount;
    private List<StudentsBean> students;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<StudentsBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentsBean> students) {
        this.students = students;
    }

    public static class StudentsBean {
        public StudentsBean(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public StudentsBean() {
        }

        /**
         * name : rose
         * age : 25
         */


        private String name;
        private String age;

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

        @Override
        public String toString() {
            return "StudentsBean{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ClassBean{" +
                "className='" + className + '\'' +
                ", amount=" + amount +
                ", students=" + Arrays.toString(students.toArray()) +
                '}';
    }
}

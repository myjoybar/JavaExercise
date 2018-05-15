package exception;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!" + Test());
//        Test2("q");
//        Test2("Call腾展");
    }

    static int Test() {
        try {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    int a = 5 / 0;
                }
            }.start();

            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            // return 3;
        }


    }


    static void Test2(String a) {
        byte[] buff = a.getBytes();
        int f = buff.length;
        System.out.println(f);
    }

    static int Testww22() {
        try {
            int a = 5 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            return 3;
        }
    }


}

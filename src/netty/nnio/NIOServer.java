package netty.nnio;

import java.io.IOException;

/**
 * Created by joybar on 2019/7/18.
 * https://www.cnblogs.com/duanxz/p/6759689.html
 */
public class NIOServer {

    public static void main(String[] args) throws IOException {

        new Thread(new ServerReactorTask()).start();

    }





}

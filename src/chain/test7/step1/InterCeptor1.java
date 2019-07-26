package chain.test7.step1;

import chain.test7.Action;
import chain.test7.ProgressInterceptor;
import chain.test7.Store;

/**
 * Created by joybar on 2019/6/11.
 */
public class InterCeptor1 implements ProgressInterceptor {
    @Override
    public void doFilter(Action action, Store store, ProgressInterceptor chainFilter) {

    }
}

package chain.test7;

/**
 * Created by joybar on 2019/6/11.
 */
public interface ProgressInterceptor<A extends Action,S extends Store> {

    void doFilter(A action, S store, ProgressInterceptor chainFilter);
}

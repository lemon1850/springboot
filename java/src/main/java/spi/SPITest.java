package spi;

import java.util.ServiceLoader;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-25
 * @Version 1.0
 */
public class SPITest {

    public static void main(String[] args) {
//        ServiceLoader<Query> loader = ServiceLoader.load(Query.class);
//        loader.forEach(Query::query);

        boolean syncFinish = 0 == 0 && 1000> 500;
        System.out.println(syncFinish);
        Stack a = new Stack();



    }
}

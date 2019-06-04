package spi;

import org.apache.dubbo.common.extension.ExtensionLoader;

import java.security.cert.Extension;
import java.util.ServiceLoader;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-25
 * @Version 1.0
 */
public class SPITest {

    public static void main(String[] args) {

//        ServiceLoader<Query> loader = ServiceLoader.load(Query.class);
//        loader.forEach(Query::query);

        ExtensionLoader<Query> extensionLoader = ExtensionLoader.getExtensionLoader(Query.class);
        Query miaomi = extensionLoader.getExtension("miaomi");
        miaomi.query();
        Query computer = extensionLoader.getExtension("computer");
        computer.query();
    }
}

package spi;

import org.apache.dubbo.common.extension.SPI;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-25
 * @Version 1.0
 */
@SPI
public interface Query {

    void query();
}

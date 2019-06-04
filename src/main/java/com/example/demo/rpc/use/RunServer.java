package com.example.demo.rpc.use;

import com.example.demo.rpc.server.MessageRecvExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-12
 * @Version 1.0
 */
public class RunServer {

    public static void main(String[] args) throws Exception{

        MessageRecvExecutor messageRecvExecutor = new MessageRecvExecutor("127.0.0.1:18888");
        Map<String, Object> map = new HashMap<>();
        map.put("com.example.demo.rpc.use.Calculate", new CalculateImpl());
        messageRecvExecutor.setHandlerMap(map);
        messageRecvExecutor.afterPropertiesSet();

    }
}

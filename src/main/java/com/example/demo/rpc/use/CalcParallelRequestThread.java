package com.example.demo.rpc.use;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-11
 * @Version 1.0
 */
import com.example.demo.rpc.client.MessageSendExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalcParallelRequestThread implements Runnable {

    private CountDownLatch signal;
    private CountDownLatch finish;
    private MessageSendExecutor executor;
    private int taskNumber = 5;

    public CalcParallelRequestThread(MessageSendExecutor executor, CountDownLatch signal, CountDownLatch finish, int taskNumber) {
        this.signal = signal;
        this.finish = finish;
        this.taskNumber = taskNumber;
        this.executor = executor;
    }

    @Override
    public void run() {
        try {
            signal.await();

            Calculate calc = executor.execute(Calculate.class);
            int add = calc.add(taskNumber, taskNumber);
            System.out.println("calc add result:[" + add + "]");

            finish.countDown();
        } catch (InterruptedException ex) {
            Logger.getLogger(CalcParallelRequestThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
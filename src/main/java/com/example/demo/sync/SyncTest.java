package com.example.demo.sync;

import java.util.concurrent.TimeUnit;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-20
 * @Version 1.0
 */
public class SyncTest {


    public static void main(String[] args) {

        Thread a = new Thread(new Task1(), "Task1开始");
        Thread b = new Thread(new Task2(a), "Task2开始");
        a.start();
//        b.start();
//        a.interrupt();
    }


    static class Task1 implements Runnable{
        @Override
        public void run() {
            System.out.println("Task1开始执行");

            synchronized (SyncTest.class){

                System.out.println("Task1获取到锁");
                try{

                    SyncTest.class.wait(2000);
                    System.out.println("Task1重新获取到锁");


                }catch (Exception e){
                    System.out.println("Task1被中断");
                }
                System.out.println("Task1获取锁结束");

            }

        }
    }

    static class Task2 implements Runnable{

        private Thread thread;

        public Task2(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {

            System.out.println("Task2开始执行");
            try{

                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("被中断了");
            }
            synchronized (SyncTest.class){


                System.out.println("Task2获取到锁");
                try{

//                    thread.interrupt();
                    Thread.sleep(20000);
                }catch (InterruptedException e){
                    System.out.println("Task2被中断了");
                }
                SyncTest.class.notify();
                System.out.println("Task2获取到锁结束");

            }

        }
    }
}

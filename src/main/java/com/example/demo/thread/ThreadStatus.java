package com.example.demo.thread;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-19
 * @Version 1.0
 */
public class ThreadStatus {

    public static void main(String[] args) {


        new Thread(new Waiting(), "Waiting").start();
        new Thread(new WaitTime(),"WaitingTIme").start();
        new Thread(new Block(), "Block1").start();
        new Thread(new Block(), "Block2").start();
    }



    static class Waiting implements Runnable{


        @Override
        public void run(){

           while (true){

               synchronized (Waiting.class){
                   try {
                       Waiting.class.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           }

        }
    }


    static class WaitTime implements Runnable{
        @Override
        public void run() {

            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Block implements Runnable{
        @Override
        public void run() {

            synchronized (Block.class){

                while (true){
                    try {
                        System.out.println(Thread.currentThread().getName());

                        Block.class.wait();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

package com.example.demo.leetcode;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-03
 * @Version 1.0
 */
public class MyCircularQueue {

    int[] queue = {};
    int count;
    int head;
    int tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {

        queue = new int[k];

    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {

        if(!isFull()){
            queue[tail] = value;
            if(++tail == queue.length){
                tail = 0;
            }
            count++;
            return true;

        }else {
            return false;
        }

    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {

        if(!isEmpty()){

            if(++head == queue.length){
                head = 0;
            }
            count--;
            return true;

        }else {
            return false;
        }

    }

    /** Get the front item from the queue. */
    public int Front() {

        if(isEmpty()){
            return -1;
        }
        return queue[head];

    }

    /** Get the last item from the queue. */
    public int Rear() {

        if(isEmpty()){
            return  -1;
        }
        if(tail==0){
            return queue[queue.length-1];
        }
        return queue[tail-1];

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {

        return count==0;

    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {

        return count==queue.length;
    }

    public static void main(String[] args) {
          MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.enQueue(1));
        System.out.println(obj.enQueue(2));
        System.out.println(obj.enQueue(3));
        System.out.println(obj.enQueue(4));
        System.out.println(obj.deQueue());
        System.out.println(obj.Rear());
        System.out.println(obj.isFull());
        System.out.println(obj.deQueue());
        System.out.println(obj.enQueue(4));
        System.out.println(obj.Rear());

    }
}

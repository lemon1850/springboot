package com.example.demo.collections;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-03
 * @Version 1.0
 */
public class HowToUseCollection {


    public static void main(String[] args) {
//        List<Integer> list = {};
//        a[0] = 4;
//        System.out.println(JSON.toJSONString(a, true));

        ArrayDeque a = new ArrayDeque();
        a.addFirst(1);
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        ReentrantReadWriteLock rlock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.WriteLock writeLock = rlock.writeLock();
        ReentrantReadWriteLock.ReadLock  readLock = rlock.readLock();
        readLock.tryLock();
        writeLock.tryLock();
    }

}

package com.example.demo.reactor;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReactorTest {

    public static void main(String[] args) {
//        Flux<Integer> list = Flux.range(4,6);
//        list.subscribe(a->a.toString()).dispose();


//        Flux<String> sql = Flux.just("a", "吧", "dd").lim
//        sql.subscribe(a-> System.out.println(a)).dispose();

//        Flux.create().map().onErrorResume()
//                Flux.error()

        numJewelsInStones("aA", "aAAbbbb");

    }


    public static  int numJewelsInStones(String J, String S) {

        int i = 0;
        Map baoshi = new HashMap();
        for(String b: J.split("")){
            baoshi.put(b, 1);
        }
        for(String q: S.split("")){
            if(baoshi.get(q)!=null){
                i++;
            }
        }
        return i;

    }
}

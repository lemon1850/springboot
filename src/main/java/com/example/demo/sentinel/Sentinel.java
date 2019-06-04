package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class Sentinel {

    public static void main(String[] args) {

        Sentinel a = new Sentinel();
        initFlowRules();
//        while (true){
//            a.helloMiaomi();
//        }
        while (true){
            Entry entry = null;
            try {
                entry = SphU.entry("helloWorld");
                System.out.println("aaaaaaaa");
            }catch (BlockException e){
                System.out.println("block");
            }finally {
                if(entry !=null){
                    entry.exit();
                }
            }
//            try{
//
//                Thread.sleep(10);
//            }catch (InterruptedException e){
//                System.out.println(e);
//            }
        }


    }

    @SentinelResource("miaomi")
    public  void helloMiaomi(){
        System.out.println("miaomi");
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("helloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRule rule2 = new FlowRule();
        rule2.setResource("miaomi");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(20);


        FlowRuleManager.loadRules(rules);

    }
}

package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class Sentinel2 {

    public static void main(String[] args) {

        initFlowRules();

        while (true){

            if(SphO.entry("helloWorld")){
                try{
                    System.out.println("成功");
                }finally {
                    SphO.exit();
                }
            }else {
                System.out.println("block");
            }

            try{

                Thread.sleep(10);
            }catch (InterruptedException e){
                System.out.println(e);
            }
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
        FlowRuleManager.loadRules(rules);

    }
}

package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.system.SystemRule;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SentinelZhujie implements InitializingBean {

    public static void main(String[] args) {

        initFlowRules();


    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("----------------PPPPPPPPPPPPPPPPPPPPPPPPPPPP");
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("helloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);

//        DegradeRule degradeRule = new DegradeRule();
//        SystemRule systemRule = new SystemRule();
//        AuthorityRule authorityRule = new AuthorityRule();

        FlowRuleManager.loadRules(rules);
    }

    private static void initFlowRules(){
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule rule = new FlowRule();
//        rule.setResource("helloWorld");
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule.setCount(20);
//        rules.add(rule);
//
////        DegradeRule degradeRule = new DegradeRule();
////        SystemRule systemRule = new SystemRule();
////        AuthorityRule authorityRule = new AuthorityRule();
//
//        FlowRuleManager.loadRules(rules);

    }
}

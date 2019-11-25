package com.ldy.controller.strategyPattern;

import com.ldy.common.pattern.strategyPattern.QueryBizService_Demo1;
import com.ldy.common.pattern.strategyPattern.QueryBizService_Demo2;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/nack/pattern")
@Api(tags = {"策略模式测试接口"})
public class StrategyPatternController {
    @Autowired
    private QueryBizService_Demo1 queryBizService_demo1;

    @Autowired
    private QueryBizService_Demo2 queryBizService_demo2;

    @RequestMapping(value = "/test1", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> query1(String type){
        return queryBizService_demo1.query(type);
    }


    @RequestMapping(value = "/test2",method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, String> query2(String type){
        return queryBizService_demo2.queryMap(type);
    }
}

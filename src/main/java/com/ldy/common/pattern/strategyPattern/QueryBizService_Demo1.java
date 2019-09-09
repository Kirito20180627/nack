package com.ldy.common.pattern.strategyPattern;

import com.ldy.common.utils.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryBizService_Demo1 {

    /**
     * 注入List的时候如果要按顺序注入，加@Order(1)，@Order(2)，@Order(3)注解，数字越小顺序越靠前
     *
     *  还有 @Qualifier 和 @LoadBalanced，帮助区分要注入的类
     */
    @Autowired
    private List<QueryProcessor> queryProcessor;
    public Map<String, String> query(String type) {
        Map<String, String> request =new HashMap<>();
        Map<String, String> result = new HashMap<>();
        if (StringUtil.isNotEmpty(type)) {
            request.put("type", type);
        }
        queryProcessor.forEach(f->{
            if (f.check(request, result)) {
                f.handle(request, result);
            }
        });
        return result;
    }
}

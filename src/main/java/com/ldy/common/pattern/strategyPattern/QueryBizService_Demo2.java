package com.ldy.common.pattern.strategyPattern;

import com.ldy.common.utils.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QueryBizService_Demo2 {

    @Autowired
    private Map<String, QueryProcessor> handleMap;
    public Map<String, String> queryMap(String type) {
        Map<String, String> request = new HashMap<>();
        Map<String, String> result = new HashMap<>();
        if (StringUtil.isNotEmpty(type)) {
            request.put("type", type);
        }
        handleMap.get(type).handle(request, result);
        return result;
    }
}

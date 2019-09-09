package com.ldy.common.pattern.strategyPattern;

import com.ldy.common.utils.string.StringUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component("c")
public class QueryCProcessor implements QueryProcessor {
    @Override
    public boolean check(Map<String, String> request, Map<String, String> result) {

        if (StringUtil.equals(request.get("type"), "c") || Objects.isNull(request.get("type"))) {
            return true;
        }
        return false;
    }

    @Override
    public void handle(Map<String, String> request, Map<String, String> result) {
        result.put("C", "item_C");
    }
}

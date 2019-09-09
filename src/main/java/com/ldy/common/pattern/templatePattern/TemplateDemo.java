package com.ldy.common.pattern.templatePattern;

import java.util.HashMap;
import java.util.Map;

public class TemplateDemo {
    public Map<String, String> query(String id){
        TemplateBizService templateBizService = new TemplateBizService();
        Map<String, String> map = new HashMap<>();
        BaseBizResult<String> b = templateBizService.query(id);
        if (b.isSucceed()) {
            map.put("success", b.getData());
        }else {
            map.put(b.getErrorCode(), b.getErrorMsg());
        }
        return map;
    }
}

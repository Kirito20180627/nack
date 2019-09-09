package com.ldy.common.pattern.strategyPattern;

import org.springframework.stereotype.Component;

import java.util.Map;


public interface QueryProcessor {

    boolean check(Map<String, String> request, Map<String, String> result);

    void handle(Map<String, String> request, Map<String, String> result);

}

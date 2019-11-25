package com.ldy.common.pattern.chainPattern.p_2;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)
@Component
public class Manager extends AbstractClerk {

    public Manager() {
        super.type = "Manager";
    }
    @Override
    public int getAllMoney() {
        return 10000;
    }
}

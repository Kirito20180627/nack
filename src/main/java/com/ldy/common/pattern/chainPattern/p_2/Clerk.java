package com.ldy.common.pattern.chainPattern.p_2;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class Clerk extends AbstractClerk{

    public Clerk() {
        super.type = "Clerk";
    }

    @Override
    public int getAllMoney() {
        return 100;
    }
}

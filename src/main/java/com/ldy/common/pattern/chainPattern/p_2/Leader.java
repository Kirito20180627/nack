package com.ldy.common.pattern.chainPattern.p_2;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class Leader extends AbstractClerk {

    public Leader() {
        super.type = "Leader";
    }

    @Override
    public int getAllMoney() {
        return 1000;
    }
}

package com.ldy.common.pattern.chainPattern.p_1;


public class Leader extends AbstractClerk {
    public Leader() {
        super.type = "Leader";
    }

    @Override
    public int getAllMoney() {
        return 1000;
    }
}

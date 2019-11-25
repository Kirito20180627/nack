package com.ldy.common.pattern.chainPattern.p_1;


public class Manager extends AbstractClerk {

    public Manager() {
        super.type = "Manager";
    }

    @Override
    public int getAllMoney() {
        return 10000;
    }
}

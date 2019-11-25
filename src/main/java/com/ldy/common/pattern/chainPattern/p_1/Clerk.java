package com.ldy.common.pattern.chainPattern.p_1;


public class Clerk extends AbstractClerk {

    public Clerk() {
        super.type = "Clerk";
    }

    @Override
    public int getAllMoney() {
        return 100;
    }
}

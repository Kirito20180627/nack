package com.ldy.common.pattern.chainPattern.p_1;

public class Main {

    /** 初级阶段，需要手动设置链条 */
    public static void main(String[] args) {

        AbstractClerk clerk = new Clerk();
        AbstractClerk leader = new Leader();
        AbstractClerk manager = new Manager();

        /**
         * 拼接链条
         */
        clerk.setSuperior(leader);
        leader.setSuperior(manager);

        /**
         * 将任务放到链条里
         */
        clerk.approveRequest(new Client(1000));
    }
}


package com.ldy.common.utils.token;

public class InitToken {
    private static volatile String token = "nothing";
    public static void createToken(String userName){
        if (token.equals("nothing")) {
            synchronized (InitToken.class) {
                if (token.equals("nothing")) {
                    JwtUtil.generateToken(userName);
                    token = JwtUtil.getToken(userName);
                }
            }
        }
    }
}

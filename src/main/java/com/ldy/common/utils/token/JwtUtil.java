package com.ldy.common.utils.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * java web token 管理工具
 */
public class JwtUtil {

    private static final Logger log = LoggerFactory.getLogger(JwtUtil.class);

    // 签名秘钥
    private final static String TOKEN_SECRET = "com.ldy.nack";

    // token过期时间
    private final static long EXPIRE_TIME = TimeUnit.MINUTES.toMillis(1);

    private final static String USER_NAME = "userName";

    private static Map<String, String> tokensMap = new ConcurrentHashMap<>();

    public static String getToken(String userName) {
        String result = null;
        if (tokensMap.containsKey(userName)) {
            result = tokensMap.get(userName);
        } else {
            result = readToken(userName);
        }
        return Optional.ofNullable(result).orElse("nothing");
    }


    // 生成token
    public static void generateToken(String userName) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            String token = JWT.create()
                    .withClaim(USER_NAME, userName)
                    .withExpiresAt(date)
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
            storeToken(userName, token);
            tokensMap.put(userName, token);
        } catch (Exception e) {
            log.info("生成token失败");
            e.printStackTrace();
        }
    }

    // 验证token是否过期
    public static boolean verifyToken(String token, String userName) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withClaim(USER_NAME, userName).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 获取token中的信息
    public static String getValueInToken(String token, String key) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getClaim(key).asString();
    }

    // 存储token
    public static void storeToken(String userName, String token) {
        OutputStream output = null;
        try {
//            File directory = new File();
//            if (!directory.exists()) {
//                directory.mkdir();
//            }
            File file = new File(userName + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            output = new FileOutputStream(file);
            output.write(token.getBytes("utf-8"));
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 读取token
    public static String readToken(String userName) {
        String token = null;
        BufferedReader reader = null;
        File file = new File(userName + ".txt");
        try {
            if (file.exists()) {
                InputStream input = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
                token = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.ofNullable(token).orElse("nothing");
    }

    class CreateToken {
        private volatile boolean isSuccess = false;
        public void createToken(String client) {
            if (isSuccess == false) {
                synchronized (JwtUtil.class) {
                    generateToken(client);
                    isSuccess = true;
                }
            }
        }

    }
}

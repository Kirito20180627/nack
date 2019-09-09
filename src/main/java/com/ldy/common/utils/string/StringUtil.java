package com.ldy.common.utils.string;

import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {
    public static boolean isEmpty(final CharSequence str) {
        return  (str == null || str.length() == 0);
    }

    public static boolean isNotEmpty(final CharSequence str) {
        return !isEmpty(str);
    }

    public static boolean equals(final CharSequence str1, final CharSequence str2) {
        if (str1 == str2) {
            return true;
        }
        if ((str1 == null) || (str2 == null)) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        if ((str1 instanceof String) && (str2 instanceof String)) {
            return str1.equals(str2);
        }
        return false;
    }
}

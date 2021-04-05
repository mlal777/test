package com.app.compare.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParsers {
    public static String getAsinFromAmazonUrl(String url) {
        String asinPattern = "/([a-zA-Z0-9]{10})(?:[/?]|$)";
        Pattern pattern = Pattern.compile(asinPattern);
        Matcher matcher = pattern.matcher(url);

        String asin = "";
        if (matcher.find()) {
            asin = matcher.group(1);
        }
        return asin;
    }
}
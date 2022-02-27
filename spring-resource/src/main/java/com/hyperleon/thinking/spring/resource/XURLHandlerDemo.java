package com.hyperleon.thinking.spring.resource;

import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author leon
 * @date 2022-02-27 10:37
 **/
public class XURLHandlerDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("x:///META-INF/default.properties");
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}

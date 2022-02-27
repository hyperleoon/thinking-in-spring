package com.hyperleon.thinking.spring.resource.springx;

import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author leon
 * @date 2022-02-27 10:39
 **/
public class Handler extends sun.net.www.protocol.x.Handler {

    //-Djava.protocol.handler.pkgs=com.hyperleon.thinking.spring.resource
    public static void main(String[] args) throws Exception {
        URL url = new URL("springx:///META-INF/default.properties");
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}

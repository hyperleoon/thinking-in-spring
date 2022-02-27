package com.hyperleon.thinking.spring.resource.ext;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author leon
 * @date 2022-02-27 09:47
 **/
public interface ResourceUtil {

    static String  readContent(Resource resource) {
        try {
           return readContent(resource,"UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static String readContent(Resource resource, String encoding) throws IOException {
        EncodedResource encodedResource = new EncodedResource(resource, encoding);
        try (Reader reader = encodedResource.getReader()) {
            return IOUtils.toString(reader);
        }
    }
}

package sun.net.www.protocol.x;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author leon
 * @date 2022-02-27 10:34
 **/
public class XURLConnection extends URLConnection {

    private final ClassPathResource classPathResource;

    public XURLConnection(URL url) {
        super(url);
        this.classPathResource = new ClassPathResource(url.getPath());
    }

    @Override
    public void connect() throws IOException {

    }

    public InputStream getInputStream() throws IOException {
        return classPathResource.getInputStream();
    }
}

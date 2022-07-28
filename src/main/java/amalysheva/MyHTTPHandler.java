package amalysheva;

import java.io.IOException;
import java.net.Socket;

import static amalysheva.Values.*;

public class MyHTTPHandler extends HTTPHandler{
    MyHTTPHandler(Socket socket) throws Throwable {
        super(socket);
    }

     public void get(String s) throws Throwable {
            String response = PROTOCOL_VERSION + DELIMITER + STATUS_CODE_OK + DELIMITER + "OK\r\n" +
                TEXT_CONTENT_TYPE + "\r\n" +
                CONNECTION_STATUS + "\r\n\r\n";
        String result = response + s;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public void post(String s) throws IOException {
        String response = PROTOCOL_VERSION + DELIMITER + STATUS_CODE_OK + DELIMITER + "OK\r\n" +
                TEXT_CONTENT_TYPE + "\r\n" +
                CONNECTION_STATUS + "\r\n\r\n";
        String result = response + s + STYLE_CSS_PAGE;
        outputStream.write(result.getBytes());
        outputStream.flush();
    }
}

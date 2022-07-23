//package amalysheva;
//
//import java.io.BufferedReader;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.net.Socket;
//
//import static amalysheva.Values.*;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class HTTPHandlerTest {
//    private Socket socket;
//    private InputStream inputStream;
//    private OutputStream outputStream;
//    private BufferedReader bufferedReader;
//
//
//    public void testGet() throws Throwable {
//        HTTPHandler httpHandler = new HTTPHandler(socket);
//        httpHandler.get(httpHandler.readPage(HTML_PAGE_GET));
//        assertThat();
//    }
//
//    public void testPost() {
//    }
//
//    public void testNoMethod() {
//    }
//}
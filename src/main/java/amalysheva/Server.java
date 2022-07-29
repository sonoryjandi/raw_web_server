package amalysheva;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static amalysheva.Values.*;

public class Server implements Runnable {
    private final Logger LOGGER = Logger.getLogger(Server.class.getName());
    private final ServerSocket serverSocket;
    private static final int PORT = 8080;

    public Server() throws IOException {
        this.serverSocket = new ServerSocket(PORT);
    }

    @Override
    public void run() {
        try {
            while (true) {
                LOGGER.info("Server created");
                Socket socket = serverSocket.accept();
                LOGGER.info("Client accepted");
                new Thread(new MyHTTPHandler(socket)).start(); //MyHTTPHandler - любой пользовательский класс, дженерик???
                LOGGER.info("Server is working");
            }
        } catch (Throwable e) {
            throw new RuntimeException();
        }
    }
}

 abstract class HTTPHandler implements Runnable, ServletInterface {
    private final static Logger LOGGER = Logger.getLogger(HTTPHandler.class.getName());
    private final Socket socket;
     protected final OutputStream outputStream;
    private final BufferedReader bufferedReader;

    HTTPHandler(Socket socket) throws Throwable {
        this.socket = socket;
        this.outputStream = socket.getOutputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        try {
            switch (getMethod()) {
                case "GET":
                    get(readPage(HTML_PAGE_GET));
                    break;
                case "POST":
                    post(readPage(HTML_PAGE_POST));
                    break;
                default:
                    noMethod();
                    break;
            }
        } catch (Throwable throwable) {
            LOGGER.log(Level.WARNING, "...", throwable);
        } finally {
            try {
                socket.close();
            } catch (Throwable throwable) {
                LOGGER.log(Level.WARNING, "...", throwable);
            }
        }
        LOGGER.info("Client processing finished");
    }

    private String getMethod() throws IOException {
        String clientRequest = bufferedReader.readLine();
        String[] arr = clientRequest.split(" ", 2);
        return arr[0];
    }

     abstract public void get(String s) throws Throwable;

     abstract public void post(String s) throws IOException;

     public void noMethod() throws IOException {
        String response = PROTOCOL_VERSION + DELIMITER + STATUS_CODE_CLIENT_ERROR + DELIMITER + "Bad Request\r\n" +
                TEXT_CONTENT_TYPE + "\r\n" +
                CONNECTION_STATUS + "\r\n\r\n";
        String result = response + "Bad Request";
        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public String readPage(File fileWithPage) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileWithPage)));
        String content;
        String answer = "";
        while ((content = reader.readLine()) != null) {
            answer += content;
            System.out.println(content);
        }
        return answer;
    }
}

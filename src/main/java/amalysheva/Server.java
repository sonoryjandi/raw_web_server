package amalysheva;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Server implements Runnable{
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
                new Thread(new HTTPHandler(socket)).start();
                LOGGER.info("Server is working");
            }
        } catch (Throwable e) {
            throw new RuntimeException();
        }
    }
}

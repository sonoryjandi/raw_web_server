package amalysheva;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerStarter {
    private static final Logger LOGGER = Logger.getLogger(ServerStarter.class.getName());

    public static void main(String[] args) throws Throwable {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                LOGGER.info("Client accepted");
                new Thread(new HTTPHandler(socket)).start();
            }
        } catch (Exception exception) {
            //nothing
        }
    }
}


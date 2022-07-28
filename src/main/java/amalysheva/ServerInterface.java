//package amalysheva;
//
//import java.net.Socket;
//
//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
//
//public interface ServerInterface {
//
//    default void run() {
//        try {
//            while (true) {
//                LOGGER.info("Server created");
//                Socket socket = serverSocket.accept();
//                LOGGER.info("Client accepted");
//                new Thread(new MyHTTPHandler(socket)).start(); //MyHTTPHandler - любой пользовательский класс, дженерик???
//                LOGGER.info("Server is working");
//            }
//        } catch (Throwable e) {
//            throw new RuntimeException();
//        }
//    }
//
//
//}

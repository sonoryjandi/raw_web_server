package amalysheva;

import jdk.nashorn.internal.runtime.logging.DebugLogger;

import javax.crypto.CipherOutputStream;
import java.io.IOException;
import java.net.Socket;

import static amalysheva.Values.*;
import static amalysheva.Values.CONNECTION_STATUS;

public interface ServletInterface {
//    void doGet(String request, String response);
//
//    void doPost(String request, String response);

    void get(String s) throws Throwable;

    void post(String s) throws IOException;
}

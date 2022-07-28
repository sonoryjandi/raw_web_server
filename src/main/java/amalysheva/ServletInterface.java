package amalysheva;

import java.io.IOException;

public interface ServletInterface {

//    void doGet(String request, String response);
//
//    void doPost(String request, String response);

    void get(String s) throws Throwable;

    void post(String s) throws IOException;
}

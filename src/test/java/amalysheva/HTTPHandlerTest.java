package amalysheva;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.Socket;

import static org.assertj.core.api.Assertions.assertThat;

class HTTPHandlerTest {
    private static final int PORT = 8080;
    private final Socket client = new Socket("localhost", PORT);
    private final BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    private final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

    private static final String GOOD_RESPONSE = "HTTP/1.1 200 OK";
    private static final String CLIENT_ERROR_RESPONSE = "HTTP/1.1 400 Bad Request";

    HTTPHandlerTest() throws IOException {
    }

    @BeforeAll
    static void serverStart() throws IOException {
        Server server = new Server();
        new Thread(server).start();
    }

    @Test
    void get() throws Throwable {
        out.write("GET\n");
        out.flush();
        assertThat(getFirstLineServerResponse()).isEqualTo(GOOD_RESPONSE);
    }

    @Test
    void post() throws IOException {
        out.write("POST\n");
        out.flush();
        assertThat(getFirstLineServerResponse()).isEqualTo(GOOD_RESPONSE);
    }

    @Test
    void noMethod() throws IOException {
        out.write("DELETE\n");
        out.flush();
        assertThat(getFirstLineServerResponse()).isEqualTo(CLIENT_ERROR_RESPONSE);
    }

    private String getFirstLineServerResponse() throws IOException {
        return in.readLine();
    }
}
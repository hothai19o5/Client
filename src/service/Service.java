package service;

import io.socket.client.Socket;
import io.socket.client.IO;
import java.net.URISyntaxException;

/*
    Client, kết nối tới server
 */
public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT = 9999;
    private final String IP = "localhost";

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    public Service() {
    }

    public void startService() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT);
            client.open();
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    public Socket getClient() {
        return client;
    }

}

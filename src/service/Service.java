package service;

import event.PublicEvent;
import io.socket.client.Socket;
import io.socket.client.IO;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import model.Model_User_Account;

/*
    Client, kết nối tới server
 */
public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT = 9999;
    private final String IP = "localhost";
    private Model_User_Account user;

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
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    // list user
                    List<Model_User_Account> users = new ArrayList<>();
                    for(Object o : os){
                        users.add(new Model_User_Account(o));
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            client.open();
        } catch (URISyntaxException e) {
            System.out.println(e);
        }
    }

    public Socket getClient() {
        return client;
    }

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
}

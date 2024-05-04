package service;

import event.PublicEvent;
import io.socket.client.Socket;
import io.socket.client.IO;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import model.Model_Receive_Message;
import model.Model_User_Account;

//    Client, kết nối tới server

public class Service {

    private static Service instance;
    private Socket client;
    private final int PORT = 9999; 
    private final String IP = "localhost"; // Nếu muốn chạy trong các máy trong cùng 1 mạng lan thì chỉnh lại IP
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
            // Tạo đối tượng Socket và kết nối tới máy chủ
            client = IO.socket("http://" + IP + ":" + PORT);
            // Lắng nghe sự kiện "list_user" để nhận danh sách người dùng
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    // Tạo danh sách người dùng từ các đối tượng nhận được
                    List<Model_User_Account> users = new ArrayList<>();
                    for(Object o : os){// Duyệt qua các đối tượng
                        users.add(new Model_User_Account(o));// Thêm vào danh sách
                    }
                    // Gửi danh sách người dùng mới cho EventMenuLeft
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users);
                }
            });
            // Lắng nghe sự kiện "user_status" để theo dõi kết nối của người dùng
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    // Lấy ID người dùng và trạng thái kết nối
                    int userID = (int) os[0];
                    boolean status = (boolean) os[1];
                    if(status){
                        // Nếu người dùng kết nối, gọi sự kiện userConnect
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                    }else{
                        // Nếu người dùng ngắt kết nối, gọi sự kiện userDisconnect
                        PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
            // Lắng nghe sự kiện "receive_ms" để nhận tin nhắn
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    // Tạo tin nhắn nhận được từ đối tượng đầu vào
                    Model_Receive_Message message = new Model_Receive_Message(os[0]);
                    // Gửi tin nhắn nhận được cho EventChat
                    PublicEvent.getInstance().getEventChat().receiveMessage(message);
                }
            });
            // Mở kết nối tới máy chủ
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

package form;

import component.Chat_Body;
import component.Chat_Bottom;
import component.Chat_Title;
import event.EventChat;
import event.PublicEvent;
import model.Model_Receive_Message;
import model.Model_Send_Message;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;

public class Chat extends javax.swing.JPanel {
    private Chat_Title chatTitle;
    private Chat_Body chatBody;
    private Chat_Bottom chatBottom;
    public Chat() {
        initComponents();
        init();
    }
    public void init(){
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, fill]0[shrink 0]0"));
        chatTitle = new Chat_Title();
        chatBody = new Chat_Body();
        chatBottom = new Chat_Bottom();
        PublicEvent.getInstance().addEventChat(new EventChat() {
            @Override
            public void sendMessage(Model_Send_Message data) {
                // Khi gửi tin nhắn thì thêm tin nhắn vào bên phải
                chatBody.addItemRight(data);
                System.out.println("Client Chat sendMessage");
            }

            @Override
            public void receiveMessage(Model_Receive_Message data) {
                if(data.getFromUserID() == chatTitle.getUser().getUserID()){
                    // Nếu người gửi trùng với người mà mình đang click chuột đến thì mới hiện tin nhắn 
                    System.out.println("Client Chat receiveMessage");
                    chatBody.addItemLeft(data);
                    System.out.println("Client Chat receiveMessage");
                }
            }
            
        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        // "h ::50%" là để cho đoạn chatBottom có thể mở rộng lớn nhất là 50% độ dài app
        add(chatBottom, "h ::50%");
    }
    // Khi click chọn vào 1 user thì các thành phần title, bottom, body phải thay đổi
    public void setUser(Model_User_Account user){
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.clearChat();
    }
    
    public void updateUser(Model_User_Account user){
        chatTitle.updateUser(user);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(239, 239, 239));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

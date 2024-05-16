package component;

import app.MessageType;
import emoji.Emoji;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import model.Model_Receive_Message;
import model.Model_Send_Message;
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;

public class Chat_Body extends javax.swing.JPanel {

    public Chat_Body() {
        initComponents();
        init();
    }

    private void init() {
        body.setLayout(new MigLayout("fillx", "", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(new Color(239, 239, 239));
    }

    // Thêm tin nhắn vào bên trái ( người khác nhắn tới )
    public void addItemLeft(Model_Receive_Message data) {
        if (data.getMessageType() == 1) {       // Nhận text
            Chat_Left item = new Chat_Left();
            item.setText(data.getText());
            item.setTime();
            // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
            body.add(item, "wrap, w 100::80%");
        } else if (data.getMessageType() == 2) {    // Nhận emoji
            Chat_Left item = new Chat_Left();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            body.add(item, "wrap, w 100::80%");
        } else if(data.getMessageType() == 3) {     // Nhận ảnh
            Chat_Left item = new Chat_Left();
            item.setText("");
            item.setTime();
        }
        repaint();
        revalidate();
    }

    // Thêm tin nhắn vào bên trái ( người khác nhắn tới ), ảnh đã mã hóa
    public void addItemLeft(String text, String user, String[] images) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime();
        item.setUserProfile(user);
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }

    // Thêm tin nhắn vào bên phải ( mình gửi)
    public void addItemRight(Model_Send_Message data) {
        if (data.getMessageType() == 1) {// Nếu là type Text thì gửi tinh nhắn text
            Chat_Right item = new Chat_Right();
            // text
            item.setText(data.getText());
            // thời điểm gửi
            item.setTime();
            // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
            body.add(item, "wrap, al right, w 100::80%");
        } else if (data.getMessageType() == 2) {    // Nếu là type Emoji thì gửi Emoji
            Chat_Right item = new Chat_Right();
            item.setEmoji(Emoji.getInstance().getEmoji(Integer.valueOf(data.getText())).getIcon());
            // Không có phần body.add() này nên không thêm cái icon gửi vào đoạn chat, fix ngày 12/5
            body.add(item, "wrap, al right, w 100::80%");   
        } else if (data.getMessageType() == 3) {    // Gửi ảnh
            Chat_Right item = new Chat_Right();
            item.setImage(data.getFile());
            item.setText("");
            item.setTime();
            body.add(item, "wrap, al right");
        }
        repaint();
        revalidate();
    }

    // Thêm tin nhắn vào bên trái ( người khác nhắn tới ), có gửi file
    public void addItemFileLeft(String text, String user, String fileName, String fileSize) {
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(user);
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, w 100::80%");
        body.repaint();
        body.revalidate();
    }

    // Thêm tin nhắn vào bên phải ( mình gửi), có gửi file
    public void addItemFileRight(String text, String fileName, String fileSize) {
        Chat_Right item = new Chat_Right();
        // text
        item.setText(text);
        // file
        item.setFile(fileName, fileSize);
        // thời điểm gửi
        item.setTime();
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, al right, w 100::80%");
        body.repaint();
        body.revalidate();
    }

    public void addDate(String date) {
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        // Nếu không có "wrap, al.." thì sẽ tách dòng giữa tin nhắn và ngày
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
    }

    public void clearChat() {
        body.removeAll();
        repaint();
        revalidate();
    }

    // Tự động cuộn tới cuối cùng
    private void scrollToBottom() {
        JScrollBar verticalBar = sp.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(239, 239, 239));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}

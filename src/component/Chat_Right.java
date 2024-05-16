package component;

import java.awt.Color;
import java.time.LocalTime;
import javax.swing.Icon;
import model.Model_File_Sender;

/*
    Gửi tin, không cần có ảnh đại diện vì là mình gửi
 */
public class Chat_Right extends javax.swing.JLayeredPane {
    // Contructor
    public Chat_Right() {
        initComponents();
        txt.setBackground(new Color(179, 233, 255));
        
    }
    public void setText(String text) {
        if(text.equals("")){    // Nếu chỉ gửi ảnh thì ẩn phần text trống đi
            txt.hideText();
        }else{  
            txt.setText(text);
            txt.sendSuccess();
        }
    }
    // Thêm ảnh
    public void setImage(Model_File_Sender fileSender){
        txt.setImage(true, fileSender);
    }
    // Thêm ảnh đã mã hóa
    public void setImage(String... images){
        txt.setImage(true, images);
    }
    // Thời điểm gửi tin nhắn
    public void setTime(){
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        txt.setTime(hour + ":" + minute);
    }
    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    public void setEmoji(Icon icon){
        txt.hideText();
        txt.setEmoji(true, icon);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new component.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}

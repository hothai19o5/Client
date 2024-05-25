package component;

import java.awt.Color;
import java.time.LocalTime;
import javax.swing.Icon;

/*
    Phần Chat mà có cả tên người Chat và ảnh đại diện, dùng trong chat group
 */
public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {

    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(229, 229, 229));
    }
    public void setUserProfile(String user){
        txt.setUserProfile(user);
    }
    public void setImageProfile(Icon image){
        imageAvatar.setImage(image);
    }
    public void setText(String text) {
        if(text.equals("")){
            txt.hideText();
        }else{
            txt.setText(text);
            txt.sendSuccess();
        }
    }
    // Thêm ảnh
    public void setImage(Icon... images){
//        txt.setImage(false, images);
//        update late
    }
    // Thêm ảnh đã mã hóa
    public void setImage(String... images){
//        txt.setImage(false, images);
    }
    public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    // Thời điểm gửi tin nhắn
    public void setTime(){
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        int minute = currentTime.getMinute();
        txt.setTime(hour + ":" + minute);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        imageAvatar = new swing.ImageAvatar();
        txt = new component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        imageAvatar.setBorderSize(0);
        imageAvatar.setImage(new javax.swing.ImageIcon(getClass().getResource("/testSetAvatar/IMG_1669.JPG"))); // NOI18N
        imageAvatar.setMaximumSize(new java.awt.Dimension(31, 31));
        imageAvatar.setMinimumSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(imageAvatar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ImageAvatar imageAvatar;
    private javax.swing.JLayeredPane jLayeredPane1;
    private component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}

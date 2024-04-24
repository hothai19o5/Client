package component;

import java.awt.Color;
import javax.swing.Icon;

/*
    Phần chat mà không hiện ảnh đại diện ở bên cạnh, chat 1-1
 */
public class Chat_Left extends javax.swing.JLayeredPane {
    // Contructor
    public Chat_Left() {
        initComponents();
        txt.setBackground(new Color(229, 229, 229));
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
    public void setImage(Icon... images){
        txt.setImage(false, images);
    }
    // Thêm ảnh đã mã hóa
    public void setImage(String... images){
        txt.setImage(false, images);
    }
    // Thời điểm gửi tin nhắn
    public void setTime(){
        txt.setTime("07:52 AM");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new component.Chat_Item();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
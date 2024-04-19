package component;

import event.PublicEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import swing.JIMSendTextPane;
import swing.ScrollBar;

/*
    Phần này để nhập tin nhắn, gửi icon, gửi file, gửi ảnh
 */
public class Chat_Bottom extends javax.swing.JPanel {

    public Chat_Bottom() {
        initComponents();
        init();
    }
    private void init(){
        setLayout(new MigLayout("fillx, filly", "3[fill]0[]3","3[fill]3"));
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null); // bỏ cái viền của chatBottom
        scroll.setVerticalScrollBar(new ScrollBar()); // sử dụng cái scrollBar của mình
        JIMSendTextPane txt = new JIMSendTextPane();
        // khi nhắn tin phần chatBottom có thể tự mở rộng
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                refresh();
            }
        });
        txt.setHintText("Write Message Here...");
        scroll.setViewportView(txt);
        add(scroll, "w 100%");
        // Chỗ để nhét cái sendButton vào
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30,28));
        panel.setBackground(new Color(239, 239, 239));
        // viền, nền, trỏ chuột, icon của sendButton
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/icon/send.png")));
        // chức năng của sendButton
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = txt.getText().trim();
                if(!text.equals("")){
                    PublicEvent.getInstance().getEventChat().sendMessage(text);
                    txt.setText("");
                    txt.grabFocus(); // thành phần chính nhập liệu
                    refresh();
                }else{
                    txt.grabFocus();
                }
            }
        });
        panel.add(cmd);
        add(panel);
    }
    private void refresh(){
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(229, 229, 229));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

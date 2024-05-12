package component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Chat_Item extends javax.swing.JLayeredPane {

    private JLabel label;

    public Chat_Item() {
        initComponents();
        txt.setEditable(false);
        txt.setBackground(new Color(0, 0, 0, 0));
        txt.setOpaque(false);
    }

    public void setUserProfile(String user) {
        JLayeredPane layer = new JLayeredPane();
        // Tên thì ở góc trên bên trái
        layer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        layer.setBorder(new EmptyBorder(10, 10, 0, 10));
        JButton cmd = new JButton(user);
        // Làm cho khi trỏ chuột vào button
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Làm mất cái viền quanh button
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setFocusable(false);
        // Cài màu cho tên
        cmd.setForeground(new Color(30, 121, 213));
        // Cài đặt phông chữ
        cmd.setFont(new java.awt.Font("sansserif", 1, 13));

        txt.setBorder(new EmptyBorder(0, 5, 5, 5));
        layer.add(cmd);
        add(layer, 0);
    }

    public void setText(String text) {
        txt.setText(text);
    }

    // Thời điểm gửi/nhận tin nhắn
    public void setTime(String time) {
        // Đoạn này để cài đặt cái phần thời gian ở góc phải
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        // Đoạn này để cho nó đẹp hơn ( khoảng cách viền nhỏ lại)
        layer.setBorder(new EmptyBorder(0, 5, 5, 5));
        label = new JLabel(time);
        // Set cái màu cho cái thời gian
        label.setForeground(new Color(110, 110, 110));
        // Set cái tick ở bên phải thời gian
        label.setHorizontalTextPosition(JLabel.LEFT);
        layer.add(label);
        add(layer);
    }

    // Gửi ảnh ( Thêm ảnh vào khung chat, không phải sự kiện )
    public void setImage(boolean right, Icon... images) {
        if (images.length > 0) {
            JLayeredPane layer = new JLayeredPane();
            layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
            layer.setBorder(new EmptyBorder(0, 5, 5, 5));
            Chat_Image chatImage = new Chat_Image(right);
            chatImage.addImage(images);
            layer.add(chatImage);
            add(layer);
        }
    }

    // Gửi ảnh đã mã hóa blurHash ( Thêm ảnh vào khung chat, không phải sự kiện )
    public void setImage(boolean right, String... images) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(0, 5, 5, 5));
        Chat_Image chatImage = new Chat_Image(right);
        chatImage.addImage(images);
        layer.add(chatImage);
        add(layer);
    }

    // Gửi file ( Thêm file vào khung chat, không phải sự kiện )
    public void setFile(String fileName, String fileSize) {
        JLayeredPane layer = new JLayeredPane();
        layer.setLayout(new FlowLayout(FlowLayout.LEFT));
        layer.setBorder(new EmptyBorder(5, 5, 0, 5));
        Chat_File chatFile = new Chat_File();
        chatFile.setFile(fileName, fileSize);
        layer.add(chatFile);
        add(layer);
    }
    
    // Gửi emoji ( Thêm cái emoji vòa đoạn chat, không phải sự kiện gửi )
    public void setEmoji(boolean right, Icon icon) {
        JLayeredPane layer = new JLayeredPane();
        // Xác định thêm vào bên trái hay phải
        layer.setLayout(new FlowLayout(right ? FlowLayout.RIGHT : FlowLayout.LEFT)); 
        layer.setBorder(new EmptyBorder(0, 0, 0, 0));
        layer.add(new JLabel(icon));
        add(layer);
        setBackground(null);    
    }

    // Gửi thành công thì sẽ có 1 tick
    public void sendSuccess() {
        if (label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/icon/tick.png")));
        }
    }

    // Đã xem sẽ có 2 tick
    public void seen() {
        if (label != null) {
            label.setIcon(new ImageIcon(getClass().getResource("/icon/double_tick.png")));
        }
    }

    // nếu chỉ gửi ảnh thì ẩn dòng text trống
    public void hideText() {
        txt.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new swing.JIMSendTextPane();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        txt.setBackground(new java.awt.Color(239, 239, 239));
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 5, 10));
        txt.setSelectionColor(new java.awt.Color(94, 190, 255));
        add(txt);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    // Vẽ một phần bao quanh khi gửi tin nhắn / ảnh, nếu gửi icon thì không cần
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (getBackground() != null) {
            // Thiết lập khử răng cưa để làm cho các cạnh của hình vẽ mượt hơn, giảm hiện tượng răng cưa (aliasing).
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            // Vẽ một hình chữ nhật bo tròn, với góc bo tròn có bán kính 15 pixel.
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        }
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.JIMSendTextPane txt;
    // End of variables declaration//GEN-END:variables
}

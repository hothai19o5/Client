package component;

import event.PublicEvent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import model.Model_File_Sender;
import model.Model_Receive_Image;
import net.miginfocom.swing.MigLayout;
import swing.PictureBox;

/*
    Gửi ảnh, hiện luôn trên màn hình ( khác với gửi file )
 */
public class Chat_Image extends javax.swing.JPanel {

    public Chat_Image(boolean right) {
        initComponents();
        // Thiết kế cái khung gửi ảnh ( viền 4 cạnh, ... )
        setLayout(new MigLayout("", "0[" + (right ? "right" : "left") + "]0", "0[]0"));
    }

    // Thêm ảnh 
    public void addImage(Model_File_Sender fileSender) {
        ImageIcon image = new ImageIcon(fileSender.getFile().getAbsolutePath());
        Image_Item pic = new Image_Item();
        // Kích thước tối đa của ảnh khi ở trong khung chat
        pic.setPreferredSize(getAutoSize(image, 100, 100));
        pic.setImage(image, fileSender);
        // Thêm sự kiện khi bấm vào ảnh 
        addEvent(pic, image);
        add(pic, "wrap");

    }

    // Thêm ảnh đã mã hóa blurHash
    public void addImage(Model_Receive_Image dataImage) {
        Image_Item pic = new Image_Item();
        pic.setPreferredSize(new Dimension(dataImage.getWidth(), dataImage.getHeight()));
        pic.setImage(dataImage);
        add(pic, "wrap");
    }

    // Sự kiện khi nhấn vào ảnh
    private void addEvent(Component com, Icon image) {
        // Trỏ vào ảnh thì trỏ chuột thay đổi
        com.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // Nếu nhấp chuột trái vào thì hiện ảnh
        com.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    PublicEvent.getInstance().getEventImageView().viewImage(image);
                }
            }

        });
    }

    private Dimension getAutoSize(Icon image, int w, int h) {
        // Lấy kích thước ảnh lớn nhất là bằng với kích thước app
        if ((w > image.getIconWidth()) || (h > image.getIconHeight())) {
            w = image.getIconWidth();
            h = image.getIconHeight();
        }
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        return new Dimension(width, height);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

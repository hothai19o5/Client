package component;

import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;

/*
 * @author admin
 */
public class Chat_Body extends javax.swing.JPanel {

    public Chat_Body() {
        initComponents();
        init();
        addDate("17/04/2024");
        addItemRight("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.", new ImageIcon(getClass().getResource("/testSetAvatar/PXL_20240217_100821946.jpg")));
        addItemRight("hello\nHi");
        String img[] = {"LKO2:N%2Tw=w]~RBVZRi};RPxuwH", "LGF5?xYk^6#M@-5c,1J5@[or[Q6."};
        addItemLeft("Simpletext started as a passion project because I couldn’t find what I was looking for. Most apps were trying to do too much and ended up bloated with features I don’t need. So I built Simpletext based on a simple premise — what if there’s an app that refuses to do more, choosing instead to do just one thing, and do it well? For Simpletext, that one thing is writing.", "Thái", img);
        addItemLeft("hello\nerererew\newewe", "Thái");
        addItemRight("hello\nerererew\newewe");
        addItemLeft("hello\nerererew\newewe", "Thái");
        addItemRight("Có nhắn tiếng việt được không nhỉ");
        addItemRight("adu, nhắn đc này, ngol");
        addItemRight("Send a text message to a group of contacts. Include photos, personalize your texts, and track who clicked your links.");
        addItemRight("hello\nHi");
        addItemLeft("Simpletext started as a passion project because I couldn’t find what I was looking for. Most apps were trying to do too much and ended up bloated with features I don’t need. So I built Simpletext based on a simple premise — what if there’s an app that refuses to do more, choosing instead to do just one thing, and do it well? For Simpletext, that one thing is writing.", "Thái");
        addItemLeft("", "Thái", new ImageIcon(getClass().getResource("/testSetAvatar/IMG_1669.JPG")), new ImageIcon(getClass().getResource("/testSetAvatar/IMG_1669.JPG")));
        addDate("Today");
        addItemRight("hello\nerererew\newewe", new ImageIcon(getClass().getResource("/testSetAvatar/PXL_20240418_040128583~3.jpg")));
        addItemLeft("hello\nerererew\newewe", "Thái", new ImageIcon(getClass().getResource("/testSetAvatar/PXL_20240418_040128583~3.jpg")));
        addItemRight("Có nhắn tiếng việt được không nhỉ");
        addItemRight("adu, nhắn đc này, ngol", new ImageIcon(getClass().getResource("/icon/icon_app.png")));
        addItemFileLeft("Tôi có tài liệu em có lấy không?", "Thái", "TaiLieu", "1 TB");
        addItemFileRight("", "TaiLieu.pdf", "1 TB");
    }
    private void init(){
        body.setLayout(new MigLayout("fillx", "", "5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(new Color(239, 239, 239));
    }
    // Thêm tin nhắn vào bên trái ( người khác nhắn tới )
    public void addItemLeft(String text, String user, Icon... images){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime();
        item.setUserProfile(user);
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, w 100::80%");
        // ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    // Thêm tin nhắn vào bên trái ( người khác nhắn tới ), ảnh đã mã hóa
    public void addItemLeft(String text, String user, String[] images){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(images);
        item.setTime();
        item.setUserProfile(user);
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, w 100::80%");
        // ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    // Thêm tin nhắn vào bên phải ( mình gửi)
    public void addItemRight(String text, Icon... images){
        Chat_Right item = new Chat_Right();
        // text
        item.setText(text);
        // ảnh
        item.setImage(images);
        // thời điểm gửi
        item.setTime();
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, al right, w 100::80%");
        // ::80% set max with 80%
        body.repaint();
        body.revalidate();
        scrollToBottom();
    }
    // Thêm tin nhắn vào bên trái ( người khác nhắn tới ), có gửi file
    public void addItemFileLeft(String text, String user, String fileName, String fileSize){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setFile(fileName, fileSize);
        item.setTime();
        item.setUserProfile(user);
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, w 100::80%");
        // ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    // Thêm tin nhắn vào bên phải ( mình gửi)
    public void addItemFileRight(String text, String fileName, String fileSize){
        Chat_Right item = new Chat_Right();
        // text
        item.setText(text);
        // file
        item.setFile(fileName, fileSize);
        // thời điểm gửi
        item.setTime();
        // Đoạn này là để cho cái đoạn tin nhắn có thể xuống dòng 
        body.add(item, "wrap, al right, w 100::80%");
        // ::80% set max with 80%
        body.repaint();
        body.revalidate();
    }
    public void addDate(String date){
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        // Nếu không có "wrap, al.." thì sẽ tách dòng giữa tin nhắn và ngày
        body.add(item, "wrap, al center");
        body.repaint();
        body.revalidate();
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

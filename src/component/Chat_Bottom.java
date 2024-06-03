package component;

import event.PublicEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import model.Model_Send_Message;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import service.Service;
import swing.JIMSendTextPane;
import swing.ScrollBar;

//    Phần này để nhập tin nhắn, gửi icon, gửi file, gửi ảnh
public class Chat_Bottom extends javax.swing.JPanel {

    private Panel_More panelMore;

    private MigLayout mig;

    private Model_User_Account user;// Đối tượng người dùng đại diện cho người nhận tin nhắn

    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
        panelMore.setUser(user);
    }

    public Chat_Bottom() {
        initComponents();// Khởi tạo các thành phần giao diện
        init();// Thực hiện các bước khởi tạo khác
    }

    private void init() {
        mig = new MigLayout("fillx, filly", "3[fill]0[]3", "3[fill]3[]0");
        setLayout(mig);
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null); // bỏ cái viền của vùng cuộn
        scroll.setVerticalScrollBar(new ScrollBar()); // sử dụng cái scrollBar của mình
        JIMSendTextPane txt = new JIMSendTextPane();// Khung nhập văn bản tùy chỉnh
        setFontForJIMSendTextPane(txt, "JetBrains Mono", 12);
        // khi nhắn tin phần chatBottom có thể tự mở rộng
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {// Khi người dùng gõ phím
                revalidate();// Làm mới bố cục để cập nhật kích thước
                // Nếu nhấn phím Enter thì xuống dòng, nhấn shift enter là gửi
                if (e.getKeyChar() == 10 && e.isShiftDown()) {
                    sendEvent(txt);
                }
            }
        });
        txt.setHintText("Write Message Here...");// Đặt gợi ý khi khung nhập văn bản trống
        scroll.setViewportView(txt);
        add(scroll, "w 100%");// Thêm vùng cuộn vào bố cục
        // Panel để nhét cái sendButton vào
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]3[]0", "0[bottom]0"));
        panel.setPreferredSize(new Dimension(30, 28));
        panel.setBackground(new Color(255, 255, 255));
        // viền, nền, trỏ chuột, icon của sendButton
        JButton cmd = new JButton();
        cmd.setBorder(null);
        cmd.setContentAreaFilled(false);
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setIcon(new ImageIcon(getClass().getResource("/icon/send.png")));
        // chức năng của sendButton
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// Khi nút gửi được nhấn
                sendEvent(txt);
            }
        });
        // viền, nền, trỏ chuột, icon của moreButton
        JButton cmdMore = new JButton();
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdMore.setIcon(new ImageIcon(getClass().getResource("/icon/more_disable.png")));
        // chức năng của moreButton
        cmdMore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {// Khi nút more được nhấn
                if (panelMore.isVisible()) { // Nếu panelMore đang hiện thì ẩn nó đi, thay đổi cái icon more
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/icon/more_disable.png"))); // thay đổi icon
                    panelMore.setVisible(false);    // ẩn
                    // dock south là để ghim nó ở dưới, h 0 là cho chiều cao nó bằng 0, ! là để cho biết đó là 1 giá trị cố định
                    mig.setComponentConstraints(panelMore, "dock south, h 0!");
                } else {    // Nếu panelMore đang ẩn thì lại hiện nó lên, thay đổi cái icon more
                    cmdMore.setIcon(new ImageIcon(getClass().getResource("/icon/more.png")));   // thay đổi icon
                    panelMore.setVisible(true); // hiện
                    // dock south là để ghim nó ở dưới, h 150 là cho chiều cao nó bằng 150, ! là để cho biết đó là 1 giá trị cố định
                    mig.setComponentConstraints(panelMore, "dock south, h 150!");
                }
            }
        });
        panel.add(cmdMore);// Thêm nút more vào panel
        panel.add(cmd);// Thêm nút gửi vào panel
        add(panel);// Thêm panel vào
        panelMore = new Panel_More();
        // bật app lên thì auto ẩn đi
        panelMore.setVisible(false);
        add(panelMore, "dock south, h 0!");
    }

    // Sự kiện gửi tin nhắn
    private void sendEvent(JIMSendTextPane txt) {
        String text = txt.getText().trim();// Lấy nội dung từ khung nhập văn bản, bỏ đoạn trắng 2 đầu
        if (!text.equals("")) {// Nếu nội dung không rỗng
            // Tạo tin nhắn mới
            Model_Send_Message data = new Model_Send_Message(Service.getInstance().getUser().getUserID(), user.getUserID(), text, 1);
            // Phát sự kiện có tên "send_to_user", cùng với dữ liệu ở dạng JSON
            Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
            PublicEvent.getInstance().getEventChat().sendMessage(data); // Thêm đoạn tin nhắn này vào bên phải khung chat
            txt.setText("");// Xóa nội dung trong khung nhập văn bản
            txt.grabFocus(); // trỏ lại về txt
            revalidate(); // Làm mới bố cục
        } else {// Nếu nội dung rỗng, chỉ cần đặt con trỏ vào khung nhập văn bản
            txt.grabFocus();
        }
    }

    // Thay đổi font chữ của txt
    public static void setFontForJIMSendTextPane(JIMSendTextPane textPane, String fontName, int fontSize) {
        StyleContext context = new StyleContext();
        Style style = context.addStyle("default", null);

        StyleConstants.setFontFamily(style, fontName);
        StyleConstants.setFontSize(style, fontSize);

        textPane.setCharacterAttributes(style, true);
    }

//    // Phương thức gửi tin nhắn ( Không cần, cho thẳng vào luôn )
//    private void send(Model_Send_Message data) {
//        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
//    }
//    // Phương thức làm mới bố cục để cập nhật các thay đổi ( Không cần, cho thẳng vào luôn )
//    private void refresh() {
//        revalidate();
//    }
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

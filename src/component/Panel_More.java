package component;

import app.MessageType;
import emoji.Model_Emoji;
import emoji.Emoji;
import event.PublicEvent;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import main.Main;
import model.Model_Send_Message;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import service.Service;
import swing.ScrollBar;
import swing.WrapLayout;
// Khi nhấn vào button more thì sẽ hiện phần này lên, để chọn icon, file...

public class Panel_More extends javax.swing.JPanel {

    private Model_User_Account user;    // Người nhận
    
    private JPanel panelHeader;         // Phần header

    private JPanel panelDetail;         // Phần detail khi nhấn vào button trong header
    
    public Model_User_Account getUser() {
        return user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }
    
    public Panel_More() {
        initComponents();
        init();
    }

    public void init() {
        setLayout(new MigLayout("fillx"));  // miglayout
        panelHeader = new JPanel();  // panel header để chọn chức năng
        // BoxLayout để có thể xếp theo chiều ngang hoặc dọc, LINE_AXIS để xếp theo chiều ngang
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonFile());   // Thêm button để chọn file
        // Thêm các button để chọn icon
        panelHeader.add(getButtonEmojiStyleAnimal());
        panelHeader.add(getButtonEmojiStyleFood());
        panelHeader.add(getButtonEmojiStylePeople());
        panelHeader.add(getButtonEmojiStyleSmiley());
        panelHeader.add(getButtonEmojiStyleActivities());
        panelHeader.add(getButtonEmojiStyleFlag());
        // Thêm panel header vào panel more, chiều rộng bằng panel more và chiều cao 45
        add(panelHeader, "w 100%, h 45!, wrap");
        panelDetail = new JPanel(); // panel detail là phần để hiển thị chi tiết các icon
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT)); // Sử dụng WrapLayout tự định nghĩa
        JScrollPane sp = new JScrollPane(panelDetail);  // thêm thanh cuộn vào panel detail
        sp.setBorder(null); // bỏ phần viền thanh cuộn
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Chỉ cho kéo dài theo chiều dọc
        sp.setVerticalScrollBar(new ScrollBar()); // Sử dụng ScrollBar tự định nghĩa, thực ra kh dùng cũng đc, dùng nhìn cho nó nhỏ đẹp hơn
        // Thêm thanh cuộn vào panel detail
        add(sp, "w 100%, h 100%");
    }

    // nút nhấn file
    private JButton getButtonFile() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/icon/link.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(Main.getFrames()[0]); // Mở một ô để chọn file
                // Phần này là để gửi file, sẽ update sau
            }
        });
        return cmd;
    }

    // Các button Emoji, nhấn vào sẽ hiện 1 bảng emoji, bảng này cũng gồm các button emoji
    private JButton getButtonEmojiStyleAnimal() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + 68 + ".png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for (Model_Emoji me : Emoji.getInstance().getStyleAnimal()) {
                    panelDetail.add(getButton(me));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButtonEmojiStyleFood() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + 300 + ".png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for (Model_Emoji me : Emoji.getInstance().getStyleFood()) {
                    panelDetail.add(getButton(me));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButtonEmojiStylePeople() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + 431 + ".png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for (Model_Emoji me : Emoji.getInstance().getStylePeople()) {
                    panelDetail.add(getButton(me));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButtonEmojiStyleSmiley() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + 497 + ".png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for (Model_Emoji me : Emoji.getInstance().getStyleSmiley()) {
                    panelDetail.add(getButton(me));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButtonEmojiStyleActivities() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + 1 + ".png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for (Model_Emoji me : Emoji.getInstance().getStyleActivities()) {
                    panelDetail.add(getButton(me));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }

    private JButton getButtonEmojiStyleFlag() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + 210 + ".png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for (Model_Emoji me : Emoji.getInstance().getStyleFlag()) {
                    panelDetail.add(getButton(me));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    // Các button emoji và sự kiện khi nhấn vào sẽ gửi emoji
    private JButton getButton(Model_Emoji me) {
        JButton b = new JButton(me.getIcon());
        b.setName(me.getId() + ""); // Thêm "" để chuyển int sang String 
        b.setBorder(new EmptyBorder(3, 3, 3, 3));
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b.setContentAreaFilled(false);
        // Đặt sự kiện khi nhấn vào button emoji -> gửi emoji
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tạo đối tượng để gửi
                Model_Send_Message message = new Model_Send_Message(Service.getInstance().getUser().getUserID(), user.getUserID(), me.getId()+"", 2);
                sendMessage(message);
                PublicEvent.getInstance().getEventChat().sendMessage(message);
            }
        });
        return b;
    }
    // Gửi tin nhắn
    private void sendMessage(Model_Send_Message data){
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            .addGap(0, 61, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

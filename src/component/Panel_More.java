package component;

import emoji.Model_Emoji;
import emoji.Emoji;
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
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;
import swing.WrapLayout;

public class Panel_More extends javax.swing.JPanel {

    private JPanel panelHeader;

    private JPanel panelDetail;

    public Panel_More() {
        initComponents();
        init();
    }

    public void init() {
        setLayout(new MigLayout("fillx"));

        panelHeader = new JPanel();
        // BoxLayout để có thể xếp theo chiều ngang hoặc dọc, LINE_AXIS để xếp theo chiều ngang
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonFile());
        panelHeader.add(getButtonEmojiStyleAnimal());
        panelHeader.add(getButtonEmojiStyleFood());
        panelHeader.add(getButtonEmojiStylePeople());
        panelHeader.add(getButtonEmojiStyleSmiley());
        add(panelHeader, "w 100%, h 45!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT)); // Sử dụng WrapLayout tự định nghĩa
        JScrollPane sp = new JScrollPane(panelDetail);
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Chỉ cho kéo dài theo chiều dọc
        sp.setVerticalScrollBar(new ScrollBar()); // Sử dụng ScrollBar tự định nghĩa

        add(sp, "w 100%, h 100%");
    }

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
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji animal/animal1.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for(Model_Emoji me : Emoji.getInstance().getStyleAnimal()){
                    JButton b = new JButton(me.getIcon());
                    b.setName(me.getId() + ""); // Thêm "" để chuyển int sang String 
                    b.setBorder(new EmptyBorder(3, 3, 3, 3));
                    b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    b.setContentAreaFilled(false);
                    panelDetail.add(b);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    private JButton getButtonEmojiStyleFood() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji food & drink/food1.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for(Model_Emoji me : Emoji.getInstance().getStyleFood()){
                    JButton b = new JButton(me.getIcon());
                    b.setName(me.getId() + ""); // Thêm "" để chuyển int sang String 
                    b.setBorder(new EmptyBorder(3, 3, 3, 3));
                    b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    b.setContentAreaFilled(false);
                    panelDetail.add(b);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    private JButton getButtonEmojiStylePeople() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji people & body/people1.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for(Model_Emoji me : Emoji.getInstance().getStylePeople()){
                    JButton b = new JButton(me.getIcon());
                    b.setName(me.getId() + ""); // Thêm "" để chuyển int sang String 
                    b.setBorder(new EmptyBorder(3, 3, 3, 3));
                    b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    b.setContentAreaFilled(false);
                    panelDetail.add(b);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    private JButton getButtonEmojiStyleSmiley() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/emoji_icon/emoji smileys & emoiton/simley1.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelDetail.removeAll();    // Xóa panelDetail
                // Thêm các button emoji vào bảng panelDetail
                for(Model_Emoji me : Emoji.getInstance().getStyleSmiley()){
                    JButton b = new JButton(me.getIcon());
                    b.setName(me.getId() + ""); // Thêm "" để chuyển int sang String 
                    b.setBorder(new EmptyBorder(3, 3, 3, 3));
                    b.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    b.setContentAreaFilled(false);
                    panelDetail.add(b);
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
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

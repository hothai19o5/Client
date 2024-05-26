package form;

import component.Item_People;
import event.EventMenuLeft;
import event.PublicEvent;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
import swing.ScrollBar;

public class Menu_Left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;

    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        // Đoạn này để set cái JScrollBar thành cái ScrollBar mới
        sp.setVerticalScrollBar(new ScrollBar());
        // Đoạn này để set cái menuList theo cái migLayout, fillx là để nó dãn rộng theo chiều ngang
        menuList.setLayout(new MigLayout("fillx", "0[]0", "0[]0"));
        // Khởi tạo danh sách `userAccount` để lưu trữ danh sách các tài khoản người dùng.
        userAccount = new ArrayList<>();
        // Đăng ký một sự kiện để cập nhật menu bên trái khi có người dùng mới được thêm vào.
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() {
            @Override
            public void newUser(List<Model_User_Account> users) {
                // Thêm mỗi người dùng mới vào `menuList` dưới dạng các mục (Item_People).
                for (Model_User_Account mua : users) {
                    // Thêm người dùng mới vào danh sách
                    userAccount.add(mua);
                    menuList.add(new Item_People(mua), "wrap");
                    // Cập nhật lại giao diện.
                    menuList.repaint();
                    // Xác nhận bố cục mới.
                    menuList.revalidate();
                }
            }

            @Override
            public void userConnect(int userID) {
                for(Model_User_Account mua : userAccount){
                    if(mua.getUserID() == userID){
                        mua.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(mua);
                        break;
                    }
                }
                if(menuMessage.isSelected()){
                    for(Component com : menuList.getComponents()){
                        Item_People item = (Item_People) com;
                        if(item.getUser().getUserID() == userID){
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for(Model_User_Account mua : userAccount){
                    if(mua.getUserID() == userID){
                        mua.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(mua);
                        break;
                    }
                }
                if(menuMessage.isSelected()){
                    for(Component com : menuList.getComponents()){
                        Item_People item = (Item_People) com;
                        if(item.getUser().getUserID() == userID){
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
            
        });
        // In ra menu left danh sách người
        showPeople();
    }

    private void showPeople() {
        menuList.removeAll();
        for (Model_User_Account mua : userAccount) {
            menuList.add(new Item_People(null), "wrap");
        }
        menuList.repaint();
        menuList.revalidate();
    }

    private void showGroup() {
        menuList.removeAll();
        for (int i = 0; i < 5; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        menuList.repaint();
        menuList.revalidate();
    }

    private void showBox() {
        menuList.removeAll();
        for (int i = 0; i < 10; i++) {
            menuList.add(new Item_People(null), "wrap");
        }
        menuList.repaint();
        menuList.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new component.MenuButton();
        menuGroup = new component.MenuButton();
        menuBox = new component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(229, 229, 229));

        menu.setBackground(new java.awt.Color(229, 229, 229));
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/message_selected.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/message.png"))); // NOI18N
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        menuGroup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        menuGroup.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/group_selected.png"))); // NOI18N
        menuGroup.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/group.png"))); // NOI18N
        menuGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupActionPerformed(evt);
            }
        });
        menu.add(menuGroup);

        menuBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/box.png"))); // NOI18N
        menuBox.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/icon/box_selected.png"))); // NOI18N
        menuBox.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/icon/box.png"))); // NOI18N
        menuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBoxActionPerformed(evt);
            }
        });
        menu.add(menuBox);

        sp.setBackground(new java.awt.Color(229, 229, 229));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuList.setBackground(new java.awt.Color(229, 229, 229));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Khi bấm vào một menu thì 2 menu còn lại sẽ chuyển sang false
    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if (!menuMessage.isSelected()) {
            menuMessage.setSelected(true);
            menuGroup.setSelected(false);
            menuBox.setSelected(false);
            showPeople();
        }
    }//GEN-LAST:event_menuMessageActionPerformed

    private void menuGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupActionPerformed
        if (!menuGroup.isSelected()) {
//            menuMessage.setSelected(false);
//            menuGroup.setSelected(true);
//            menuBox.setSelected(false);
//            showGroup();
            JOptionPane.showMessageDialog(null, "Tính năng này cập nhật sau");
        }
          
    }//GEN-LAST:event_menuGroupActionPerformed

    private void menuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBoxActionPerformed
        if (!menuBox.isSelected()) {
//            menuMessage.setSelected(false);
//            menuGroup.setSelected(false);
//            menuBox.setSelected(true);
//            showBox();
            JOptionPane.showMessageDialog(null, "Tính năng này cập nhật sau");
        }
    }//GEN-LAST:event_menuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private component.MenuButton menuBox;
    private component.MenuButton menuGroup;
    private javax.swing.JLayeredPane menuList;
    private component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}

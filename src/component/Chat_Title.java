package component;

import java.awt.Color;
import model.Model_User_Account;

/*
    Đây là phần chứa tên và trạng thái hoạt động
 */
public class Chat_Title extends javax.swing.JPanel {

    private Model_User_Account user;

    public Model_User_Account getUser() {
        return user;
    }

    public Chat_Title() {
        initComponents();
    }

    // Cài đặt tên người dùng
    public void setUserName(Model_User_Account user) {
        this.user = user;
        lbName.setText(user.getUserName());
        if (user.isStatus()) {
            statusActive();
        } else {
            lbStatus.setText("Offline");
            lbStatus.setForeground(new java.awt.Color(94, 97, 102));
        }
    }
    // Nếu hoạt động thì hiện màu xanh,....
    public void updateUser(Model_User_Account user) {
        if (this.user == user) {
            lbName.setText(user.getUserName());
            if (user.isStatus()) {
                statusActive();
            } else {
                lbStatus.setText("Offline");
                lbStatus.setForeground(new java.awt.Color(94, 97, 102));
            }
        }
    }

    // Trạng thái hoạt động
    private void statusActive() {
        lbStatus.setText("Active now");
        lbStatus.setForeground(new java.awt.Color(0, 204, 51));
    }

    private void setStatusText(String text) {
        lbStatus.setText(text);
        lbStatus.setForeground(new Color(158, 158, 158));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lbName = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(229, 229, 229));

        layer.setLayout(new java.awt.GridLayout(0, 1));

        lbName.setBackground(new java.awt.Color(214, 217, 223));
        lbName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbName.setText("Name");
        layer.add(lbName);

        lbStatus.setBackground(new java.awt.Color(214, 217, 223));
        lbStatus.setForeground(new java.awt.Color(0, 204, 51));
        lbStatus.setText("Active now");
        layer.add(lbStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layer)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables
}

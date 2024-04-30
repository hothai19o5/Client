package component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;
// Phần menu Button để chọn
public class OptionButton extends JButton{
    
    public OptionButton() {
        setContentAreaFilled(false);
        // Khi trỏ chuột vào menu thì trỏ sẽ thành hình bàn tay
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
    }

    @Override
    // Nếu chọn thì chuyển icon sang iconSelected, nếu không thì để là iconSimple
    public void setSelected(boolean b) {
        super.setSelected(b); 
    }

    @Override
    // Thêm cái thanh bên dưới menu khi chọn
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if(isSelected()){
            g.setColor(new Color(110, 213, 255));
            g.fillRect(0, getHeight()-3, getWidth(), getHeight());
        }
    }
    
    
}

package component;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Ho Xuan Thai
 */
public class MenuButton extends JButton{
    private Icon iconSimple;
    private Icon iconSelected;

    public Icon getIconSimple() {
        return iconSimple;
    }

    public void setIconSimple(Icon iconSimple) {
        this.iconSimple = iconSimple;
    }

    public Icon getIconSelected() {
        return iconSelected;
    }

    public void setIconSelected(Icon iconSelected) {
        this.iconSelected = iconSelected;
    }
    
    public MenuButton() {
        setContentAreaFilled(false);
        // Khi trỏ chuột vào menu thì trỏ sẽ thành hình bàn tay
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
    }

    @Override
    // Nếu chọn thì chuyển icon sang iconSelected, nếu không thì để là iconSimple
    public void setSelected(boolean b) {
        super.setSelected(b); 
        if(b){
            setIcon(iconSelected);
        }else{
            setIcon(iconSimple);
        }
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

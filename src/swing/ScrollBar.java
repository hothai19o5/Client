package swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

/*
 * 
 */
public class ScrollBar extends JScrollBar{

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        // Chỉnh lại kích thước 
        setPreferredSize(new Dimension(5, 5));
        // Chỉnh lại màu
        setBackground(new Color(229, 229, 229));
        // Làm cho lướt nhanh hơn
        setUnitIncrement(20);
    }
    
}

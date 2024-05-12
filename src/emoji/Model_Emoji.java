package emoji;

import javax.swing.Icon;

public class Model_Emoji {
    private int id;
    private Icon icon;

    public Model_Emoji() {
    }
    
    public Model_Emoji(int id, Icon icon) {
        this.id = id;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
}

package swing;

import javax.swing.Icon;
import javax.swing.JProgressBar;

/**
 *
 * @author admin
 */
public class Progress extends JProgressBar {
    private ProgressType progressType = ProgressType.NONE;

    public ProgressType getProgressType() {
        return progressType;
    }

    public void setProgressType(ProgressType progressType) {
        this.progressType = progressType;
        repaint();
    }
    
    public Progress() {
        setOpaque(false); // bỏ cái phần nền của cái progessCircle
        setUI(new ProgressCircleUI(this));
    }
    public static enum ProgressType{
        NONE, DOWN_FILE, CANCEL, FILE
    }
}

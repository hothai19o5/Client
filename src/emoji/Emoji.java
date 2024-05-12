package emoji;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class Emoji {

    private static Emoji instance;

    public static Emoji getInstance() {
        if (instance == null) {
            instance = new Emoji();
        }
        return instance;
    }

    private Emoji() {
    }

    public List<Model_Emoji> getStyleAnimal() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 68; i <= 209; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + i + ".png"))));
        }
        return list;
    }

    public List<Model_Emoji> getStyleFood() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 300; i <= 430; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + i + ".png"))));
        }
        return list;
    }

    public List<Model_Emoji> getStylePeople() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 431; i <= 496; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + i + ".png"))));
        }
        return list;
    }

    public List<Model_Emoji> getStyleSmiley() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 497; i <= 658; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + i + ".png"))));
        }
        return list;
    }

    public List<Model_Emoji> getStyleActivities() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 1; i <= 67; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + i + ".png"))));
        }
        return list;
    }

    public List<Model_Emoji> getStyleFlag() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 210; i <= 299; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + i + ".png"))));
        }
        return list;
    }

    // Đoạn này để trả về 1 emoji từ hình ảnh
    public Model_Emoji getEmoji(int id) {
        try {
            return new Model_Emoji(id, new ImageIcon(getClass().getResource("/emoji_icon/emoji activities/emoji icon" + id + ".png")));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

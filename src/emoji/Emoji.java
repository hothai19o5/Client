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
        for (int i = 1; i <= 142; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji animal/animal" + i + ".png"))));
        }
        return list;
    }
    
    public List<Model_Emoji> getStyleFood() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 1; i <= 109; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji food & drink/food" + i + ".png"))));
        }
        return list;
    }
    
    public List<Model_Emoji> getStylePeople() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 1; i <= 66; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji people & body/people" + i + ".png"))));
        }
        return list;
    }
    
    public List<Model_Emoji> getStyleSmiley() {
        List<Model_Emoji> list = new ArrayList<>();
        for (int i = 1; i <= 162; i++) {
            list.add(new Model_Emoji(i, new ImageIcon(getClass().getResource("/emoji_icon/emoji smileys & emoiton/simley" + i + ".png"))));
        }
        return list;
    }
}

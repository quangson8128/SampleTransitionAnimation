package vnzit.com.sampletransitionanimation;

import java.io.Serializable;

/**
 * Created by sh on 6/13/16.
 */
public class Item implements Serializable{
    private int icon;
    private String content;

    public Item(int icon, String content) {
        this.icon = icon;
        this.content = content;
    }

    public int getIcon() {
        return icon;
    }

    public String getContent() {
        return content;
    }
}

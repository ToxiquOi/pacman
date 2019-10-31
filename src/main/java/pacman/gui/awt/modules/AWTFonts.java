package pacman.gui.awt.modules;

import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

public class AWTFonts {

    private Map<Integer, Font> fonts = new TreeMap();

    public Font getFont(Graphics graphics,int size) {
        Font font = fonts.get(size);
        if (font == null) {
            Font oldFont = graphics.getFont();
            for (int i=2*size;i>=4;i--) {
                font = new Font("Arial",Font.PLAIN,i);
                graphics.setFont(font);
                FontMetrics fm = graphics.getFontMetrics();
                if (fm.getHeight() < size) {
                    break;
                }
            }
            fonts.put(size,font);
            graphics.setFont(oldFont);
        }
        return font;
    }
}

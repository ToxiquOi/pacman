package pacman.gui.interfaces;

import java.awt.*;
import java.util.ArrayList;

public interface IGUIFacade {
    void createWindow(int width, int height, String title);
    boolean beginPaint();
    void endPaint();
    void clearBackground();
    boolean isClosingRequested();
    void setClosingRequested(boolean b);
    void drawLayer(ILayer layer);
    ILayer createLayer();
    void dispose();
    IKeyboard getKeyboard();
    IMouse getMouse();
    IImage createImage(String fileName);
    void drawImage(IImage image, int x, int y);
    void setColor(Color c);
    Dimension getTextMetrics(String text);
    void setTextSize(int size);
    void drawText(String text, int x, int y, int width, int height);
}
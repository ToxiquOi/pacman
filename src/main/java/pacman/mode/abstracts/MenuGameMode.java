package pacman.mode.abstracts;

import pacman.gui.interfaces.IImage;

import java.awt.*;
import java.util.ArrayList;

public abstract class MenuGameMode extends GameMode {

    protected ArrayList<String> items = new ArrayList<>(3);

    protected int selectedItem = 0;

    private IImage titleImage;

    private IImage selectImage;

    private final static int windowWidth = 640;

    private final static int windowHeight = 480;

    @Override
    public void init() {
        this.keyboard = this.gui.getKeyboard();
        this.titleImage = this.gui.createImage("pacman_title.png");
        this.selectImage = this.gui.createImage("select.png");

        this.gui.createWindow(windowWidth, windowHeight, "Pacman");
    }

    @Override
    public void render() {
        if (!gui.beginPaint())
            return;
        try {
            gui.clearBackground();
            gui.drawImage(titleImage,
                    (windowWidth-titleImage.getWidth())/2,
                    50
            );
            gui.setColor(Color.white);
            gui.setTextSize(selectImage.getHeight());

            Dimension menuSize = paintMenu(0,0,true);
            paintMenu(
                    (windowWidth-menuSize.width)/2,
                    50+titleImage.getHeight()+selectImage.getHeight()/2,
                    false
            );

        } finally {
            gui.endPaint();
        }
    }

    protected Dimension paintMenu(int x, int y, boolean computeSize) {
        int menuWidth = 0;
        int menuHeight = 0;

        for (int i=0; i < this.items.size(); i++) {
            String text = this.items.get(i);
            this.gui.setTextSize(30);

            Dimension textSize = this.gui.getTextMetrics(text);
            if (!computeSize) {
                this.gui.drawText(text, x, y, textSize.width, textSize.height);
                if (i == this.selectedItem) {
                    this.gui.drawImage(this.selectImage, x - this.selectImage.getWidth(), y - 10);
                }
            }
            y += textSize.height;
            menuHeight += textSize.height;
            if (textSize.width > menuWidth) {
                menuWidth = textSize.width;
            }
        }
        return new Dimension(menuWidth,menuHeight);
    }
}

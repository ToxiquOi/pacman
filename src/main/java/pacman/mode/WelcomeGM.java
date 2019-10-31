package pacman.mode;

import pacman.gui.interfaces.IImage;
import pacman.gui.interfaces.IKeyboard;
import pacman.mode.abstracts.GameMode;
import pacman.mode.menu.MainMenuGM;

import java.awt.event.KeyEvent;

public class WelcomeGM extends GameMode {
    private IImage titleImage;

    private final static int windowWidth = 640;

    private final static int windowHeight = 480;

    public void init() {
        titleImage = gui.createImage("pacman_title.png");

        gui.createWindow(this.windowWidth, windowHeight, "Pacman");
    }

    public void handleInputs() {
        IKeyboard keyboard = gui.getKeyboard();
        switch(keyboard.getLastPressedKey()) {
            case KeyEvent.VK_ESCAPE:
                gui.setClosingRequested(true);
                return;
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_ENTER:
                keyboard.consumeLastPressedKey();
                setGameMode(new MainMenuGM());
                return;
        }
    }

    public void update() {
    }

    @Override
    public void render() {
        if (!this.gui.beginPaint())
            return;
        try {
            this.gui.clearBackground();
            this.gui.drawImage(this.titleImage,
                    (windowWidth - this.titleImage.getWidth()) / 2,
                    (windowHeight - this.titleImage.getHeight()) / 2
            );
        } finally {
            gui.endPaint();
        }
    }
}

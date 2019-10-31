package pacman.mode.abstracts;

import pacman.Main;
import pacman.gui.interfaces.IGUIFacade;
import pacman.gui.interfaces.IKeyboard;

public abstract class GameMode {
    protected IGUIFacade gui;
    protected IKeyboard keyboard;

    private Main parent;

    public void setParent(Main parent) {
        this.parent = parent;
    }

    public void setGUI(IGUIFacade gui) {
        this.gui = gui;
    }

    public void setGameMode(GameMode mode) {
        parent.setGameMode(mode);
    }

    public void setPreviousGameMode() {
        parent.setPreviousGameMode();
    }

    public abstract void handleInputs();

    public abstract void update();

    public abstract void render();

    public abstract void init();
}

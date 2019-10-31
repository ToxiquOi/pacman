package pacman.gui.interfaces;

public interface IKeyboard {
    public boolean isKeyPressed(int keyCode);

    public int getLastPressedKey();

    public int consumeLastPressedKey();
}

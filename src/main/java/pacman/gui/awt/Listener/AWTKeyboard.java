package pacman.gui.awt.Listener;

import pacman.gui.interfaces.IKeyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AWTKeyboard implements IKeyboard, KeyListener {
    private boolean[] keys;

    private int lastPressedKey = -1;

    public AWTKeyboard() {
        keys = new boolean[0x10000];
    }

    public boolean isKeyPressed(int keyCode) {
        if (keyCode >= keys.length) {
            return false;
        }
        return keys[keyCode];
    }

    public int getLastPressedKey() {
        return lastPressedKey;
    }

    public int consumeLastPressedKey() {
        int tmp = lastPressedKey;
        lastPressedKey = -1;
        return tmp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = true;
        }
        lastPressedKey = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() < keys.length) {
            keys[e.getKeyCode()] = false;
        }
    }
}

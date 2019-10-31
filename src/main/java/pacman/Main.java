package pacman;

import pacman.gui.awt.AWTGUIFacade;
import pacman.gui.interfaces.IGUIFacade;
import pacman.mode.WelcomeGM;
import pacman.mode.abstracts.GameMode;

import javax.swing.*;
import java.util.LinkedList;

public class Main {

    private static final String APP_TITLE = "Pacman";

    private IGUIFacade gui;

    private GameMode currentMode;

    private LinkedList<GameMode> gameModes = new LinkedList();

    public void setGUI(IGUIFacade gui) {
        this.gui = gui;
    }

    public synchronized void setGameMode(GameMode mode) {
        try {
            gameModes.push(mode);
            mode.setParent(this);
            mode.setGUI(gui);
            mode.init();
            this.currentMode = mode;
        }
        catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
        }
    }

    public synchronized void setPreviousGameMode() {
        if (!gameModes.isEmpty()) {
            gameModes.pop();
        }
        if (gameModes.isEmpty()) {
            gui.setClosingRequested(true);
        }
        else {
            setGameMode(gameModes.pop());
        }
    }

    public void run() {
        int fps = 60;
        long nanoPerFrame = (long) (1000000000.0 / fps);
        long lastTime = 0;

        while (!gui.isClosingRequested()) {
            long nowTime = System.nanoTime();
            if ((nowTime - lastTime) < nanoPerFrame) {
                continue;
            }
            lastTime = nowTime;

            synchronized(this) {
                currentMode.handleInputs();
                currentMode.update();
                currentMode.render();
            }

            long elapsed = System.nanoTime() - lastTime;
            long milliSleep = (nanoPerFrame - elapsed) / 1000000;
            if (milliSleep > 0) {
                try {
                    Thread.sleep(milliSleep);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
        gui.dispose();
    }

    public static void main(String args[]) {
        Main pacman = new Main();
        pacman.setGUI(new AWTGUIFacade());
        pacman.setGameMode(new WelcomeGM());
        pacman.run();
    }

}
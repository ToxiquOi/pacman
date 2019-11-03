package pacman.mode;

import pacman.gui.interfaces.ILayer;
import pacman.mode.abstracts.GameMode;
import pacman.state.element.World;
import pacman.state.element.factory.ElementFactory;

import java.awt.*;

public class PlayGM extends GameMode {

    private ILayer levelLayer;
    private ILayer charsLayer;
    private ILayer infoLayer;

    private static int levelWidth = 9;
    private static int levelHeight = 6;

    private int pacmanX;
    private int pacmanY;

    private int selectTileX;
    private int selectTileY;

    private static int[][] level = new int[][] {
            {15, 11, 11, 11, 11, 11, 11, 11, 16},
            {12, 5, 3, 3, 3, 3, 3, 3, 12},
            {12, 3, 15, 11, 11, 11, 16, 3, 12},
            {14, 3, 13, 11, 11, 11, 14, 3, 13},
            {3, 3, 3, 3, 3, 3, 3, 3, 3},
            {11, 11, 11, 11, 11, 11, 11, 11, 11}
    };

    World world;

    @Override
    public void handleInputs() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render() {
        if (!gui.beginPaint())
            return;
        try {
            this.gui.clearBackground();


        } finally {
            gui.endPaint();
        }
    }

    @Override
    public void init() {
        this.keyboard = this.gui.getKeyboard();
        this.world = new World(9, 6);
        this.world.setFactory(ElementFactory.getDefault());
        this.world.init(level);
    }
}

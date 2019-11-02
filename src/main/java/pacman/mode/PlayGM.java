package pacman.mode;

import pacman.gui.interfaces.ILayer;
import pacman.mode.abstracts.GameMode;
import pacman.state.element.World;

import java.awt.*;

public class PlayGM extends GameMode {

    private ILayer levelLayer;
    private ILayer charsLayer;
    private ILayer infoLayer;

    static int levelWidth = 9;
    static int levelHeight = 6;

    private int pacmanX;
    private int pacmanY;

    private int selectTileX;
    private int selectTileY;

    static int[][] level = new int[][] {
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
            this.gui.drawLayer(this.levelLayer);
            this.gui.drawLayer(this.charsLayer);
            this.gui.drawLayer(this.infoLayer);

        } finally {
            gui.endPaint();
        }
    }

    @Override
    public void init() {
        this.keyboard = this.gui.getKeyboard();
        this.world = new World();
        this.world.init(level);

        this.charsLayer = gui.createLayer();
        this.charsLayer.setTileSize(24, 24);
        this.charsLayer.setTexture("chars_tiles.png");
        this.charsLayer.setSpriteCount(1);
        this.charsLayer.setSpriteTexture(0, 6, 1);
        this.charsLayer.setSpriteLocation(0, 0 * charsLayer.getTileWidth(), 4 * charsLayer.getTileHeight());

        this.levelLayer = gui.createLayer();
        this.levelLayer.setTileSize(24, 24);
        this.levelLayer.setTexture("grid_tiles.png");
        this.levelLayer.setSpriteCount(levelWidth * levelHeight);

        this.infoLayer = gui.createLayer();
        this.infoLayer.setTileSize(24, 24);
        this.infoLayer.setTexture("grid_tiles.png");
        this.infoLayer.setSpriteCount(1);
        this.infoLayer.setSpriteTexture(0, 5, 0);
        this.infoLayer.setSpriteLocation(0, 0 * charsLayer.getTileWidth(), 0 * charsLayer.getTileHeight());
    }
}

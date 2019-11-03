package pacman.mode;

import pacman.gui.interfaces.ILayer;
import pacman.mode.abstracts.GameMode;
import pacman.state.State;
import pacman.state.element.World;
import pacman.state.element.abstracts.Element;
import pacman.state.element.factory.ElementFactory;
import pacman.state.enumerations.EDirection;
import pacman.state.tile.GridTileSet;
import pacman.state.tile.Tile;
import pacman.state.tile.interfaces.ITileSet;


public class PlayGM extends GameMode {

    private ILayer levelLayer;
    private ITileSet levelTileSet;
    private State state;

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

    public PlayGM() {
        World world = new World(9, 6);
        world.setFactory(ElementFactory.getDefault());
        world.init(level);

        this.state = new State();
        this.state.setWorld(world);
    }

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


        } finally {
            gui.endPaint();
        }
    }

    @Override
    public void init() {
        this.keyboard = this.gui.getKeyboard();
        World world = this.state.getWorld();

        this.levelTileSet = new GridTileSet();
        this.levelLayer = this.gui.createLayer();
        this.levelLayer.setTileSize(this.levelTileSet.getTileWidth(), this.levelTileSet.getTileWidth());
        this.levelLayer.setTexture(this.levelTileSet.getImageFile());
        this.levelLayer.setSpriteCount(world.getWidth() * world.getHeight());
        for (int j = 0; j < world.getHeight(); j++) {
            for (int i = 0; i < world.getWidth(); i++) {
                int index = i + j * world.getWidth();
                this.levelLayer.setSpriteLocation(index, i * this.levelLayer.getTileHeight(), j * this.levelLayer.getTileWidth());


                // TODO: make world work
                Element element = world.get(i, j, EDirection.NONE);
                Tile tile = this.levelTileSet.getTile(element);
                this.levelLayer.setSpriteLocation(index, tile.getX(), tile.getY());
            }
        }

        this.gui.createWindow(world.getWidth() * levelLayer.getTileWidth(), world.getHeight() * levelLayer.getTileHeight(), "rendu");

    }
}

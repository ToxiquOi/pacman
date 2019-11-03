package pacman.state.tile;

import pacman.state.element.abstracts.Element;
import pacman.state.element.static_element.Space;
import pacman.state.element.static_element.Wall;
import pacman.state.tile.interfaces.ITileSet;

public class GridTileSet implements ITileSet {

    private Tile[] wallTile;
    private Tile[] spaceTile;

    public GridTileSet() {
        this.wallTile = new Tile[6];
        this.wallTile[0] = new Tile(4, 1);
        this.wallTile[1] = new Tile(5, 1);
        this.wallTile[2] = new Tile(2, 1);
        this.wallTile[3] = new Tile(3, 1);
        this.wallTile[4] = new Tile(0, 1);
        this.wallTile[5] = new Tile(1, 1);

        this.spaceTile = new Tile[6];
        this.spaceTile[0] = new Tile(0, 0);
        this.spaceTile[1] = new Tile(1, 0);
        this.spaceTile[2] = new Tile(2, 0);
        this.spaceTile[3] = new Tile(4, 0);
        this.spaceTile[4] = new Tile(0, 0);
        this.spaceTile[5] = new Tile(0, 0);
    }

    @Override
    public int getTileWidth() {
        return 24;
    }

    @Override
    public int getTileHeight() {
        return 24;
    }

    @Override
    public String getImageFile() {
        return "grid_tiles.png";
    }

    @Override
    public Tile getTile(Element e) {
        if(e instanceof Wall) {
            Wall wall = (Wall) e;
            int code = wall.getWallTypeId().getCode();
            if (code < this.wallTile.length) {
                return this.wallTile[code];
            }

        }
        if (e instanceof Space) {
            Space space = (Space) e;
            int code = space.getSpaceTypeId().getCode();
            if (code < this.spaceTile.length) {
                return this.spaceTile[code];
            }
        }

        throw new RuntimeException("element given is not a Wall/Space");
    }
}

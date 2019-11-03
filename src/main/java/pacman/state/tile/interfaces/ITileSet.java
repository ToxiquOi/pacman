package pacman.state.tile.interfaces;

import pacman.state.element.abstracts.Element;
import pacman.state.tile.Tile;

public interface ITileSet {
    int getTileWidth();
    int getTileHeight();
    String getImageFile();
    Tile getTile(Element element);
}

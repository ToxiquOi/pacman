package pacman.gui.interfaces;

public interface ILayer {

    public int getTileWidth();

    public int getTileHeight();

    public int getTextureWidth();

    public int getTextureHeight();

    public void setTileSize(int width, int height);

    public void setTexture(String fileName);

    public void setSpriteCount(int count);

    public void setSpriteTexture(int index, int tileX, int tileY);

    public void setSpriteLocation(int index, int screenX, int screenY);
}

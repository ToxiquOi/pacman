package pacman.state.element.interfaces;

import pacman.state.element.World;
import pacman.state.element.static_element.abstracts.StaticElement;

import java.util.Iterator;

public interface IWorldIterator extends Iterator<StaticElement> {


    boolean hasNext();

    StaticElement next();

    int getX();

    int getY();

    World getWorld();
}

package pacman.state.element.interfaces;

import pacman.state.element.abstracts.StaticElement;

import java.util.Iterator;

public interface IWorldIterator extends Iterator<StaticElement> {

    @Override
    boolean hasNext();

    @Override
    StaticElement next();
}

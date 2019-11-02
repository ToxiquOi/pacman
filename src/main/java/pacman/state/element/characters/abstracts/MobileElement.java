package pacman.state.element.characters.abstracts;

import pacman.state.element.abstracts.Element;
import pacman.state.enumerations.EDirection;

public abstract class MobileElement extends Element {
    protected EDirection direction;
    protected int speed;
    protected int position;
    protected int statusTime;
    protected int x;
    protected int y;
}

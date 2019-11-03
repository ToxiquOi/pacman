package pacman.state.element.static_element;

import pacman.state.element.static_element.abstracts.StaticElement;
import pacman.state.enumerations.ESpaceTypeId;

public class Space extends StaticElement {
    ESpaceTypeId spaceTypeId;

    public Space(ESpaceTypeId spaceTypeId) {
        this.spaceTypeId = spaceTypeId;
    }
}

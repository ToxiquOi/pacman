package pacman.state.element.factory;

import pacman.share.ICreator;
import pacman.share.IFactory;
import pacman.state.element.abstracts.Element;

import java.util.HashMap;
import java.util.Map;

public class ElementFactory implements IFactory<Element> {
    private Map<Integer, ICreator<Element>> creators;

    public ElementFactory() {
        this.creators = new HashMap<>();
    }

    public static ElementFactory getDefault() {
        return new ElementFactory();
    }

    @Override
    public void register(int code, ICreator<Element> creator) {
        if (this.creators != null) {
            this.creators.put(code, creator);
        }
    }

    @Override
    public void unregister(int code) {

    }

    @Override
    public Element create(int code) {
        return this.creators.get(code).create();
    }
}

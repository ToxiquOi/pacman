package pacman.share.abstracts;

import pacman.share.interfaces.ICreator;
import pacman.share.interfaces.IFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class Factory<K, C, T> implements IFactory<K, C, T> {
    private Map<K, C> creators;

    public Factory() {
        this.creators = new HashMap<>();
    }

    public void register(K code, C creator) {
        if (this.creators != null) {
            this.creators.put(code, creator);
        }
    }

    public void unregister(K code) {
        this.creators.remove(code);
    }


    public T create(K code) {
        C templateCreator = this.creators.get(code);

        if (templateCreator == null) {
            templateCreator = this.creators.get(0);

            if (templateCreator == null) {
                throw new RuntimeException("Code not found");
            }
        }

        if ((templateCreator instanceof ICreator)) {
            ICreator<T> creator = (ICreator) templateCreator;
            return creator.create();

        } else {
            throw new RuntimeException("T<C> is not a ICreator instance");
        }
    }
}

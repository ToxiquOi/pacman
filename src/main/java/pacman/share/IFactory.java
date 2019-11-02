package pacman.share;

public interface IFactory<T> {
    void register(int code, ICreator<T> creator);
    void unregister(int code);
    T create(int code);
}

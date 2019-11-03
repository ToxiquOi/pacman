package pacman.share.interfaces;

public interface IFactory<K, C, T> {
    void register(K code, C creator);
    void unregister(K code);
    T create(K code);
}

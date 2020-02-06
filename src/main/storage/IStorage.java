package main.storage;

import main.model.Resume;

import java.util.Collection;

/**
 * Maks
 * 06.02.2020.
 */
public interface IStorage {
    void clear();
    void save(Resume r);
    void update(Resume r);
    Resume load(String uuid);
    void delete(String uuid);
    Collection<Resume> getAllSorted();
    int size();
}

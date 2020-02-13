package main.storage;

import main.model.Resume;

import java.io.IOException;
import java.util.Collection;

/**
 * Maks
 * 06.02.2020.
 */
public interface IStorage {
    void clear();
    void save(Resume r) throws IOException;
    void update(Resume r) throws IOException;
    Resume load(String uuid);
    void delete(String uuid);
    Collection<Resume> getAllSorted();
    int size();
}

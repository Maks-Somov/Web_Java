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
    void save(Resume r) throws Exception;
    void update(Resume r) throws Exception;
    Resume load(String uuid) throws Exception;
    void delete(String uuid);
    Collection<Resume> getAllSorted() throws Exception;
    int size();
}

package main.storage;

import main.model.Resume;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

/**
 * Maks
 * 06.02.2020.
 */
public class ArrayStorage implements IStorage {
    private Resume[] array = new Resume[100];

    @Override
    public void clear() {
        Arrays.fill(array, null);
    }

    @Override
    public void save(Resume r) {

    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume load(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals(uuid))
            {
                array[i] = null;
                break;
            }
        }
    }

    @Override
    public Collection<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return array.length;
    }
}

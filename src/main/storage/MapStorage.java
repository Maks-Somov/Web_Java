package main.storage;

import main.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume>  map = new HashMap<>();

    @Override
    protected void doSave(Resume r) {
        map.put(r.getUuid(),r);
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected void doUpdate(Resume r) {
        map.put(r.getUuid(),r);
    }

    @Override
    protected Resume doLoad(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected int doSize() {
        return map.size();
    }

    @Override
    protected boolean exist(String uuid) {
        return map.containsKey(uuid);
    }
}

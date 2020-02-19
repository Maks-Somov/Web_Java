package main.storage;

import main.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcyrrencyMapStorage extends AbstractStorage<String> {

    private Map<String, Resume>  map = new ConcurrentHashMap<>();

    @Override
    protected void doSave(String uuid, Resume r) {
        map.put(uuid,r);
    }

    @Override
    protected void doClear() {
        map.clear();
    }

    @Override
    protected void doUpdate(String uuid, Resume r) {
        map.put(uuid,r);
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
    protected String getContext(String uuid) {
        return uuid;
    }

    @Override
    protected boolean exist(String uuid) {
        return map.containsKey(uuid);
    }
}

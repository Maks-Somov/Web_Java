package main.storage;

import main.model.Resume;

import java.util.Collection;

public class MapStorage extends AbstractStorage {


    @Override
    protected void doSave(Resume r) {

    }

    @Override
    protected void doClear() {

    }

    @Override
    protected void doUpdate(Resume r) {

    }

    @Override
    protected Resume doLoad(String uuid) {
        return null;
    }

    @Override
    protected void doDelete(String uuid) {

    }

    @Override
    protected Collection<Resume> doGetAllSorted() {
        return null;
    }

    @Override
    protected int doSize() {
        return 0;
    }
}

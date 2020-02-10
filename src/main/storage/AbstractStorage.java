package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.util.*;
import java.util.logging.Logger;

abstract public class AbstractStorage implements IStorage {
    protected Logger logger = Logger.getLogger(getClass().getName());

    public void save(Resume r) {
        logger.info("Save resumes with uuid"+r.getUuid());
        if(exist(r.getUuid())) throw new MainExeption("Resume "+r.getUuid()+" already exist", r);
        doSave(r);
    }
    public void clear(){
        logger.info("Delete all resumes.");
        doClear();
    }
    public void update(Resume r){
        logger.info("Update resumes with "+r.getUuid());
        if(!exist(r.getUuid())) throw new MainExeption("Resume "+r.getUuid()+" not exist", r);
        doUpdate(r);
    }
    public Resume load(String uuid) {
        logger.info("Load resumes with uuid" + uuid);
        if(!exist(uuid)) throw new MainExeption("Resume "+uuid+" not exist", uuid);
        return doLoad(uuid);
    }
    public void delete(String uuid) {
        logger.info("Load resumes with uuid" + uuid);
        if(!exist(uuid)) throw new MainExeption("Resume "+uuid+" not exist", uuid);
        doDelete(uuid);
    }
    public Collection<Resume> getAllSorted() {
        logger.info("sorting successfull");
        List<Resume> list = doGetAllSorted();
        Collections.sort(list, new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                int cmp=o1.getFullName().compareTo(o2.getFullName());
                if(cmp!=0) return cmp;
                return o1.getUuid().compareTo(o2.getUuid());
            }
    });
//        Collections.sort(list, (Resume o1, Resume o2) -> {
//            int cmp=o1.getFullName().compareTo(o2.getFullName());
//                if(cmp!=0) return cmp;
//                return o1.getUuid().compareTo(o2.getUuid());
//        });
        return list;
    }

    public int size() {
        logger.info("Size got");
        return doSize();
    }

    protected abstract void doSave(Resume r);
    protected abstract void doClear();
    protected abstract void doUpdate(Resume r);
    protected abstract Resume doLoad(String uuid);
    protected abstract void doDelete(String uuid);
    protected abstract List<Resume> doGetAllSorted();
    protected abstract int doSize();
    protected abstract boolean exist(String uuid);
}

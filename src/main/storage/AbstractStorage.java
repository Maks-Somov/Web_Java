package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.util.*;
import java.util.logging.Logger;

abstract public class AbstractStorage<C> implements IStorage {
    protected Logger logger = Logger.getLogger(getClass().getName());



    public void save(Resume r) {
        logger.info("Save resumes with uuid"+r.getUuid());
        C ctx = getContext(r);
        if(exist(ctx)) throw new MainExeption("Resume "+r.getUuid()+" already exist", r);
        doSave(ctx,r);
    }
    public void clear(){
        logger.info("Delete all resumes.");
        doClear();
    }
    public void update(Resume r){
        logger.info("Update resumes with "+r.getUuid());
        C ctx = getContext(r);
        if(!exist(ctx)) throw new MainExeption("Resume "+r.getUuid()+" not exist", r);
        doUpdate(ctx, r);
    }
    public Resume load(String uuid) {
        logger.info("Load resumes with uuid" + uuid);
        C ctx = getContext(uuid);
        if(!exist(ctx)) throw new MainExeption("Resume "+uuid+" not exist", uuid);
        return doLoad(ctx, uuid);
    }
    public void delete(String uuid) {
        logger.info("Load resumes with uuid" + uuid);
        C ctx = getContext(uuid);
        if(!exist(ctx)) throw new MainExeption("Resume "+uuid+" not exist", uuid);
        doDelete(ctx,uuid);
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

    protected abstract void doSave(C ctx,Resume r);
    protected abstract void doClear();
    protected abstract void doUpdate(C ctx, Resume r);
    protected abstract Resume doLoad(C ctx, String uuid);
    protected abstract void doDelete(C ctx, String uuid);
    protected abstract List<Resume> doGetAllSorted();
    protected abstract int doSize();
    protected abstract C getContext(String uuid);
    protected abstract boolean exist(C ctx);

    private C getContext(Resume r){
        return getContext(r.getUuid());
    }
}

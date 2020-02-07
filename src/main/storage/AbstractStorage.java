package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.util.logging.Logger;

abstract public class AbstractStorage implements IStorage {
        protected Logger logger = Logger.getLogger(getClass().getName());
    public void save(Resume r) {
        logger.info("Save resumes with uuid"+r.getUuid());
        doSave(r);

    }
    protected abstract void doSave(Resume r);
}

package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.io.File;
import java.util.Collection;
import java.util.List;

public class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage(String path){
        this.dir = new File(path);
        if(!dir.isDirectory() || !dir.canWrite()){
            throw new IllegalArgumentException(" ' "+path+" ' isn't directory or isn't writable");
        }
    }

    @Override
    protected void doSave(File file, Resume r) {

    }

    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if(files==null) return;
        for(File file : files){
            doDelete(file);
        }
    }

    @Override
    protected void doUpdate(File file, Resume r) {

    }

    @Override
    protected Resume doLoad(File file) {
        return null;
    }

    @Override
    protected void doDelete(File file) {
        if(!file.delete()){
            throw new MainExeption("F" +
                    "" +
                    "ile "+ file.getAbsolutePath()+" can't be deleted!");
        }
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        return null;
    }

    @Override
    protected int doSize() {
        return 0;
    }

    @Override
    protected File getContext(String fileName) {
        return new File(fileName);
    }

    @Override
    protected boolean exist(File file) {
        return file.exists();
    }
}

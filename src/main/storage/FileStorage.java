package main.storage;

import main.MainExeption;
import main.model.ContactType;
import main.model.Resume;
import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.util.*;

public abstract class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage(String path) {
        this.dir = new File(path);
        if (!dir.isDirectory() || !dir.canWrite()) {
            throw new IllegalArgumentException(" ' " + path + " ' isn't directory or isn't writable");
        }
    }

    @Override
    protected void doSave(File file, Resume r) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new MainExeption(e, r, "Couldn't create file " + file.getAbsolutePath());
        }
        write(file, r);

    }

    abstract protected void write(File file, Resume r);

    abstract protected Resume read(File file);

    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    protected void doUpdate(File file, Resume r){
        write(file, r);
    }

    @Override
    protected Resume doLoad(File file) {
        return read(file);
    }


    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new MainExeption("File " + file.getAbsolutePath() + " can't be deleted!");
        }
    }

    @Override
    protected List<Resume> doGetAllSorted() {
        return null;
    }

    @Override
    protected int doSize() {
        String[] list = dir.list();
        if(list==null)    throw new MainExeption("Couldn't read directory "+dir.getAbsolutePath());
        return list.length;
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

package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class FileStorage extends AbstractStorage<File> {
    private File dir;

    public FileStorage() {
    }

    public FileStorage(String path) {
        this.dir = new File(path);
        if (!dir.isDirectory() || !dir.canWrite()) {
            throw new IllegalArgumentException(" ' " + path + " ' isn't directory or isn't writable");
        }
    }

    @Override
    protected void doSave(File file, Resume r) throws Exception {
        try {
            if(!file.createNewFile()){
             throw new MainExeption("Couldn't create file ", file.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new MainExeption(e, r, "Couldn't create file " + file.getAbsolutePath());
        }
        write(file, r);

    }

    abstract protected void write(File file, Resume r) throws IOException;

    abstract protected Resume read(File file) throws IOException;


    @Override
    protected void doClear() {
        File[] files = dir.listFiles();
        if (files == null) return;
        for (File file : files) {
            doDelete(file);
        }
    }

    @Override
    protected void doUpdate(File file, Resume r) throws IOException {
        write(file, r);
    }

    @Override
    protected Resume doLoad(File file) throws IOException {
        return read(file);
    }


    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new MainExeption("File " + file.getAbsolutePath() + " can't be deleted!");
        }
    }

    @Override
    protected List<Resume> doGetAllSorted() throws IOException {
        File[] files = dir.listFiles();
        if (files == null) return Collections.emptyList();
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) list.add(read(file));
        return list;
    }

    @Override
    protected int doSize() {
        String[] list = dir.list();
        if (list == null) throw new MainExeption("Couldn't read directory " + dir.getAbsolutePath());
        return list.length;
    }

    @Override
    protected File getContext(String fileName) {
        return new File(dir, fileName);
    }

    @Override
    protected boolean exist(File file) {
        return file.exists();
    }
}

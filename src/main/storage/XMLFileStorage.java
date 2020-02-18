package main.storage;

import main.model.Resume;

import java.io.File;
import java.io.IOException;

public class XMLFileStorage extends FileStorage {

    public XMLFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(File file, Resume r) throws IOException {

    }

    @Override
    protected Resume read(File file) throws IOException {
        return null;
    }



}

package main.storage;

import main.MainExeption;
import main.model.Resume;

import java.io.*;

public class SerializeFileStorage extends FileStorage {
    public SerializeFileStorage(String path) {
    super(path);
    }
@Override
    protected void write(File file, Resume r) throws IOException {
        try(OutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(r);
            }
    }
@Override
    protected Resume read(File file) throws IOException {
        try(InputStream is = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(is))
        {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new MainExeption( "Error read resume ",e);
        }

    }
}

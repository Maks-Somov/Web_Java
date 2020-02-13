package main.storage;

import main.MainExeption;
import main.model.ContactType;
import main.model.Resume;
import java.io.*;
import java.util.*;

public class SerializeFileStorage extends FileStorage {
    public SerializeFileStorage(String path) {
    super(path);
    }

    protected void write(File file, Resume r){
        try(FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(r);
        } catch (IOException e) {
            throw new MainExeption(e, r, "Couldn't write file " + file.getAbsolutePath());
        }
    }

    protected Resume read(File file) {
        Resume r = new Resume();
        try(FileInputStream is = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(is))
        {
            return (Resume) ois.readObject();
        }catch (IOException e){
            throw new MainExeption( "Couldn't read file " + file.getAbsolutePath(),e);
        } catch (ClassNotFoundException e) {
            throw new MainExeption( "Error read resume ",e);
        }
    }
}

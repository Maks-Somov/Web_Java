package main.storage;

import main.MainExeption;
import main.model.ContactType;
import main.model.Resume;
import org.omg.CORBA.portable.InputStream;

import java.io.*;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class FileStorage extends AbstractStorage<File> {
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

    protected void write(File file, Resume r){
        try(FileOutputStream fos = new FileOutputStream(file); DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(r.getFullName());
            dos.writeUTF(r.getLocation());
            dos.writeUTF(r.getHomePage());
            for (Map.Entry<ContactType, String> entry : r.getContacts().entrySet()) {
                dos.writeInt(entry.getKey().ordinal());
                dos.writeUTF(entry.getValue());
            }
            //TODO section implementation
        } catch (IOException e) {
            throw new MainExeption(e, r, "Couldn't write file " + file.getAbsolutePath());
        }
    }

    protected Resume read(File file) {
        Resume r = new Resume();
        try(FileInputStream is = new FileInputStream(file); DataInputStream dis = new DataInputStream(is))
        {
            r.setFullName(dis.readUTF());
            r.setLocation(dis.readUTF());
            r.setHomePage(dis.readUTF());
            Map<ContactType,String> contacts = new EnumMap<>(ContactType.class);

            //TODO
        }catch (IOException e){
            throw new MainExeption( "Couldn't read file " + file.getAbsolutePath(),e);
        }
        return null;
    }



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
            throw new MainExeption("F" +
                    "" +
                    "ile " + file.getAbsolutePath() + " can't be deleted!");
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

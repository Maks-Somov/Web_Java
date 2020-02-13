package main.storage;

import main.MainExeption;
import main.model.ContactType;
import main.model.Resume;

import java.io.*;
import java.util.Map;

public class DataStreamFileStorage extends FileStorage {
    public DataStreamFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume r) {
        try (FileOutputStream fos = new FileOutputStream(file); DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(r.getFullName());
            dos.writeUTF(r.getLocation());
            dos.writeUTF(r.getHomePage());
            Map<ContactType, String> contacts = r.getContacts();
            dos.writeInt(contacts.size());
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
        try (FileInputStream is = new FileInputStream(file); DataInputStream dis = new DataInputStream(is)) {
            r.setFullName(dis.readUTF());
            r.setLocation(dis.readUTF());
            r.setHomePage(dis.readUTF());
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                r.addContact(ContactType.VALUES[dis.readInt()], dis.readUTF());
            }
            //TODO
        } catch (IOException e) {
            throw new MainExeption("Couldn't read file " + file.getAbsolutePath(), e);
        }
        return null;
    }
}



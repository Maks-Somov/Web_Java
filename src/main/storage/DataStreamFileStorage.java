package main.storage;

import main.MainExeption;
import main.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static main.model.SectionType.*;

public class DataStreamFileStorage extends FileStorage {
    private static final String NULL = "null";

    public DataStreamFileStorage(String path) {
        super(path);
    }

    protected void write(File file, Resume r)  {
        try (FileOutputStream fos = new FileOutputStream(file);DataOutputStream dos = new DataOutputStream(fos)) {
            writeString(dos, r.getFullName());
            writeString(dos,r.getLocation());
            writeString(dos,r.getHomePage());
            Map<ContactType, String> contacts = r.getContacts();
            writeCollection(dos, contacts.entrySet(), entry -> {
                dos.writeInt(entry.getKey().ordinal());
                dos.writeUTF(entry.getValue());
            });

            Map<SectionType, Section> sections = r.getSections();
            dos.writeInt(sections.size());
            for(Map.Entry<SectionType,Section> entry : sections.entrySet()) {
                SectionType type = entry.getKey();
                Section section = entry.getValue();
                writeString(dos, type.name());
                switch (type) {
                    case OBJECTIVE:
                        writeString(dos, ((TextSection) section).getValue());
                        break;
                    case ACHIEVEMENT:
                    case QUALIFICATIONS:
                        writeCollection(dos, ((MultiTextSection) section).getValues(), s -> writeString(dos, s));
                        break;
                    case EDUCATION:
                    case EXPERIENCE:
//
                        break;
                }
            }
        } catch (Exception e) {
            throw new MainExeption(e, r, "Couldn't write file " + file.getAbsolutePath());

        }
    }

    protected Resume read(File file)  {
        Resume r = new Resume();
        try (InputStream is = new FileInputStream(file);DataInputStream dis = new DataInputStream(is)) {
            r.setFullName(readString(dis));
            r.setLocation(readString(dis));
            r.setHomePage(readString(dis));
            int size = dis.readInt();
            for (int i = 0; i < size; i++) {
                r.addContact(ContactType.VALUES[dis.readInt()], readString(dis));
            }
            final int sectionSize = dis.readInt();
            for(int i = 0; i<sectionSize;i++){
                SectionType sectionType = SectionType.valueOf(readString(dis));

            switch (sectionType) {
                case OBJECTIVE:
                    r.addObjective(readString(dis));
                    break;
                case ACHIEVEMENT:
                case QUALIFICATIONS:
                    r.addSection(sectionType, new MultiTextSection(readList(dis, () -> readString(dis))));
                    break;
                case EDUCATION:
                case EXPERIENCE:
//
                    break;
                }
            }
        } catch (Exception e) {
            throw new MainExeption(  "Couldn't read file " + file.getAbsolutePath(), e);
        }
        return r;
    }


    private void writeString(DataOutputStream dos, String str) throws IOException {
        dos.writeUTF(str==null? NULL : str);
    }
    private String  readString(DataInputStream dis) throws IOException {
        String str = dis.readUTF();
        return str.equals(NULL)? null:str;
    }
    private interface ElementWriter<T>{
        void write(T t) throws Exception;
    }
    private interface ElementReader<T>{
        T read() throws Exception;
    }
    private <T> void writeCollection(DataOutputStream dos, Collection<T> collection,ElementWriter<T> writer) throws Exception {
        dos.writeInt(collection.size());
        for (T item : collection) {
            writer.write(item);
        }
    }
    private <T> List<T> readList(DataInputStream dis, ElementReader<T> reader) throws Exception {
        int size = dis.readInt();
        List<T> list = new ArrayList<>(size);
        for(int i = 0; i<size;i++){
            list.add(reader.read());
        }
        return list;
    }
}



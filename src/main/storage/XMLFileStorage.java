package main.storage;

import main.MainExeption;
import main.model.*;
import main.util.XMLParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XMLFileStorage extends FileStorage {
    public XMLFileStorage() {
    }

    private XMLParser xmlParser;

    public XMLFileStorage(String path) {
        super(path);
        xmlParser = new XMLParser(Resume.class, Organization.class, Link.class, OrganizationSection.class,
                TextSection.class, Organization.Period.class);
    }

    @Override
    protected void write(File file, Resume r) throws IOException {
        try (FileOutputStream os = new FileOutputStream(file); Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marhall(r, w);
        }catch (IOException e){
            throw new MainExeption(e, r, "Couldn't read file");
        }
    }

    @Override
    protected Resume read(File file) throws IOException {
        try (FileInputStream is = new FileInputStream(file); Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        } catch (IOException e){
            throw new MainExeption("Couldn't read file", e);
        }
    }
}

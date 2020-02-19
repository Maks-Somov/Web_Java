package main.storage;

import main.model.*;
import main.util.XMLParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class XMLFileStorage extends FileStorage {

    private XMLParser xmlParser;

    public XMLFileStorage(String path) {
        super(path);
        xmlParser = new XMLParser(Resume.class, Organization.class, Link.class, OrganizationSection.class,
                TextSection.class, Organization.Period.class);
    }

    @Override
    protected void write(File file, Resume r) throws IOException {
        try (OutputStream os = new FileOutputStream(file); Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            xmlParser.marhall(r, w);
        }
    }

    @Override
    protected Resume read(File file) throws IOException {
        try (InputStream is = new FileInputStream(file); Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return xmlParser.unmarshall(r);
        }
    }


}

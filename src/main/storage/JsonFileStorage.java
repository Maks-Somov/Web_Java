package main.storage;

import main.model.Resume;
import main.util.JsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class JsonFileStorage extends FileStorage {

    public JsonFileStorage(String path) {
        super(path);
    }

    @Override
    protected void write(File file, Resume r) throws IOException {
        try(OutputStream os = new FileOutputStream(file); Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8))
        {
            JsonParser.write(r, w);
        }

    }

    @Override
    protected Resume read(File file) throws IOException {
        try(InputStream is = new FileInputStream(file); Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)){
            return JsonParser.read(r, Resume.class);
        }
    }
}

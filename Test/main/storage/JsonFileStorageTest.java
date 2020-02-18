package main.storage;

import static org.junit.Assert.*;

public class JsonFileStorageTest extends AbstractStorageTest {
    {
        storage = new JsonFileStorage("D:\\Web_Java\\file_storage");
    }
}
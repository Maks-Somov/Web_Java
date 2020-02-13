package main.storage;

import static org.junit.Assert.*;

public class SerializeFileStorageTest extends AbstractStorageTest {
    {
         storage = new SerializeFileStorage("D:\\Web_Java\\file_storage");
    }
}
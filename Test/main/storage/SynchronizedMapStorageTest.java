package main.storage;

import main.model.Resume;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.LogManager;

public class SynchronizedMapStorageTest {
    static {
        try (FileInputStream logProps = new FileInputStream(new File("logging.properties"))) {
            LogManager.getLogManager().readConfiguration(logProps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testArrayStorage() throws Exception {
        run(new ArrayStorage());
    }

    @Test
    public void testSerializedFileStorage() throws Exception {
        run(new SerializeFileStorage(AbstractStorageTest.FILE_STORAGE));
    }

    @Test
    public void testMapStorage() throws Exception {
        run(new MapStorage());
    }
    @Test
    public void testConcyrrencyMapStorage() throws Exception {
        run(new ConcyrrencyMapStorage());
    }

    private void run(IStorage storage) throws Exception {
        for (int i = 1; i < 5000; i++) {
            new Thread(() -> {
                Resume r = new Resume("name", "location");
                try {
                    storage.save(r);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    storage.load(r.getUuid());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                storage.delete(r.getUuid());

                try {
                    storage.getAllSorted();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(5000);
    }

}
package main.storage;

import main.model.Contact;
import main.model.ContactType;
import main.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Maks
 * 07.02.2020.
 */
class ArrayStorageTests {

    private Resume R1, R2, R3;

    private ArrayStorage storage = new ArrayStorage();

    @BeforeClass
    public static void BeforeClass(){
        //same as block static
    }

    @Before
    public void Before(){
        R1 = new Resume("fullname1","location1");
        R1.addContact(new Contact(ContactType.MAIL, "failahdux@yandex.ru"));
        R1.addContact(new Contact(ContactType.MOBILE, "6385069"));

        R2 = new Resume("fullname2",null);
        R2.addContact(new Contact(ContactType.SKYPE, "sandcastle"));
        R2.addContact(new Contact(ContactType.PHONE, "6385069"));
        R3 = new Resume("fullname3",null);
        storage.clear();
        storage.save(R2);
        storage.save(R1);
        storage.save(R3);
    }

    @Test
    void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    void save() {
    }

    @Test
    void update() {
        R2.setFullName("UpdateName N2");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    void load() {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test
    void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @Test
    void getAllSorted() {
        Resume[] src = new Resume[]{R1,R2,R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getAllSorted().toArray());
    }

    @Test
    void size() {
        Assert.assertEquals(3,storage.size());
    }
}
package main.storage;

import main.MainExeption;
import main.model.Contact;
import main.model.ContactType;
import main.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

abstract public class AbstractStorageTest  {
    private static Resume R1, R2, R3;

    protected IStorage storage;

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
    public void clear() {
        storage.clear();
        assertEquals(0,storage.size());
    }

    @Test
    public void save() {

    }

    @Test
    public void update() {
        R2.setFullName("UpdateName N2");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    public void load() {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test(expected = MainExeption.class)
    public void delete() {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @Test
    public void getAllSorted() {
        Resume[] src = new Resume[]{R1,R2,R3};
        Arrays.sort(src);
        assertArrayEquals(src, storage.getAllSorted().toArray());
    }

    @Test
    public void size() {
        assertEquals(3,storage.size());
    }

    @Test(expected = MainExeption.class)
    public void deleteMissed(){
        storage.delete("dummy");
    }

    @Test(expected = MainExeption.class)
    public void savePresented(){
        storage.save(R1);
    }

    @Test(expected = MainExeption.class)
    public void updateMissed(){
        Resume resume = new Resume("dummy","fullName_up1", "location_up1");
        storage.update(resume);
    }
}

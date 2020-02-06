package main.storage;

import main.model.Contact;
import main.model.ContactType;
import main.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeClass;
import org.testng.internal.annotations.IBeforeClass;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Maks
 * 06.02.2020.
 */
class ArrayStorageTest {
private static Resume R1, R2, R3;

private ArrayStorage storage = new ArrayStorage();

static {
    R1 = new Resume("fullname1","location1");
    R1.addContact(new Contact(ContactType.MAIL, "failahdux@yandex.ru"));
    R1.addContact(new Contact(ContactType.MOBILE, "6385069"));

    R2 = new Resume("fullname2",null);
    R2.addContact(new Contact(ContactType.SKYPE, "sdjvcl_asklcj"));
    R2.addContact(new Contact(ContactType.PHONE, "6385069"));
    R3 = new Resume("fullname3",null);
}
@BeforeClass
public static void BeforeClass(){
    //same as block static
}

@Before
public void Before(){
    storage.clear();
    storage.save(R1);
    storage.save(R2);
    storage.save(R3);
}

    @org.junit.jupiter.api.Test
    void clear() {
    }

    @org.junit.jupiter.api.Test
    void save() {

    }

    @org.junit.jupiter.api.Test
    void update() {
    }

    @org.junit.jupiter.api.Test
    void load() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    storage.delete(R1.getUuid());
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @org.junit.jupiter.api.Test
    void getAllSorted() {
    }

    @org.junit.jupiter.api.Test
    void size() {
        Assert.assertEquals(3,storage.size());
    }
}
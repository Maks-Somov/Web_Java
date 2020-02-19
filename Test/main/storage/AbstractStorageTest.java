package main.storage;

import main.MainExeption;
import main.model.ContactType;
import main.model.Resume;
import main.model.SectionType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

abstract public class AbstractStorageTest  {
    private static Resume R1, R2, R3;

    protected IStorage storage;

    @BeforeClass
    public static void BeforeClass(){
        //same as block static
    }

    @Before
    public void Before() throws Exception {
        R1 = new Resume("fullname1","location1");
        R1.addContact(ContactType.MAIL, "failahdux@yandex.ru");
        R1.addContact(ContactType.MOBILE, "6385069");

        R2 = new Resume("fullname2","location2");
        R2.addContact(ContactType.SKYPE, "sandcastle");
        R2.addContact(ContactType.PHONE, "6385069");
        R3 = new Resume("fullname3","location3");
        R1.addObjective("Objective1");
        R1.addMultiTextSection(SectionType.ACHIEVEMENT, "Achivement11", "Achivement12");
        R1.addMultiTextSection(SectionType.QUALIFICATIONS, "Java", "SQL");
        /* TODO add EXPERIENSE and EDUCATION */

//        R1.addOrganizationSection(SectionType.EXPERIENCE, new Organization("Organization11", null,
//                new Organization.Period(LocalDate.of(2005, Month.JANUARY,1), Organization.Period.NOW, "position1", "content1"),
//                new Organization.Period(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2")),
//                new Organization("Organization12", "http://Organization12.ru"));
        storage.clear();
        storage.save(R2);
        storage.save(R1);
        storage.save(R3);
    }

    @Test
    public void clear() throws Exception{
        storage.clear();
        assertEquals(0,storage.size());
    }

    @Test
    public void save() throws Exception{

    }

    @Test
    public void update() throws Exception {
        R2.setFullName("UpdateName N2");
        storage.update(R2);
        assertEquals(R2, storage.load(R2.getUuid()));
    }

    @Test
    public void load() throws Exception {
        assertEquals(R1, storage.load(R1.getUuid()));
        assertEquals(R2, storage.load(R2.getUuid()));
        assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test(expected = MainExeption.class)
    public void delete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2,storage.size());
        Assert.assertEquals(null,storage.load(R1.getUuid()));
    }

    @Test
    public void getAllSorted() throws Exception {
//        Resume[] src = new Resume[]{R1,R2,R3};
//        Arrays.sort(src);
//        assertArrayEquals(src, storage.getAllSorted().toArray());
        List<Resume> list = Arrays.asList(R1,R2,R3);
        Collections.sort(list, new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
//                int cmp=o1.getFullName().compareTo(o2.getFullName());
//                if(cmp!=0) return cmp;
//                List<Contact> email = o1.getContacts();
//                for(Contact c : email) {
//                    if(c.getType()==ContactType.MAIL){
//                        c.getValue();
//                    }
//                }
//                return o1.compareTo();
                return 0;
            }
        });
        assertEquals(list,storage.getAllSorted());

    }

    @Test
    public void size()throws Exception {
        assertEquals(3,storage.size());
    }

    @Test(expected = MainExeption.class)
    public void deleteMissed()throws Exception{
        storage.delete("dummy");
    }

    @Test(expected = MainExeption.class)
    public void savePresented() throws Exception {
        storage.save(R1);
    }

    @Test(expected = MainExeption.class)
    public void updateMissed() throws Exception {
        Resume resume = new Resume("dummy","fullName_up1", "location_up1");
        storage.update(resume);
    }


}

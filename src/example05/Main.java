package example05;

import main.model.ContactType;
import main.model.Resume;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Comparator<Resume> comparator = new Comparator<Resume>() {
            @Override
            public int compare(Resume o1, Resume o2) {
                System.out.println(this.getClass().getSimpleName());
                return 0;
            }
        };
        System.out.println(comparator);

        Resume R1 = new Resume("fullname1","location1");
        R1.addContact(ContactType.MAIL, "failahdux@yandex.ru");
        R1.addContact(ContactType.MOBILE, "6385069");
        Resume R2 = new Resume("fullname2",null);
        R2.addContact(ContactType.SKYPE, "sandcastle");
        R2.addContact(ContactType.PHONE, "6385069");
        Resume R3 = new Resume("fullname3",null);


        List<Resume> resumes = Arrays.asList(R1,R2,R3);
        print(resumes);
    }
    public static void print(List<Resume> list){
        list.forEach(r->r.toString());
    }
}

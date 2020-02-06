package example03;

import main.model.Contact;
import main.model.ContactType;
import main.model.Link;

import java.lang.reflect.Field;

/**
 * Maks
 * 06.02.2020.
 */
public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Contact c = new Contact(ContactType.PHONE, "+375296666666");

        Field field = Link.class.getDeclaredField("url");
        field.setAccessible(true);
        Link link = new Link("sdfs", "URL");
        System.out.println(field.get(link));
        System.out.println(link.getUrl());
    }




}

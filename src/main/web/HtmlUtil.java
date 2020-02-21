package main.web;

import main.model.ContactType;
import main.model.Organization;
import main.model.Resume;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HtmlUtil {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    public static String getContact(Resume r, ContactType type){
        String contact = r.getContact(type);
        return contact==null?"&nbsp;":type.toHTML(contact);
    }

    public static String format(LocalDate date){
        return date.equals(Organization.Period.NOW)?"Now":date.format(DATE_FORMATTER);
    }
}

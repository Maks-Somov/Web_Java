package main.model;

import java.io.Serializable;

/**
 * Maks
 * 06.02.2020.
 */
public enum ContactType implements Serializable {
    PHONE("Телефон"),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний"),
    SKYPE("Скайп"){
        @Override
        public String toHTML(String value){return "a href='skype:" + value + "'>" + value+"</a>";}
    },
    MAIL("Почта"){
        @Override
        public String toHTML(String value){return "a href='mailto:" + value + "'>" + value+"</a>";}
    },
    ICQ("ICQ");

    static final long serialVersionUID = 1L;
    private String tittle;
    public static ContactType[] VALUES = ContactType.values();

    ContactType(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }
    public String toHTML(String value){
        return tittle+": "+value;
    }
}

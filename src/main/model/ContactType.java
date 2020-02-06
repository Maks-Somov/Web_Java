package main.model;

/**
 * Maks
 * 06.02.2020.
 */
public enum ContactType {
    PHONE("Телефон"),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний"),
    SKYPE("Скайп"),
    MAIL("Почта"),
    ICQ("ICQ");

    private String tittle;

    ContactType(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }
}

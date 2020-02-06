package main.model;

/**
 * Maks
 * 06.02.2020.
 */
public enum SectionType {
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");


private String tittle;

    SectionType(String tittle) {
        this.tittle = tittle;
    }
    public String getTittle() {
        return tittle;
    }
}

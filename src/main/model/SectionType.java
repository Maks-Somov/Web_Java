package main.model;

import java.io.Serializable;

/**
 * Maks
 * 06.02.2020.
 */
public enum SectionType implements Serializable {
    OBJECTIVE("Позиция"),
    ACHIEVEMENT("Достижения"),
    QUALIFICATIONS("Квалификация"),
    EXPERIENCE("Опыт работы"),
    EDUCATION("Образование");

    static final long serialVersionUID = 1L;

    private String tittle;

    SectionType(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }
}

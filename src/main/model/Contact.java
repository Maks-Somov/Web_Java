package main.model;

import java.io.Serializable;

//ненужен
public class Contact implements Serializable {
    static final long serialVersionUID = 1L;

    private final ContactType type;
    private final String value;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}
